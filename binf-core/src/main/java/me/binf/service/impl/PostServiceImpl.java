package me.binf.service.impl;

import me.binf.core.Constant;
import me.binf.dao.PostDao;
import me.binf.entity.Post;
import me.binf.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by wangbin on 14-10-16.
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;


    @Override
    public List<Post> findAll() {
        return postDao.findAll();
    }

    @Override
    public Page<Post> find(int pageNum, int pageSize) {
        return postDao.findAll(new PageRequest(pageNum - 1, pageSize, Sort.Direction.DESC, "id"));
    }

    @Override
    public Page<Post> find(int pageNum) {
        return find(pageNum, Constant.PAGE_DEF_SZIE);
    }

    @Override
    public Post getById(int id) {
        return postDao.findOne(id);
    }

    @Override
    public Post deleteById(int id) {
        Post post = getById(id);
        postDao.delete(post);
        return post;
    }

    @Override
    public Post create(Post post) {
        post.setCreateDate(new Date());
        return postDao.save(post);
    }

    @Override
    public Post update(Post post) {
        post.setUpdateDate(new Date());
        return postDao.save(post);
    }

}
