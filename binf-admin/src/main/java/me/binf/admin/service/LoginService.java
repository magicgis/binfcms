package me.binf.admin.service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangbin on 14-10-31.
 */
public interface LoginService {

    public Boolean isLogin(String username);

    public Boolean login(String username,String password,HttpServletRequest request);
}
