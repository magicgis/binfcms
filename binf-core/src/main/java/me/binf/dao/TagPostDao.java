package me.binf.dao;

import me.binf.entity.TagPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by wangbin on 2015/1/20.
 */
public interface TagPostDao  extends JpaRepository<TagPost,Integer> {

    @Modifying
    @Query("delete from TagPost a where a.post.id = ?1")
    public void deleteByPost(Integer postId);

}
