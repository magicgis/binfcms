package me.binf.service;

import me.binf.entity.CategoryPost;

import java.util.List;

/**
 * Created by wangbin on 14-11-17.
 */
public interface CategoryPostService {

    public CategoryPost create(CategoryPost categoryPost);

    public void deleteByPost(int postId);

    public List<CategoryPost> findByPost(int postId);

    public void deleteByCategory(int categoryId);

    public void setCateToDefCate(int categoryId);
}
