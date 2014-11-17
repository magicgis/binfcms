package me.binf.service.impl;

import me.binf.dao.CategoryPostDao;
import me.binf.entity.CategoryPost;
import me.binf.entity.Post;
import me.binf.service.CategoryPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangbin on 14-11-17.
 */
@Service
public class CategoryPostServiceImpl implements CategoryPostService {


    @Autowired
    private CategoryPostDao categoryPostDao;

    @Override
    public CategoryPost create(CategoryPost categoryPost) {
        return categoryPostDao.save(categoryPost);
    }

    public void deleteByPost(Post post){
        categoryPostDao.deleteByPostId(post.getId());
    }


}
