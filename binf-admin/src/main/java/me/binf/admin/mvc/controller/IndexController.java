package me.binf.admin.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 14-10-11.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "index")
    public String index(HttpServletRequest request,
                        HttpServletResponse response,
                        ModelMap model){

        model.put("hello","hello");
        return "template/index";
    }


}
