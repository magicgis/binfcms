package me.binf.admin.mvc.controller;

import me.binf.admin.service.LoginService;
import me.binf.admin.utils.DataTableFactory;
import me.binf.admin.utils.WebUtil;
import me.binf.core.bean.Result;
import me.binf.entity.Category;
import me.binf.entity.Member;
import me.binf.entity.Post;
import me.binf.exception.GeneralExceptionHandler;
import me.binf.service.CategoryService;
import me.binf.service.PostService;
import me.binf.utils.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "content")
public class ContentController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PostService postService;
    @Autowired
    private LoginService loginService;

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
            Category result = null;
            if(category.getId()==null){
                result = categoryService.create(category);
            }else{
                result = categoryService.update(category);
            }
            WebUtil.print(response,new Result(true).data(result).msg("创建类别成功！"));
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
                       HttpServletResponse response,
                       ModelMap model){

        return "template/admin/新建文章";
    }

    @RequestMapping(value = "post/save")
    public void save(HttpServletRequest request,
                     HttpServletResponse response,
                     Post post,
                     Integer status,
                     Integer[] categoryIds,
                     ModelMap model){
        Post result = null;

        Member member =  loginService.getMember(request);
        post.setUpdateBy(member);
        try{
            if(post.getId()==null){
                post.setCreateBy(member);
                result = postService.create(post,categoryIds);
            }else{
                result = postService.update(post, categoryIds);
            }
            WebUtil.print(response,new Result(true).data(result).msg("文章发布成功！"));
        }catch (Exception e){
            WebUtil.print(response, new Result(false).msg(e.getMessage()));
        }
    }






}
