package me.binf.service.impl;

import javafx.geometry.Pos;
import me.binf.entity.*;
import me.binf.core.Constant;
import me.binf.dao.PostDao;
import me.binf.exception.GeneralExceptionHandler;
import me.binf.service.*;
import me.binf.utils.ClassUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wangbin on 14-10-16.
 */
@Service
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryPostService categoryPostService;
    @Autowired
    private TagPostService tagPostService;
    @Autowired
    private TagService tagService;

    @Override
    public List<Post> findAll() {
        return postDao.findAll();
    }

    @Override
    public Page<Post> find(int pageNum, int pageSize) {
        Page<Post> page = postDao.findAll(new PageRequest(pageNum-1, pageSize, Sort.Direction.DESC, "sort"));
        for(Post post : page.getContent()){
            List<CategoryPost>  categoryPosts =  categoryPostService.findByPost(post.getId());
            List<Category> categoryList = new ArrayList<Category>();
            for(CategoryPost categoryPost : categoryPosts){
                categoryList.add(categoryPost.getCategory());

            }
            post.setCategorys(categoryList);
        }
        return page;
    }

    @Override
    public Page<Post> find(int pageNum) {
        return find(pageNum, Constant.PAGE_DEF_SZIE);
    }

    @Override
    public Post getById(int id) {
        return postDao.findOne(id);
    }

    @Override
    @Transactional
    public Post deleteById(int id) {
        Post post = getById(id);
        postDao.delete(post);
        return post;
    }

    @Override
    @Transactional
    public Post create(Post post) {
        post.setSort(0);
        post.setCommentStatus(false);
        post.setCommentCount(0);
        post.setStars(0);
        post.setStick(false);
        post.setVisits(0);
        post.setCreateDate(new Date());
        post.setAnnounceDate(new Date());
        postDao.save(post);
        createTagPost(post);
        return post;
    }


    @Transactional
    public void createTagPost(Post post){

        List<Tag> tagList =  tagService.equalTags(post.getTags());
        if(tagList!=null){
            for(Tag tag : tagList){
                tagPostService.deleteByPost(post.getId());
                TagPost tagPost = new TagPost();
                tagPost.setTag(tag);
                tagPost.setPost(post);
                tagPostService.create(tagPost);
            }
        }
    }

    @Override
    @Transactional
    public Post update(Post post) {
        Post origPost = getById(post.getId());
        if(post.getStick()==null){
            post.setStick(false);
        }
        ClassUtil.copyProperties(origPost, post);
        origPost.setUpdateDate(new Date());
        postDao.save(origPost);
        createTagPost(post);
        return post;
    }

    @Override
    @Transactional
    public Post create(Post post, Integer[] categoryIds) {
        if(null==categoryIds||categoryIds.length==0){
            GeneralExceptionHandler.handle("文章类别不能为空!");
        }
        for(int categoryId : categoryIds){
            Category category = categoryService.getById(categoryId);
            if(category==null){
                GeneralExceptionHandler.handle("该类别不存在!");
            }else{
                post = create(post);
                CategoryPost categoryPost = new CategoryPost();
                categoryPost.setCategory(category);
                categoryPost.setPost(post);
                categoryPostService.create(categoryPost);
            }
        }
        return post;
    }

    @Override
    @Transactional
    public Post update(Post post, Integer[] categoryIds){
        if(null==categoryIds||categoryIds.length==0){
            GeneralExceptionHandler.handle("文章类别不能为空!");
        }


        for(int categoryId : categoryIds){
            Category category = categoryService.getById(categoryId);
            if(category==null){
                GeneralExceptionHandler.handle("该类别不存在!");
            }else{
                categoryPostService.deleteByPost(post.getId());
                CategoryPost categoryPost = new CategoryPost();
                categoryPost.setCategory(category);
                categoryPost.setPost(post);
                categoryPostService.create(categoryPost);
            }
        }
        return update(post);
    }

    @Override
    public Post findPostById(int postId) {
        Post post = getById(postId);
        if(post==null){
            GeneralExceptionHandler.handle("id["+postId+"]该文章不存在!");
        }
        List<CategoryPost>  categoryPosts =  categoryPostService.findByPost(post.getId());
        List<Category> categoryList = new ArrayList<Category>();
        for(CategoryPost categoryPost : categoryPosts){
            categoryList.add(categoryPost.getCategory());

        }
        post.setCategorys(categoryList);
        return post;
    }

    @Override
    @Transactional
    public void deleteAll(int[] ids) {
        for(int id : ids){
            deleteById(id);
            categoryPostService.deleteByPost(id);
        }
    }




}
