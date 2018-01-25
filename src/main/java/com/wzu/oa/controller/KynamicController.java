package com.wzu.oa.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.wzu.oa.common.entity.Application;
import com.wzu.oa.common.entity.DTO.KynamicDTO;
import com.wzu.oa.common.entity.Kynamic;
import com.wzu.oa.common.util.OAFileUtils;
import com.wzu.oa.service.KynamicService;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/**
 * @author jack
 * @date 2018-01-16   17:13
 */
@Controller
public class KynamicController {

    @Resource
    private KynamicService kynamicService;


    /**
     * 获取知识管理页面
     *
     * @return
     */
    @RequiresPermissions("知识管理")
    @RequestMapping("/LanDiskFolder/list")
    public String list(Model model) {
        List<KynamicDTO> kynamicDTOList = kynamicService.getRootKynamicList();
        model.addAttribute("kynamicDTOList", kynamicDTOList);
        Kynamic kynamic = kynamicService.getRootKynamic();
        model.addAttribute("currentPath", "/"+kynamic.getName());
        model.addAttribute("currentId",kynamic.getId());
        return "/LanDiskFolder/list";
    }


    /**
     * 根据pid展示该目录下所有数据
     *
     * @return
     */
    @RequestMapping("/LanDiskFolder/showCurrentNodeList")
    public String showCurrentNodeList(Model model, Kynamic kynamic) {
        List<KynamicDTO> kynamicDTOList = kynamicService.getCurrentNodeList(kynamic.getId());
        model.addAttribute("kynamicDTOList", kynamicDTOList);
        String currentPath = kynamicService.getCurrentPathById(kynamic.getId());
        model.addAttribute("currentPath", currentPath);
        Kynamic currentKynamic = kynamicService.getKynamicById(kynamic.getId());
        if (currentKynamic != null)
            model.addAttribute("pid", currentKynamic.getPid());
        model.addAttribute("currentId",kynamic.getId());
        return "/LanDiskFolder/list";
    }


    /**
     * json返回知识管理树数据
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/LanDiskFolder/showKynamicTree")
    public List<Kynamic> showKynamicTree() {
        List<Kynamic> allKynamic = kynamicService.getAllKynamic();
        return allKynamic;
    }


    /**
     * 跳转saveUI添加文件夹界面
     * @param model
     * @param currentPath
     * @param pid
     * @return
     */
    @RequestMapping("/LanDiskFolder/saveUI")
    public String saveUI(Model model, String currentPath, Integer pid) {
        model.addAttribute("currentPath",currentPath);
        if (pid==null){
            Kynamic rootKynamic = kynamicService.getRootKynamic();
            pid = rootKynamic.getId();
        }
        model.addAttribute("pid",pid);
        return "/LanDiskFolder/saveUI";
    }


    /**
     * 添加文件夹
     * @param model
     * @param kynamic
     * @return
     */
    @RequestMapping("/LanDiskFolder/addOrUpdateFolder")
    public String addOrUpdateFolder(Model model,Kynamic kynamic) {
        kynamic.setIsParent(true);
        kynamic.setCreateTime(new Date());
        kynamicService.addOrUpdateKynamic(kynamic);
        //注意传pid，否则会报错
        return "redirect:/LanDiskFolder/showCurrentNodeList?id="+kynamic.getPid();
    }


    /**
     * 跳转addUI添加文件界面
     * @param model
     * @param currentPath
     * @param pid
     * @return
     */
    @RequestMapping("/LanDiskUploadFile/addUI")
    public String addUI(Model model, String currentPath, Integer pid) {
        model.addAttribute("currentPath",currentPath);
        if (pid==null){
            Kynamic rootKynamic = kynamicService.getRootKynamic();
            pid = rootKynamic.getId();
        }
        model.addAttribute("pid",pid);
        return "/LanDiskUploadFile/addUI";
    }


    /**
     * 上传文件
     * @param model
     * @param kynamic
     * @param resource
     * @return
     */
    @RequestMapping(value = "/LanDiskFolder/uploadFile",method = RequestMethod.POST)
    public String uploadFile(Model model, Kynamic kynamic, MultipartFile resource) {
        String filename = resource.getOriginalFilename();
        kynamic.setIsParent(false);
        kynamic.setCreateTime(new Date());
        kynamic.setName(filename);
        String saveFilePath = OAFileUtils.saveFile(resource);
        kynamic.setDocFilePath(saveFilePath);
        kynamicService.addOrUpdateKynamic(kynamic);
        return "redirect:/LanDiskFolder/showCurrentNodeList?id="+kynamic.getPid();
    }


