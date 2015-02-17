package me.binf.utils;

import com.cedarsoftware.util.io.JsonReader;
import com.google.gson.*;
import me.binf.exception.GeneralExceptionHandler;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangbin on 14-10-17.
 */
public class JsonUtil {

    public static String obj2Json(Object obj){
        Gson gson = new GsonBuilder().
                serializeNulls().
                setDateFormat("yyyy-MM-dd HH:mm:ss").
                create();
        return  gson.toJson(obj);
    }

    public static <T> T json2Obj(String str,Type type){
        Gson gson = new GsonBuilder().
                serializeNulls().
                setDateFormat("yyyy-MM-dd HH:mm:ss").
                create();
        return gson.fromJson(str,type);
    }


    public static Object fromJsonToAnyObject(String json){
        Object obj=null;
        try {
            obj = JsonReader.jsonToJava(json);
        } catch (IOException e) {
            GeneralExceptionHandler.handle(e);
        }
        return obj;
    }


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        String json = JsonUtil.obj2Json(list);
        System.out.println(json);

        int[] a = JsonUtil.json2Obj(json,int[].class);
        System.out.println(a);
    }


}
