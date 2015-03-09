package me.binf.admin.api;

import me.binf.api.PostServiceApi;
import me.binf.entity.Post;
import me.binf.service.PostService;
import me.binf.utils.JsonUtil;
import net.sf.json.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by wangbin on 2014/12/22.
 */
@Service
public class PostServiceApiImpl implements PostServiceApi {


    @Autowired
    private PostService postService;


    @Override
    public String findAll() {
        return JsonUtil.obj2Json(postService.findAll());
    }

    @Override
    public String find(int pageNum, int pageSize) {
        Page<Post> postPage =    postService.find(pageNum,pageSize);
        return  JsonUtil.obj2Json(postPage);
    }

    @Override
    public String findPostById(int postId) {
        Post post = postService.findPostById(postId);
        return JsonUtil.obj2Json(post);
    }

    @Override
    public String dateList() {
        List<Map<String,String>> list =   postService.dateList();
        return JsonUtil.obj2Json(list);
    }


}
