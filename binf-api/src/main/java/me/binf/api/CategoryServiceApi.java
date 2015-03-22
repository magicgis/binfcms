package me.binf.api;

/**
 * Created by wangbin on 2015/3/21.
 */
public interface CategoryServiceApi {


    public String findAllCategory();


    public String findByName(String name,int pageNum,int pageSize);

}
