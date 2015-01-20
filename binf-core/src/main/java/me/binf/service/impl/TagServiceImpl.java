package me.binf.service.impl;

import me.binf.core.Constant;
import me.binf.dao.TagDao;
import me.binf.entity.Tag;
import me.binf.service.TagService;
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
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;


    @Override
    public List<Tag> findAll() {
        return tagDao.findAll();
    }

    @Override
    public Page<Tag> find(int pageNum, int pageSize) {
        return tagDao.findAll(new PageRequest(pageNum, pageSize, Sort.Direction.DESC, "id"));
    }

    @Override
    public Page<Tag> find(int pageNum) {
        return find(pageNum, Constant.PAGE_DEF_SZIE);
    }

    @Override
    public Tag getById(int id) {
        return tagDao.findOne(id);
    }

    @Override
    public Tag deleteById(int id) {
        Tag tag = getById(id);
        tagDao.delete(tag);
        return tag;
    }

    @Override
    public Tag create(Tag tag) {
        tag.setCreateDate(new Date());
        return tagDao.save(tag);
    }

    @Override
    public Tag update(Tag tag) {
        return tagDao.save(tag);
    }

}
