package me.binf.admin.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 14-10-11.
 */
@Controller
@RequestMapping(value = "admin")
public class IndexController {

    @RequestMapping(value = "index")
    public String index(){

        return "index";
    }


}
