package me.binf.service;

import me.binf.entity.Image;
import me.binf.service.common.ICommonService;

import java.util.Date;

/**
 * Created by wangbin on 2014/12/9.
 */
public interface ImageService {

    public Image getById(int id);

    public Image deleteById(int id);

    public Image create(Image image);

}
