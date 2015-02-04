package me.binf.service;

import me.binf.entity.Tag;
import me.binf.service.common.ICommonService;

import java.util.List;

/**
 * Created by wangbin on 2015/1/20.
 */
public interface TagService extends ICommonService<Tag> {


    public void deleteAll(int[] ids);

    public List<Tag> likeByName(String name);

    public Tag findByName(String name);

    public List<Tag> equalTags(String tagNames);

    public Tag save(Tag tag);
}