    /**
     * 跳转属性页面
     * @param model
     * @param currentPath
     * @param kynamic
     * @return
     */
    @RequestMapping("/LanDiskFolder/folderAttribution")
    public String addUI(Model model, String currentPath, Kynamic kynamic) {
        model.addAttribute("currentPath",currentPath);
        model.addAttribute("kynamic",kynamic);
        model.addAttribute("pid",kynamic.getPid());
        return "/LanDiskFolder/saveUI";
    }


    /**
     * 跳转属性页面
     * @param model
     * @param currentPath
     * @param kynamic
     * @return
     */
    @RequestMapping("/LanDiskUploadFile/fileAttribution")
    public String fileAttribution(Model model, String currentPath, Kynamic kynamic) {
        model.addAttribute("currentPath",currentPath);
        model.addAttribute("kynamic",kynamic);
        return "/LanDiskUploadFile/editUI";
    }


    /**
     * 更新file类型的文件描述
     * @param kynamic
     * @return
     */
    @RequestMapping(" /LanDiskUploadFile/updateFileDesc")
    public String updateFileDesc(Kynamic kynamic) {
        kynamicService.updateFileKynamic(kynamic);
        return "redirect:/LanDiskFolder/showCurrentNodeList?id="+kynamic.getPid();
    }


    /**
     * 跳转重命名文件UI
     * @param model
     * @param kynamic
     * @return
     */
    @RequestMapping("/LanDiskUploadFile/renameFileUI")
    public String renameFileUI(Model model, Kynamic kynamic) {
        model.addAttribute("kynamic",kynamic);
        return "/LanDiskUploadFile/renameUI";
    }


    /**
     * 跳转重命名文件夹UI
     * @param model
     * @param kynamic
     * @return
     */
    @RequestMapping("/LanDiskFolder/renameFolderUI")
    public String renameFolderUI(Model model, Kynamic kynamic) {
        model.addAttribute("kynamic",kynamic);
        return "/LanDiskFolder/renameUI";
    }


    /**
     * 重命名Kynamic
     * @param model
     * @param kynamic
     * @return
     */
    @RequestMapping("/LanDiskFolder/renameKynamic")
    public String renameKynamic(Model model, Kynamic kynamic, String oldName) {
        boolean result = kynamicService.updateKynamicName(kynamic);
        if (!result){
            kynamic.setName(oldName);
            model.addAttribute("kynamic",kynamic);
            if (kynamic.getIsParent()==true){
                model.addAttribute("msg","文件夹名称重复");
                return "/LanDiskFolder/renameUI";
            }else {
                model.addAttribute("msg","文件名称重复");
                return "/LanDiskUploadFile/renameUI";
            }
        }
        return "redirect:/LanDiskFolder/showCurrentNodeList?id="+kynamic.getPid();
    }


    /**
     * 删除节点
     * @param kynamic
     * @return
     */
    @RequestMapping("/LanDiskFolder/deleteNode")
    public String deleteNode(Model model, Kynamic kynamic) {
        boolean result = kynamicService.deleteKynamicById(kynamic.getId());
        if(!result){
            model.addAttribute("msg","删除失败，有子节点！");
        }
        return "forward:/LanDiskFolder/showCurrentNodeList?id="+kynamic.getPid();
    }


    /**
     * 下载上传的文件
     * @param kynamic
     * @return
     */
    @RequestMapping("/LanDiskUploadFile/downloadFile")
    public ResponseEntity<byte[]> deleteNode(Kynamic kynamic) {
        kynamic = kynamicService.getKynamicById(kynamic.getId());
        String docFilePath = kynamic.getDocFilePath();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        if (docFilePath != null && !docFilePath.equals("")) {
            File file = new File(docFilePath);
            if (file.exists()) {
                String fileName = kynamic.getName();
                try {
                    fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                headers.setContentDispositionFormData("attachment", fileName);
                try {
                    return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                            headers, HttpStatus.OK);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new ResponseEntity<byte[]>(headers, HttpStatus.OK);
    }




}
