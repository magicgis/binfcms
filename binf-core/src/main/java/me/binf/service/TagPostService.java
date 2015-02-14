package me.binf.service;

import me.binf.entity.Tag;
import me.binf.entity.TagPost;
import me.binf.service.common.ICommonService;

import java.util.List;

/**
 * Created by wangbin on 2015/1/20.
 */
public interface TagPostService extends ICommonService<TagPost> {

    public void deleteByPost(int postId);

    public void deleteByPostAndTag(int postId,int tagId);

    public TagPost findByPostAndTag(int postId,int tagId);

    public List<Tag> findByPost(int postId);

    public void deleteByTag(int tagId);
}
