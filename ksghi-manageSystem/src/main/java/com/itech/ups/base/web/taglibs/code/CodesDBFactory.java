package com.itech.ups.base.web.taglibs.code;

import com.itech.core.util.StringHelper;
import com.itech.ups.app.authority.application.domain.Role;
import com.itech.ups.app.system.authority.application.infrastructure.AuthorityRepository;
import com.itech.ups.base.web.listener.WebAppContextListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

public class CodesDBFactory {

    private static CodesDBFactory instance = null;

    public static CodesDBFactory getInstance() {
        if (instance == null) {
            instance = new CodesDBFactory();
        }
        return instance;
    }

    public static void main(String[] test) {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath*:config/spring/applicationContext*.xml"});
        String name = "userClassification";
        Code code = new Code(name);


        System.out.println("items's size===" + code.getItems().size());
    }

    // 从数据库加载字典数据
    // label-general-register\:普通会员;label-general-recommend\:普通会员推荐;org-KFB-register\:君德财富北京中心(KFB)用户;org-KFB-recommend\:君德财富北京中心(KFB)推荐;
    public Code getCodeByDB(String name) {
        Code code = new Code(name);
        WebApplicationContext context = WebAppContextListener.springContext;

        if ("managerRole".equals(name)) {// 新增 管理员角色下拉框
            AuthorityRepository authorityRepository = (AuthorityRepository) context.getBean("authorityRepository");
            String roleName = "";
            String roleId = "";
            List<Role> list = authorityRepository.findAllRoles();
            if (list != null && list.size() > 0) {
                for (Role role : list) {
                    roleName = role.getName();
                    roleId = role.getId();
                    if (StringHelper.isNotEmpty(roleName)) {
                        code.addItem(roleId, roleName);
                    }
                }
            } else {
                code.addItem("数据库暂无数据", "数据库暂无数据");
            }
        } else {
            code.addItem("数据库暂无数据", "数据库暂无数据");

        }
        return code;
    }
}
