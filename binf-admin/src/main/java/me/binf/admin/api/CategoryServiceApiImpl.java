package me.binf.admin.api;

import me.binf.api.CategoryServiceApi;
import me.binf.entity.Category;
import me.binf.entity.Post;
import me.binf.service.CategoryPostService;
import me.binf.service.CategoryService;
import me.binf.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangbin on 2015/3/21.
 */
@Service
public class CategoryServiceApiImpl implements CategoryServiceApi{

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryPostService categoryPostService;

    @Override
    public String findAllCategory() {
        List<Category> categories = categoryService.findAll();
        return  JsonUtil.obj2Json(categories);
    }

    @Override
    public String findByName(String name, int pageNum, int pageSize) {
        Page<Post> posts = categoryPostService.findByCategory(name, pageNum, pageSize);
        return JsonUtil.obj2Json(posts);
    }


}
