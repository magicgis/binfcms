package me.binf.admin.mvc.controller;

import me.binf.admin.service.LoginService;
import me.binf.dao.MemberDao;
import me.binf.entity.Member;
import me.binf.service.MemberService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 14-10-11.
 */
@Controller
public class IndexController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request,
                        HttpServletResponse response,
                        String error,
                        ModelMap model){
        if(StringUtils.isNotBlank(error)){
            model.addAttribute("error",error);
        }
        return "template/admin/登录";
    }


    @RequestMapping(value = "/login/check")
    public String checkLogin(String username,
                        String password,
                        HttpServletRequest request,
                        ModelMap model){

        Boolean success = loginService.login(username,password,request);
        if(success){
            return "redirect:/dashboard";
        }
        model.addAttribute("error","用户名或密码错误!");
        return "redirect:/";
    }


    @RequestMapping(value = "/dashboard")
    public String dashboard(HttpServletRequest request,
                        HttpServletResponse response,
                        ModelMap model){

        return "template/admin/控制面板";
    }

    @RequestMapping(value = "/")
    public String index(HttpServletRequest request,
                            HttpServletResponse response,
                            ModelMap model){

        return "template/admin/控制面板";
    }


}
