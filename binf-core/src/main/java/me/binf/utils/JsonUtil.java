package me.binf.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by wangbin on 14-10-17.
 */
public class JsonUtil {



    public static String Obj2Json(Object obj){
        Gson gson = new GsonBuilder().
                serializeNulls().
                setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();

        return  gson.toJson(obj);
    }

}
