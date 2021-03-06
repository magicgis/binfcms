package me.binf.admin.utils;

import me.binf.core.Constant;
import me.binf.exception.GeneralExceptionHandler;
import me.binf.utils.JsonUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wangbin on 14-10-17.
 */
public class WebUtil {


    public static void print(HttpServletResponse response, Object data){
        printJson(response, data);
    }

    public  static void printJson(HttpServletResponse response, Object data){
        try {
            // 设置响应头
            response.setContentType("application/json"); // 指定内容类型为 JSON 格式
            response.setCharacterEncoding(Constant.ENCODING); // 防止中文乱码
            // 向响应中写入数据
            PrintWriter writer = response.getWriter();
            writer.write(JsonUtil.obj2Json(data)); // 转为 JSON 字符串
            writer.flush();
            writer.close();
        } catch (Exception e) {
            GeneralExceptionHandler.handle(e);
        }
    }


    public  static void printJson(HttpServletResponse response, String data){
        try {
            // 设置响应头
            response.setContentType("application/json"); // 指定内容类型为 JSON 格式
            response.setCharacterEncoding(Constant.ENCODING); // 防止中文乱码
            // 向响应中写入数据
            PrintWriter writer = response.getWriter();
            writer.write(data); // 转为 JSON 字符串
            writer.flush();
            writer.close();
        } catch (Exception e) {
            GeneralExceptionHandler.handle(e);
        }
    }



    public static void printHtml(HttpServletResponse response, String content){
        try {
            // 设置响应头
            response.setContentType("text/html");
            response.setCharacterEncoding(Constant.ENCODING); // 防止中文乱码
            // 向响应中写入数据
            PrintWriter writer = response.getWriter();
            writer.write(content); // 转为 JSON 字符串
            writer.flush();
            writer.close();
            response.getOutputStream().write(content.getBytes());
        } catch (IOException e) {
            GeneralExceptionHandler.handle(e);
        }
    }
}
