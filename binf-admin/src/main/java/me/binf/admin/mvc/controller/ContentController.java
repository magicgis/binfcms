package me.binf.admin.mvc.controller;

import me.binf.admin.utils.Logger;
import me.binf.admin.utils.WebUtil;
import me.binf.core.bean.Result;
import me.binf.entity.Category;
import me.binf.service.CategoryService;
import me.binf.utils.DataTableFactory;
import me.binf.utils.JsonUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

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
        return "template/admin/类别管理";
    }

    @RequestMapping(value = "category/save")
    public void categorySave(HttpServletRequest request,
                             HttpServletResponse response,
                             Category category){
        try {
            Category data = categoryService.create(category);
            WebUtil.print(response,new Result(true).data(data).msg("创建类别成功！"));
        }catch (Exception e){
            Logger.error("创建类别失败",e);
            WebUtil.print(response,new Result(false).msg("创建类别失败"));
        }
    }

    @RequestMapping(value = "category/tree")
    public void categoryTree(HttpServletRequest request,
                             HttpServletResponse response,
                             String scriptName){
        String tree = categoryService.tree(null);
        WebUtil.printJson(response, "var "+ scriptName+"="+tree);
    }

    @RequestMapping(value = "category/list")
    public void categoryList(HttpServletRequest request,
                             HttpServletResponse response,
                             Integer draw,
                             Integer start,
                             Integer length){
        if(start==null){
            start = 0;
        }
        Page<Category> page = categoryService.find(start,length);
        Map<String,Object> result = DataTableFactory.fitting(draw,page);
        WebUtil.printJson(response,result);
    }

    @RequestMapping(value = "category/delete")
    public void categoryDel(HttpServletRequest request,
                            HttpServletResponse response,
                            String ids){
        try {
            int[] arrayId =  JsonUtil.json2Obj(ids,int[].class);
            categoryService.deleteAll(arrayId);
            WebUtil.print(response,new Result(true).msg("删除类别成功！"));
        }catch (Exception e){
            Logger.error(e.getMessage(),e);
            WebUtil.print(response,new Result(false).msg("删除类别失败！"));
        }

    }



}
