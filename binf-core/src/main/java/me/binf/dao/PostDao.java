package me.binf.dao;

import me.binf.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by wangbin on 14-11-16.
 */
public interface PostDao extends JpaRepository<Post,Integer>, JpaSpecificationExecutor<Post> {
}
