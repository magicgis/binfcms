package me.binf.dao;

import me.binf.entity.CategoryPost;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangbin on 14-11-16.
 */
public interface CategoryPostDao extends JpaRepository<CategoryPost,Integer> {
}
