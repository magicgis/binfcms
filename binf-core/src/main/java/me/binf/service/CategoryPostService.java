package me.binf.service;

import me.binf.dao.CategoryPostDao;
import me.binf.entity.CategoryPost;
import me.binf.entity.Post;

/**
 * Created by wangbin on 14-11-17.
 */
public interface CategoryPostService {

    public CategoryPost create(CategoryPost categoryPost);

    public void deleteByPost(Post post);



}
