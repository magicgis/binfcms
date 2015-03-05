package me.binf.web.core;


import me.binf.utils.ConfigUtil;

/**
 * Created by wangbin on 2014/11/27.
 */
public class Configue {

    static {
        ConfigUtil.setConfigFile("conf/system.properties");
    }

    public static String getUploadUrl() {
        return ConfigUtil.getString("upload.url");
    }

    public static String getUploadPath() {
        return ConfigUtil.getString("upload.path");
    }


    public static String getSystemHtmlPath(){
        return ConfigUtil.getString("system.path");
    }

}
