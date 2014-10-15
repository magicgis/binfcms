package me.binf.dao;

import me.binf.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangbin on 14-10-16.
 */
public interface CategoryDao extends JpaRepository<Category,Integer> {
}
