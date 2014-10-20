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

import java.util.ArrayList;
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

        if(category.getParentId()==null){
            category.setLevel(1);
        }else{
            Category parent =  getById(category.getParentId());
            category.setLevel(parent.getLevel()+1);
        }
        if(category.getSort()==null){
            category.setSort(0);
        }

        category.setCount(0);

        category.setCreateDate(new Date());
        return categoryDao.save(category);
    }

    @Override
    public Category Update(Category category) {
        category.setUpdateDate(new Date());
        return categoryDao.save(category);
    }

    @Override
    public List<Category> findByParent(Integer parentId) {
        return categoryDao.findByParent(parentId);
    }

    @Override
    public List<Category> findAllSub(Integer id) {
        List<Category> list = categoryDao.findByParent(id);
        if(list!=null&&!list.isEmpty()){
            List<Category> allSubList = new ArrayList<Category>();
            for(Category category:list){
                List<Category> subList = findAllSub(category.getId());
                if(subList!=null&&!subList.isEmpty()){
                     allSubList.addAll(subList);
                }

            }
            list.addAll(allSubList);
        }
        return list;
    }


    public String tree(Integer pid){
        List<Category> list = null;
        if(pid==null){
            list = categoryDao.findByParent();
        }else{
            list = categoryDao.findByParent(pid);
        }
        String tree = null;
        if(list!=null&&!list.isEmpty()){
            for(Category category:list){
                if(tree!=null){
                    tree+=",";
                }else{
                    tree="";
                }
                tree+=tree(category);
            }
            tree="{"+tree+"}";
        }else{
            tree="{}";
        }
        return tree;
    }

    public String tree(Category category){
        String subTree = null;
        List<Category> categoryList = categoryDao.findByParent(category.getId());
        if(categoryList!=null&&!categoryList.isEmpty()){
            for(Category subCategory:categoryList){
                if(subTree!=null){
                    subTree+=",";
                }else{
                    subTree="";
                }
                subTree+=tree(subCategory);

            }

        }
        String tree = category.getId()+":{name:'"+category.getName()+"'}";
        if(subTree!=null){
            tree+=",cell:{"+subTree+"}";
        }
        return tree;
    }

}



