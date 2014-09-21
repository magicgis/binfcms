package me.binf.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangbin on 14-9-21.
 */
@WebServlet(urlPatterns = "/*")
public class HelloServlet extends HttpServlet {


    private static final Logger logger = LoggerFactory.getLogger(HelloServlet.class);


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("hello");

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext =  config.getServletContext();
        Object object =  servletContext.getAttribute("javax.servlet.context.tempdir");


    }
}
