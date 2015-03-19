package me.binf.service;

import me.binf.entity.Post;
import me.binf.service.common.ICommonService;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by wangbin on 14-11-16.
 */
public interface PostService extends ICommonService<Post> {


    public Post create(Post post,Integer[] categoryIds);

    public Post update(Post post, Integer[] categoryIds);

    public Post findPostById(int postId);

    public void deleteAll(int[] ids);

    public  List<Map<String,String>> dateList();

    public Page<Post> findByArchives(int years,int month,int pageNum, int pageSize);

}
