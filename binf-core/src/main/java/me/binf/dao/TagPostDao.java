package me.binf.dao;

import me.binf.entity.Tag;
import me.binf.entity.TagPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by wangbin on 2015/1/20.
 */
public interface TagPostDao  extends JpaRepository<TagPost,Integer> {

    @Modifying
    @Query("delete from TagPost a where a.post.id = ?1")
    public void deleteByPost(Integer postId);

    @Modifying
    @Query("delete from TagPost a where a.post.id = ?1 and a.tag.id = ?2")
    public void deleteByPostAndTag(Integer postId,Integer tagId);


    @Query("select a from TagPost a where a.post.id = ?1 and a.tag.id = ?2")
    public TagPost findByPostAndTag(Integer postId,Integer tagId);

    @Query("select a.tag from TagPost a where a.post.id = ?1")
    public List<Tag> findByPost(Integer postId);

    @Modifying
    @Query("delete from TagPost a where  a.tag.id = ?1")
    public void deleteByTag(Integer tagId);

}
