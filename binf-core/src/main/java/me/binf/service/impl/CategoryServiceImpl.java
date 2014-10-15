package me.binf.service.impl;

import me.binf.core.Constant;
import me.binf.dao.CategoryDao;
import me.binf.entity.Category;
import me.binf.service.CategoryService;
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
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;


    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Page<Category> find(int pageNum, int pageSize) {
        return categoryDao.findAll(new PageRequest(pageNum,pageSize, Sort.Direction.DESC,"id"));
    }

    @Override
    public Page<Category> find(int pageNum) {
        return find(pageNum, Constant.PAGE_DEF_SZIE);
    }

    @Override
    public Category getById(int id) {
        return categoryDao.findOne(id);
    }

    @Override
    public Category deleteById(int id) {
        Category category = getById(id);
        categoryDao.delete(category);
        return category;
    }

    @Override
    public Category create(Category category) {
        category.setCreateDate(new Date());
        return categoryDao.save(category);
    }

    @Override
    public Category Update(Category category) {
        category.setUpdateDate(new Date());
        return categoryDao.save(category);
    }

}
