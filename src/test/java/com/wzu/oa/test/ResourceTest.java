package com.wzu.oa.test;

import com.wzu.oa.common.entity.Resource;
import com.wzu.oa.service.ResourceService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * @author jack
 * @date 2018-01-24   10:42
 */
public class ResourceTest extends BaseJunitTest {

    @javax.annotation.Resource
    private ResourceService resourceService;

    @Test
    public void addResource(){

        List<Resource> resources = new ArrayList<>();
		/**
		 * 个人办公
		 */
        Resource Menuitem1 = new Resource();
        Menuitem1.setId(1);
        Menuitem1.setIcon("/style/images/MenuIcon/FUNC20057.gif");
        Menuitem1.setName("审批流转");
        Menuitem1.setPid(0);
        Menuitem1.setIsParent(true);

        Resource Menuitem11 = new Resource();
        Menuitem11.setId(11);
        Menuitem11.setIcon("/style/images/MenuIcon/manager.gif");
        Menuitem11.setName("审批流程管理");
        Menuitem11.setPid(1);
        Menuitem11.setIsParent(false);
        Menuitem11.setTarget("right");
        Menuitem11.setUrl("/FlowProcessDefinition/list");

        Resource Menuitem12 = new Resource();
        Menuitem12.setId(12);
        Menuitem12.setIcon("/style/images/MenuIcon/formmodel.gif");
        Menuitem12.setName("表单模板管理");
        Menuitem12.setPid(1);
        Menuitem12.setIsParent(false);
        Menuitem12.setTarget("right");
        Menuitem12.setUrl("/FlowFormTemplate/list");

        Resource Menuitem13 = new Resource();
        Menuitem13.setId(13);
        Menuitem13.setIcon("/style/images/MenuIcon/FUNC241000.gif");
        Menuitem13.setName("发起申请");
        Menuitem13.setPid(1);
        Menuitem13.setIsParent(false);
        Menuitem13.setTarget("right");
        Menuitem13.setUrl("/FlowFormFlow/formTemplateList");

        Resource Menuitem14 = new Resource();
        Menuitem14.setId(14);
        Menuitem14.setIcon("/style/images/MenuIcon/FUNC20029.gif");
        Menuitem14.setName("审批处理");
        Menuitem14.setPid(1);
        Menuitem14.setIsParent(false);
        Menuitem14.setTarget("right");
        Menuitem14.setUrl("/FlowFormFlow/myTaskList");

        Resource Menuitem15 = new Resource();
        Menuitem15.setId(15);
        Menuitem15.setIcon("/style/images/MenuIcon/FUNC20029.gif");
        Menuitem15.setName("查询状态");
        Menuitem15.setPid(1);
        Menuitem15.setIsParent(false);
        Menuitem15.setTarget("right");
        Menuitem15.setUrl("/FlowFormFlowOld/mySubmittedList");


        /**
         * 知识管理
         */
        Resource Menuitem2 = new Resource();
        Menuitem2.setId(2);
        Menuitem2.setIcon("/style/images/MenuIcon/FUNC20056.gif");
        Menuitem2.setName("知识管理");
        Menuitem2.setPid(0);
        Menuitem2.setIsParent(false);
        Menuitem2.setTarget("right");
        Menuitem2.setUrl("/LanDiskFolder/list");

        /**
         * 实用工具
         */
        Resource Menuitem3 = new Resource();
        Menuitem3.setId(3);
        Menuitem3.setIcon("/style/images/MenuIcon/FUNC20076.gif");
        Menuitem3.setName("实用工具");
        Menuitem3.setPid(0);
        Menuitem3.setIsParent(true);

        Resource Menuitem31 = new Resource();
        Menuitem31.setId(31);
        Menuitem31.setIcon("/style/images/MenuIcon/FUNC220000.gif");
        Menuitem31.setName("车票预定");
        Menuitem31.setPid(3);
        Menuitem31.setIsParent(false);
        Menuitem31.setUrl("http://www.12306.cn");

        Resource Menuitem32 = new Resource();
        Menuitem32.setId(32);
        Menuitem32.setIcon("/style/images/MenuIcon/FUNC249000.gif");
        Menuitem32.setName("飞机航班");
        Menuitem32.setPid(3);
        Menuitem32.setIsParent(false);
        Menuitem32.setUrl("http://www.airchina.com.cn");

        Resource Menuitem33 = new Resource();
        Menuitem33.setId(33);
        Menuitem33.setIcon("/style/images/MenuIcon/FUNC249000.gif");
        Menuitem33.setName("邮政编码");
        Menuitem33.setPid(3);
        Menuitem33.setIsParent(false);
        Menuitem33.setUrl("http://www.yb21.cn");



        /**
         * 个人设置
         */
        Resource Menuitem4 = new Resource();
        Menuitem4.setId(4);
        Menuitem4.setIcon("/style/images/MenuIcon/FUNC20001.gif");
        Menuitem4.setName("个人设置");
        Menuitem4.setPid(0);
        Menuitem4.setIsParent(true);

        Resource Menuitem41 = new Resource();
        Menuitem41.setId(41);
        Menuitem41.setIcon("/style/images/MenuIcon/FUNC20001.gif");
        Menuitem41.setName("个人信息");
        Menuitem41.setPid(4);
        Menuitem41.setIsParent(false);
        Menuitem41.setTarget("right");
        Menuitem41.setUrl("/PersonConfig/editUserInfoUI");


        Resource Menuitem42 = new Resource();
        Menuitem42.setId(42);
        Menuitem42.setIcon("/style/images/MenuIcon/FUNC241000.gif");
        Menuitem42.setName("密码修改");
        Menuitem42.setPid(4);
        Menuitem42.setIsParent(false);
        Menuitem42.setTarget("right");
        Menuitem42.setUrl("/PersonConfig/editPasswordUI");


        /**
         * 系统管理
         */
        Resource Menuitem5 = new Resource();
        Menuitem5.setId(5);
        Menuitem5.setIcon("/style/images/MenuIcon/system.gif");
        Menuitem5.setName("系统管理");
        Menuitem5.setPid(0);
        Menuitem5.setIsParent(true);

        Resource Menuitem51 = new Resource();
        Menuitem51.setId(51);
        Menuitem51.setIcon("/style/images/MenuIcon/FUNC20001.gif");
        Menuitem51.setName("岗位管理");
        Menuitem51.setPid(5);
        Menuitem51.setIsParent(false);
        Menuitem51.setTarget("right");
        Menuitem51.setUrl("/SystemRole/list");

        Resource Menuitem52 = new Resource();
        Menuitem52.setId(52);
        Menuitem52.setIcon("/style/images/MenuIcon/department.gif");
        Menuitem52.setName("部门管理");
        Menuitem52.setPid(5);
        Menuitem52.setIsParent(false);
        Menuitem52.setTarget("right");
        Menuitem52.setUrl("/SystemDepartment/list");

        Resource Menuitem53 = new Resource();
        Menuitem53.setId(53);
        Menuitem53.setIcon("/style/images/MenuIcon/FUNC20001.gif");
        Menuitem53.setName("用户管理");
        Menuitem53.setPid(5);
        Menuitem53.setIsParent(false);
        Menuitem53.setTarget("right");
        Menuitem53.setUrl("/SystemUser/list");

        resources.add(Menuitem1);
        resources.add(Menuitem11);
        resources.add(Menuitem12);
        resources.add(Menuitem13);
        resources.add(Menuitem14);
        resources.add(Menuitem15);

        resources.add(Menuitem2);

        resources.add(Menuitem3);
        resources.add(Menuitem31);
        resources.add(Menuitem32);
        resources.add(Menuitem33);

        resources.add(Menuitem4);
        resources.add(Menuitem41);
        resources.add(Menuitem42);

        resources.add(Menuitem5);
        resources.add(Menuitem51);
        resources.add(Menuitem52);
        resources.add(Menuitem53);

        resourceService.addResource(resources);

    }
}
