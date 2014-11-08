package me.binf.admin.mvc.controller;

import me.binf.admin.utils.DataTableFactory;
import me.binf.admin.utils.WebUtil;
import me.binf.core.bean.Result;
import me.binf.entity.Category;
import me.binf.exception.GeneralExceptionHandler;
import me.binf.service.CategoryService;
import me.binf.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

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
            Category data = null;
            if(category.getId()==null){
                data = categoryService.create(category);
            }else{
                data = categoryService.update(category);
            }
            WebUtil.print(response,new Result(true).data(data).msg("创建类别成功！"));
        }catch (Exception e){
            GeneralExceptionHandler.log("创建类别失败", e);
            WebUtil.print(response, new Result(false).msg("创建类别失败"));
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
        Map<String,Object> result = DataTableFactory.fitting(draw, page);
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
            GeneralExceptionHandler.log("删除类别失败",e);
            WebUtil.print(response,new Result(false).msg("删除类别失败！"));
        }

    }

    @RequestMapping(value = "post")
    public String post(HttpServletRequest request,
                     HttpServletResponse response){

        return "template/admin/新建文章";

    }



}
