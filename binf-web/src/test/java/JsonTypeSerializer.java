import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by wangbin on 2015/1/25.
 */
public class JsonTypeSerializer implements JsonSerializer<Object> {




    @Override
    public JsonElement serialize(Object src, Type typeOfSrc,JsonSerializationContext context) {


        return new JsonPrimitive(String.valueOf(src));
    }
}
