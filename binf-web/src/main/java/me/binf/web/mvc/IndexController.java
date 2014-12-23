package me.binf.web.mvc;

import me.binf.api.PostServiceApi;
import me.binf.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by wangbin on 2014/12/14.
 */
@Controller
public class IndexController {


    @Autowired
    private PostServiceApi postService;



    @RequestMapping("/")
    public String index(){

        return "template/index";
    }


    @RequestMapping("post")
    public String post(){


        return "template/index";
    }
}
