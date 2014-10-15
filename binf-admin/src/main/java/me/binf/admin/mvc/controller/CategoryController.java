package me.binf.admin.mvc.controller;

import me.binf.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangbin on 14-10-14.
 */
@Controller
@RequestMapping(value = "content")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "category")
    public String category(HttpServletRequest request,
                        HttpServletResponse response,
                        ModelMap model){

        return "template/admin/文章分类";
    }




}
