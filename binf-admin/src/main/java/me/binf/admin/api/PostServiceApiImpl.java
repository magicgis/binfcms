package me.binf.admin.api;

import com.caucho.hessian.server.HessianServlet;
import me.binf.api.PostServiceApi;
import me.binf.entity.Post;
import me.binf.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangbin on 2014/12/22.
 */
@Service
public class PostServiceApiImpl extends HessianServlet implements PostServiceApi {



    @Override
    public String list() {


        return "xxxxx";
    }

    @Override
    public String hello() {
        return "hello";
    }
}
