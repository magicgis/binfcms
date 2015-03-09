package me.binf.web.mvc.controller;

import me.binf.api.PostServiceApi;
import me.binf.utils.JsonUtil;
import me.binf.web.core.Configue;
import me.binf.web.service.FreeMarkForHtmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangbin on 2015/1/11.
 */
@Controller
public class PostController {

    @Autowired
    private PostServiceApi postService;

    @Autowired
    private FreeMarkForHtmlService freeMarkForHtmlService;


    @RequestMapping(value = "/{code:\\d+}")
    public String postIndex(HttpServletRequest request,
                            HttpServletResponse response,
                            ModelMap model,
                            @PathVariable Integer code) {

        String postJson = postService.findPostById(code);
        Object post = JsonUtil.fromJsonToAnyObject(postJson);
        model.put("post", post);
        return "template/post";
    }


    @RequestMapping(value = "/archives/{year:\\d+}/{month:\\d+}")
    public String archives(HttpServletRequest request,
                            HttpServletResponse response,
                            ModelMap model,
                            @PathVariable Integer year,
                            @PathVariable Integer month) {

        System.out.println(year);
        System.out.println(month);


        return "template/archives";
    }



    @RequestMapping(value = "/create")
    public void createPostIndex(HttpServletRequest request,
                                HttpServletResponse response,
                                ModelMap model) {

        String postJson = postService.findPostById(1);
        Object post = JsonUtil.fromJsonToAnyObject(postJson);
        model.put("post", post);

        try {
            String path = Configue.getSystemHtmlPath() + "/info";
            freeMarkForHtmlService.geneHtmlFile("/template/",
                    "post.html",
                    path,
                    "1.html",
                    model);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
