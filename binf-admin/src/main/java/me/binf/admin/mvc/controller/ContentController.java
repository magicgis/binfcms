package me.binf.admin.mvc.controller;

import me.binf.admin.core.Configue;
import me.binf.admin.mvc.common.CommonController;
import me.binf.admin.service.LoginService;
import me.binf.admin.utils.DataTableFactory;
import me.binf.admin.utils.WebUtil;
import me.binf.entity.*;
import me.binf.core.bean.Result;
import me.binf.exception.GeneralException;
import me.binf.exception.GeneralExceptionHandler;
import me.binf.service.CategoryService;
import me.binf.service.PostService;
import me.binf.service.TagPostService;
import me.binf.service.TagService;
import me.binf.utils.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping(value = "content")
public class ContentController extends CommonController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PostService postService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private TagService tagService;
    @Autowired
    private TagPostService tagPostService;
    /**
     * 类别start*
     */
    @RequestMapping(value = "category")
    public String category(HttpServletRequest request,
                           HttpServletResponse response,
                           ModelMap model) {
        return "template/admin/category";
    }

    @RequestMapping(value = "category/save")
    public void categorySave(HttpServletRequest request,
                             HttpServletResponse response,
                             Category category) {
        try {
            Category result = null;
            if (category.getId() == null) {
                result = categoryService.create(category);
            } else {
                result = categoryService.update(category);
            }
            WebUtil.print(response, new Result(true).data(result).msg("类别操作成功！"));
        }
        catch (GeneralException ex){
            GeneralExceptionHandler.log( ex);
            WebUtil.print(response, new Result(false).msg(ex.getMessage()));
        }
        catch (Exception e) {
            GeneralExceptionHandler.log("类别操作失败", e);
            WebUtil.print(response, new Result(false).msg("类别操作失败"));
        }
    }

    @RequestMapping(value = "category/tree")
    public void categoryTree(HttpServletRequest request,
                             HttpServletResponse response,
                             String scriptName) {
        String tree = categoryService.tree(null);
        WebUtil.printJson(response, "var " + scriptName + "=" + tree);
    }

    @RequestMapping(value = "category/list")
    public void categoryList(HttpServletRequest request,
                             HttpServletResponse response) {
        List<Category> list = categoryService.findAll();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data", list);
        WebUtil.print(response, result);
    }

    @RequestMapping(value = "category/delete")
    public void categoryDel(HttpServletRequest request,
                            HttpServletResponse response,
                            String ids) {
        try {
            int[] arrayId = JsonUtil.json2Obj(ids, int[].class);
            categoryService.deleteAll(arrayId);
            WebUtil.print(response, new Result(true).msg("删除类别成功！"));
        }
        catch (GeneralException ge){
            WebUtil.print(response, new Result(false).msg(ge.getMessage()));
        }
        catch (Exception e) {
            GeneralExceptionHandler.log("删除类别失败", e);
            WebUtil.print(response, new Result(false).msg("删除类别失败！"));
        }

    }

    /** 类别end**/


    /**
     * 新建文章start *
     */
    @RequestMapping(value = "post")
    public String post(HttpServletRequest request,
                       HttpServletResponse response,
                       Integer id,
                       ModelMap model) {
        if (id != null) {
            Post post = postService.findPostById(id);
            Image image = post.getImage();
            if(image!=null){
                image.setPath(Configue.getUploadUrl() + image.getPath());
            }

            model.put("post", post);
        }

        return "template/admin/post";
    }

    /**
     * 快速编辑
     *
     * @param request
     * @param response
     * @param post
     * @param status
     */
    @RequestMapping(value = "post/fast/save")
    public void postFastSave(HttpServletRequest request,
                             HttpServletResponse response,
                             Post post,
                             Integer status) {

        Member member = loginService.getMember(request);
        post.setUpdateBy(member);
        if (StringUtils.isNotBlank(post.getTags())) {
            String tags = post.getTags();
            Pattern pattern = Pattern.compile("，+|,+");
            Matcher matcher = pattern.matcher(tags);
            post.setTags(matcher.replaceAll(","));
        }
        try {
            Post result = postService.update(post);
            WebUtil.print(response, new Result(true).data(result).msg("文章发布成功！"));
        } catch (Exception e) {
            WebUtil.print(response, new Result(false).msg(e.getMessage()));
        }

    }


    @RequestMapping(value = "post/save")
    public void postSave(HttpServletRequest request,
                         HttpServletResponse response,
                         Post post,
                         Integer status,
                         Integer imageId,
                         Integer[] categoryIds) {
        Post result = null;
        Member member = loginService.getMember(request);
        post.setUpdateBy(member);
        if (StringUtils.isNotBlank(post.getTags())) {
            String tags = post.getTags();
            Pattern pattern = Pattern.compile("，+|,+");
            Matcher matcher = pattern.matcher(tags);
            post.setTags(matcher.replaceAll(","));
        }
        if (imageId != null) {
            Image image = new Image();
            image.setId(imageId);
            post.setImage(image);
        }
        try {
            if (post.getId() == null) {
                post.setCreateBy(member);
                result = postService.create(post, categoryIds);
            } else {
                result = postService.update(post, categoryIds);
            }
            WebUtil.print(response, new Result(true).data(result).msg("文章发布成功！"));
        } catch (Exception e) {
            WebUtil.print(response, new Result(false).msg(e.getMessage()));
        }
    }

    @RequestMapping(value = "post/delete")
    public void postDelete(HttpServletRequest request,
                           HttpServletResponse response,
                           String ids) {
        try {
            int[] arrayId = JsonUtil.json2Obj(ids, int[].class);
            postService.deleteAll(arrayId);
            WebUtil.print(response, new Result(true).msg("删除类别成功！"));
        } catch (Exception e) {
            GeneralExceptionHandler.log("删除类别失败", e);
            WebUtil.print(response, new Result(false).msg("删除类别失败！"));
        }
    }

    /** 新建文章end **/


    /**
     * 文章列表start *
     */
    @RequestMapping(value = "posts")
    public String postListIndex(HttpServletRequest request,
                                HttpServletResponse response,
                                ModelMap model) {
        return "template/admin/posts";
    }


    @RequestMapping(value = "posts/list")
    public void postList(HttpServletRequest request,
                         HttpServletResponse response,
                         Integer draw,
                         Integer start,
                         Integer length) {

        Page<Post> page = postService.find(getPageNum(start,length), length);
        Map<String, Object> result = DataTableFactory.fitting(draw, page);
        WebUtil.printJson(response, result);
    }


    /** 文章列表end **/
    @RequestMapping(value = "tags")
    public String tagsIndex(HttpServletRequest request,
                            HttpServletResponse response,
                            ModelMap model){
        return "template/admin/tags";
    }

    @RequestMapping(value = "tags/list")
    public void tagList(HttpServletRequest request,
                        HttpServletResponse response,
                        Integer draw,
                        Integer start,
                        Integer length){
        if (start == null) {
            start = 0;
        }
        Page<Tag> page = tagService.find(getPageNum(start,length), length);
        Map<String, Object> result = DataTableFactory.fitting(draw, page);
        WebUtil.printJson(response, result);
    }

    @RequestMapping(value = "tags/save")
    public void tagSave(HttpServletRequest request,
                        HttpServletResponse response,
                        Tag tag){
        try {
            if(tag.getId()==null){
                tagService.create(tag);
            }else{
                tagService.update(tag);
            }
            WebUtil.print(response, new Result(true).msg("标签操作成功！"));
        }catch (Exception e){
            GeneralExceptionHandler.log("标签操作失败", e);
            WebUtil.print(response, new Result(false).msg("标签操作失败！"));
        }
    }

    @RequestMapping(value = "tags/delete")
    public void tagDelete(HttpServletRequest request,
                           HttpServletResponse response,
                           String ids) {
        try {
            int[] arrayId = JsonUtil.json2Obj(ids, int[].class);
            tagService.deleteAll(arrayId);
            WebUtil.print(response, new Result(true).msg("删除标签成功！"));
        } catch (Exception e) {
            GeneralExceptionHandler.log("删除标签失败", e);
            WebUtil.print(response, new Result(false).msg("删除标签失败！"));
        }
    }

    @RequestMapping(value = "tags/query")
    public void tagsQuery(String query,
                          HttpServletResponse response){

        List<Tag> tags = tagService.likeByName(query);
        List<Map<String,Object>> maps = new ArrayList<>();
        for(Tag tag: tags){
            Map<String,Object> map = new HashMap<String, Object>();
            if(tag!=null){
                map.put("value",tag.getName());
                map.put("data",tag.getId()+"");
            }
            maps.add(map);
        }

        Map<String,Object> data =  new HashMap<String,Object>();
        data.put("suggestions",maps);
        data.put("query","Unit");
        WebUtil.print(response,data);
    }



}
