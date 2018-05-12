package com.wzu.oa.common.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author jack
 * @date 2017/12/22   10:43
 */
public  class OAFileUtils {

    /**
     * 存储文件工具方法
     * @param file  输入保存文件
     * @return path 返回保存路径
     */
    public static String saveFile(MultipartFile file){
        String name = file.getOriginalFilename();
        String[] strings = name.split("\\.");
        String suffix = "";
        if (strings.length>1)
             suffix = strings[strings.length-1];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("/yyyy/M/dd");
        String format = simpleDateFormat.format(new Date());
        File saveFile = new File("F:\\update\\"+format);
        if (!saveFile.exists()){
            saveFile.mkdirs();
        }
        String savePath = saveFile.getPath() + File.separator + UUID.randomUUID().toString();
        if (!suffix.equals(""))
            savePath+="."+suffix;
        File target = new File(savePath);
        try {
            file.transferTo(target);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return target.getPath();
    }



}
