package me.binf.service;

import me.binf.entity.Post;
import me.binf.service.common.ICommonService;

/**
 * Created by wangbin on 14-11-16.
 */
public interface PostService extends ICommonService<Post> {


    public Post create(Post post,Integer[] categoryIds);

    public Post update(Post post, Integer[] categoryIds);

}
