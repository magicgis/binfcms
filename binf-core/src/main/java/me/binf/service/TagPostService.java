package me.binf.service;

import me.binf.entity.TagPost;
import me.binf.service.common.ICommonService;

/**
 * Created by wangbin on 2015/1/20.
 */
public interface TagPostService extends ICommonService<TagPost> {



    public void deleteByPost(int postId);
}
