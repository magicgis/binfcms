package me.binf.admin.controller;


import me.binf.logger.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangbin on 14-9-21.
 */

public class HelloServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger.error("xxx");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext =  config.getServletContext();
        Object object =  servletContext.getAttribute("javax.servlet.context.tempdir");


    }
}
