package me.binf.service.impl;

import me.binf.core.Constant;
import me.binf.dao.TagPostDao;
import me.binf.entity.TagPost;
import me.binf.service.TagPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wangbin on 14-10-16.
 */
@Service
@Transactional(readOnly = true)
public class TagPostServiceImpl implements TagPostService {

    @Autowired
    private TagPostDao tagpostDao;


    @Override
    public List<TagPost> findAll() {
        return tagpostDao.findAll();
    }

    @Override
    public Page<TagPost> find(int pageNum, int pageSize) {
        return tagpostDao.findAll(new PageRequest(pageNum, pageSize, Sort.Direction.DESC, "id"));
    }

    @Override
    public Page<TagPost> find(int pageNum) {
        return find(pageNum, Constant.PAGE_DEF_SZIE);
    }

    @Override
    public TagPost getById(int id) {
        return tagpostDao.findOne(id);
    }

    @Override
    @Transactional
    public TagPost deleteById(int id) {
        TagPost tagpost = getById(id);
        tagpostDao.delete(tagpost);
        return tagpost;
    }

    @Override
    @Transactional
    public TagPost create(TagPost tagpost) {
        return save(tagpost);
    }

    @Override
    @Transactional
    public TagPost update(TagPost tagpost) {
        return save(tagpost);
    }

    public TagPost save(TagPost tagpost) {
        return tagpostDao.save(tagpost);
    }
}
