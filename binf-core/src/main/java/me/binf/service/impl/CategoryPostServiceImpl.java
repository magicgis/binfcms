package me.binf.service.impl;

import me.binf.entity.Category;
import me.binf.entity.CategoryPost;
import me.binf.dao.CategoryPostDao;
import me.binf.entity.Post;
import me.binf.service.CategoryPostService;
import me.binf.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Transient;
import java.util.List;

/**
 * Created by wangbin on 14-11-17.
 */
@Service
@Transactional(readOnly = true)
public class CategoryPostServiceImpl implements CategoryPostService {


    @Autowired
    private CategoryPostDao categoryPostDao;
    @Autowired
    private CategoryService categoryService;

    @Override
    @Transactional
    public CategoryPost create(CategoryPost categoryPost) {
        return categoryPostDao.save(categoryPost);
    }

    @Transactional
    public void deleteByPost(int postId){
        categoryPostDao.deleteByPostId(postId);
    }


    @Override
    public List<CategoryPost> findByPost(int postId) {
        List<CategoryPost> categoryPostList =   categoryPostDao.findByPost(postId);
        return categoryPostList;
    }

    @Override
    @Transactional
    public void deleteByCategory(int categoryId) {
        categoryPostDao.deleteByCategory(categoryId);
    }

    @Override
    @Transactional
    public void setCateToDefCate(int categoryId) {
        Category defCategory = categoryService.findByCategoryByDef();
        List<CategoryPost> categoryPosts =  categoryPostDao.findByCategory(categoryId);
        deleteByCategory(categoryId);
        for(CategoryPost categoryPost : categoryPosts){
            Post post =  categoryPost.getPost();
            CategoryPost defCatePost =  categoryPostDao.findByPostAndCate(post.getId(),defCategory.getId());
            if(defCatePost==null){
                CategoryPost newCategoryPost = new CategoryPost();
                newCategoryPost.setCategory(defCategory);
                newCategoryPost.setPost(post);
                create(newCategoryPost);
            }

        }

    }


}
