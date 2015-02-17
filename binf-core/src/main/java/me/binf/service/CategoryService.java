package me.binf.service;

import me.binf.entity.Category;
import me.binf.service.common.ICommonService;

import java.util.List;

/**
 * Created by wangbin on 14-10-16.
 */
public interface CategoryService extends ICommonService<Category> {

    public List<Category> findByParent(Integer parentId);

    public List<Category> findList();

    public List<Category> findByLevel(int level);

    public List<Category> findAll(List<Category> category);

    public List<Category> findAllSub(Integer id);

    public String tree(Integer pid);

    public void deleteAll(int[] ids);

    public Category findByCategoryByDef();

}
