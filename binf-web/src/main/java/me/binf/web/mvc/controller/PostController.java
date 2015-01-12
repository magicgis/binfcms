package me.binf.web.mvc.controller;

import me.binf.api.PostServiceApi;
import me.binf.utils.JsonUtil;
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

    @RequestMapping(value = "/{code:\\d+}")
    public String postIndex(HttpServletRequest request,
                            HttpServletResponse response,
                            ModelMap model,
                            @PathVariable Integer code){

        String  postJson = postService.findPostById(code);
        Object  post = JsonUtil.fromJsonToAnyObject(postJson);
        model.put("post",post) ;
        return "template/post";
    }



}
