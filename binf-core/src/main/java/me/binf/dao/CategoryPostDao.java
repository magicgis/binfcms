package me.binf.dao;

import me.binf.entity.CategoryPost;
import me.binf.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by wangbin on 14-11-16.
 */
public interface CategoryPostDao extends JpaRepository<CategoryPost,Integer> {


    @Modifying
    @Query("delete from CategoryPost a where a.post.id = ?1")
    public void deleteByPostId(Integer postId);


}
