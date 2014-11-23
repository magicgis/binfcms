package me.binf.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wangbin on 14-11-23.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NoConvert {

    /**
     *
     * 默认级别，判断原始字段是否为空,为空则不被替换
     */
    public static int Def = 0;



    int level() default Def;

}
