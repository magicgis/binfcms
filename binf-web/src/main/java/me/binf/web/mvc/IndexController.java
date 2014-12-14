package me.binf.web.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangbin on 2014/12/14.
 */
@Controller
public class IndexController {


    @RequestMapping("/")
    public String index(){

        return "template/首页";
    }

}
