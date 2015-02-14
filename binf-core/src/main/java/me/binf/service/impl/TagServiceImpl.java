package me.binf.service.impl;

import me.binf.core.Constant;
import me.binf.dao.TagDao;
import me.binf.entity.Tag;
import me.binf.service.TagPostService;
import me.binf.service.TagService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wangbin on 14-10-16.
 */
@Service
@Transactional(readOnly = true)
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;
    @Autowired
    private TagPostService tagPostService;

    @Override
    public List<Tag> findAll() {
        return tagDao.findAll();
    }

    @Override
    public Page<Tag> find(int pageNum, int pageSize) {
        return tagDao.findAll(new PageRequest(pageNum-1, pageSize, Sort.Direction.DESC, "id"));
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
    @Transactional
    public Tag deleteById(int id) {
        Tag tag = getById(id);
        tagPostService.deleteByTag(tag.getId());
        tagDao.delete(tag);
        return tag;
    }

    @Override
    @Transactional
    public Tag create(Tag tag) {
        tag.setCreateDate(new Date());
        tag.setStats(0);

        return tagDao.save(tag);
    }

    @Override
    @Transactional
    public Tag update(Tag tag) {
        return tagDao.save(tag);
    }

    @Override
    @Transactional
    public void deleteAll(int[] ids) {
        for(int id : ids){
            deleteById(id);
        }
    }


    public List<Tag> likeByName(String name){

        return tagDao.likeByName("%" + name + "%");

    }

    @Override
    public Tag findByName(String name) {
        Tag tag = tagDao.findByName(name);
        return tag;
    }

    @Override
    public List<Tag> equalTags(String tagNames) {
        if(StringUtils.isBlank(tagNames)){
            return null;
        }

        String[] tagArray = tagNames.split(",");
        List<Tag> tagList = new ArrayList<>();

        for(String name : tagArray){
            Tag tag = findByName(name);
            if(tag!=null){
                tagList.add(tag);
            }else{
                Tag tag1 = new Tag();
                tag1.setName(name);
                tagList.add(create(tag1));
            }
        }
        return tagList;
    }

    @Override
    @Transactional
    public Tag save(Tag tag) {
        return tagDao.save(tag);
    }
}
