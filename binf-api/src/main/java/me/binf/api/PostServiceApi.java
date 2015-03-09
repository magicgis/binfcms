package me.binf.api;



import java.util.List;

/**
 * Created by wangbin on 2014/12/22.
 */
public interface PostServiceApi {


    public String findAll();

    public String find(int pageNum, int pageSize);

    public String findPostById(int postId);

    public String dateList();
}
