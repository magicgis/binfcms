package me.binf.admin.freemarker;

import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateNumberModel;
import freemarker.template.TemplateScalarModel;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * Created by wangbin on 14-11-16.
 */
public abstract class DirectiveUtils {

    public static Integer getInt(String name,Map<String,TemplateModel> params)throws TemplateException{

        TemplateModel model = params.get(name);
        if(model==null){
            return null;
        }
        if(model instanceof TemplateModel){
            String s = model.toString();
            if(StringUtils.isBlank(s)){
                return null;
            }
            try {
                return Integer.parseInt(s);
            }catch (NumberFormatException e){
                throw new MustNumberException(name);
            }
        } else if(model instanceof TemplateNumberModel){
            return ((TemplateNumberModel) model).getAsNumber().intValue();
        }else {
            throw new MustNumberException(name);
        }



    }

}
