package me.binf.dao;

import me.binf.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by wangbin on 2015/1/20.
 */
public interface TagDao  extends JpaRepository<Tag,Integer> {


    @Query("select a from Tag a where a.name like ?1")
    public List<Tag> likeByName(String name);

    @Query("select a from Tag a where a.name = ?1")
    public Tag findByName(String name);



}
