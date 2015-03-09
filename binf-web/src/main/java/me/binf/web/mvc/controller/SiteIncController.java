package me.binf.web.mvc.controller;

import me.binf.api.PostServiceApi;
import me.binf.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangbin on 2015/3/9.
 */
@Controller
@RequestMapping(value = "site/inc")
public class SiteIncController {


    @Autowired
    private PostServiceApi postService;

    @RequestMapping(value = "/sidebar")
    public String sidebarInc(HttpServletRequest request,
                                   HttpServletResponse response,
                                   ModelMap model){
        String dateListStr =   postService.dateList();
        Object  dateList = JsonUtil.fromJsonToAnyObject(dateListStr);
        model.put("dateList",dateList) ;
        return "template/inc/sidebar";
    }


}
