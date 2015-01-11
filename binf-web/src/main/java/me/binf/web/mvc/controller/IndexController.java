package me.binf.web.mvc.controller;

import me.binf.api.PostServiceApi;
import me.binf.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by wangbin on 2014/12/14.
 */
@Controller
public class IndexController {


    @Autowired
    private PostServiceApi postService;



    @RequestMapping("/")
    public String index(HttpServletRequest request,
                        HttpServletResponse response,
                        ModelMap model){
        String  pages =  postService.find(0, 20);

        Object  posts = JsonUtil.fromJsonToAnyObject(pages);

        model.put("posts",posts) ;
        return "template/index";
    }


    @RequestMapping("post")
    public String post(){
        System.out.println(postService.findAll());

        return "template/index";
    }



}
