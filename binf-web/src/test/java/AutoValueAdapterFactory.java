/**
 * Created by wangbin on 2015/1/26.
 */
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

public final class AutoValueAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        Class<? super T> rawType = type.getRawType();
        if (!rawType.isAnnotationPresent(JsonType.class)) {

            return null;
        }else{
            System.out.println(rawType.getAnnotation(JsonType.class).value());
        }

        String packageName = rawType.getPackage().getName();
        String className = rawType.getName().substring(packageName.length() + 1).replace('$', '_');
        String autoValueName = packageName + ".AutoValue_" + className;

        try {
            Class<?> autoValueType = Class.forName(autoValueName);
            return (TypeAdapter<T>) gson.getAdapter(autoValueType);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Could not load AutoValue type " + autoValueName, e);
        }
    }
}