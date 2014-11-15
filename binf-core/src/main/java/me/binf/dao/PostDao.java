package me.binf.dao;

import me.binf.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangbin on 14-11-16.
 */
public interface PostDao extends JpaRepository<Post,Integer> {
}
