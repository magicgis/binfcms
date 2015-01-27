import com.cedarsoftware.util.io.JsonReader;
import com.google.gson.*;
import me.binf.exception.GeneralExceptionHandler;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by wangbin on 14-10-17.
 */
public class JsonUtil {

    public static String obj2JsonApi(Object obj){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(new AutoValueAdapterFactory()).
        serializeNulls().
        setDateFormat("yyyy-MM-dd HH:mm:ss");
        return  gsonBuilder.create().toJson(obj);
    }

    public static String obj2Json(Object obj){
        GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.serializeNulls().
                setDateFormat("yyyy-MM-dd HH:mm:ss");
        return  gsonBuilder.create().toJson(obj);
    }

    public static <T> T json2Obj(String str,Type type){
        Gson gson = new GsonBuilder().
                serializeNulls().
                setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
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
        Item item = new Item(0);
        item.setId(1);
        item.setPurchaseDate(new Date());

        One one = new One();
        one.setId(2);
        item.setOne(one);


        Long startTime = System.currentTimeMillis();
        String json = obj2Json(item);
        Long endTime = System.currentTimeMillis();
        System.out.println("one:"+(endTime-startTime)+",content:"+json);


        Long startTime1 = System.currentTimeMillis();
        String json1 = obj2JsonApi(item);
        Long endTime1 = System.currentTimeMillis();
        System.out.println("two:"+(endTime1-startTime1)+",content:"+json1);
    }



}
