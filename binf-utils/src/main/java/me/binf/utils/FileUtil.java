package me.binf.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by wangbin on 2014/12/6.
 */
public class FileUtil {

    public static String getFileExt(String fileName){

        int index=fileName.lastIndexOf('.');
        if(index==-1){
            return "";
        }
        String ext=fileName.substring(index);
        return ext;
    }


    public static boolean isImage(String fileName){
        return fileName.matches("(?i).+?\\.(jpg|gif|bmp|jpeg|png)");
    }


}
