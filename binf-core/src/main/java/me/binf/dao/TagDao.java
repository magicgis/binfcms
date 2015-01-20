package me.binf.dao;

import me.binf.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangbin on 2015/1/20.
 */
public interface TagDao  extends JpaRepository<Tag,Integer> {
}
