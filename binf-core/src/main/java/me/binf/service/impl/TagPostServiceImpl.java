package me.binf.service.impl;

import me.binf.core.Constant;
import me.binf.dao.TagPostDao;
import me.binf.entity.Tag;
import me.binf.entity.TagPost;
import me.binf.service.TagPostService;
import me.binf.service.TagService;
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
    @Autowired
    private TagService tagService;


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
        Tag tag =  tagpost.getTag();
        tag.setStats(tag.getStats() + 1);
        tagService.save(tag);
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

    @Override
    @Transactional
    public void deleteByPost(int postId) {
        List<Tag> tagList = findByPost(postId);
        for(Tag tag :tagList){
            tag.setStats(tag.getStats()-1<0?0:tag.getStats()-1);
            tagService.save(tag);
        }
        tagpostDao.deleteByPost(postId);
    }

    @Override
    @Transactional
    public void deleteByPostAndTag(int postId, int tagId) {
        Tag tag = tagService.getById(tagId);
        tag.setStats(tag.getStats()-1<0?0:tag.getStats()-1);
        tagService.save(tag);
        tagpostDao.deleteByPostAndTag(postId, tagId);
    }

    @Override
    public TagPost findByPostAndTag(int postId, int tagId) {
        return tagpostDao.findByPostAndTag(postId,tagId);
    }

    @Override
    public List<Tag> findByPost(int postId){
        return tagpostDao.findByPost(postId);
    }
}
