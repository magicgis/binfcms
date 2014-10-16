package me.binf.admin.mvc.controller;

import me.binf.entity.Category;
import me.binf.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
public class ContentController {

    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "category")
    public String category(HttpServletRequest request,
                           HttpServletResponse response,
                           ModelMap model){

        Page<Category> categoryPage = categoryService.find(1);


        return "template/admin/类别管理";
    }




}
