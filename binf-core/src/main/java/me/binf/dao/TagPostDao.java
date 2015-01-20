package me.binf.dao;

import me.binf.entity.TagPost;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangbin on 2015/1/20.
 */
public interface TagPostDao  extends JpaRepository<TagPost,Integer> {

}
