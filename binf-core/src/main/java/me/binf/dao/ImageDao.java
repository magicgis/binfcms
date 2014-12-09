package me.binf.dao;

import me.binf.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangbin on 2014/12/9.
 */
public interface ImageDao  extends JpaRepository<Image,Integer> {
}
