package me.binf.admin.freemarker;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import me.binf.admin.utils.BeanUtil;
import me.binf.entity.Category;
import me.binf.service.CategoryService;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

/**
 * Created by wangbin on 14-11-16.
 */
public class CategoryList implements TemplateDirectiveModel {

    private static CategoryService  categoryService;

    @Override
    public void execute(Environment environment,
                        Map map,
                        TemplateModel[] templateModels,
                        TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {

        try {
            Integer level =  DirectiveUtils.getInt("level",map);
            categoryService = (CategoryService)BeanUtil.getBean("categoryServiceImpl");
            String result =categoryHtml(categoryService.findByLevel(level));
            System.out.println(result);
            Writer out = environment.getOut();
            out.append(result);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    private String categoryHtml(List<Category> list){

        StringBuilder sb =  new StringBuilder("<ul class=\"list-unstyled\">");

        if(list!=null&&!list.isEmpty()){
            for(Category c:list){
                sb.append("<li>");
                sb.append("<div class=\"checkbox\">");
                sb.append("<label>");
                sb.append("<input type=\"checkbox\" name=\"categoryIds\" value='"+c.getId()+"'>"+c.getName());
                sb.append("</label>");
                sb.append("</div>");
                List<Category> children = categoryService.findByParent(c.getId());
                if(children!=null&&children.size()>0){
                    for(Category chi : children){
                        sb.append("<li>");
                        sb.append("<ul  class=\"children list-unstyled\">");
                        sb.append("<div class=\"checkbox\">");
                        sb.append("<label>");
                        sb.append("<input type=\"checkbox\" name=\"categoryIds\" value="+chi.getId()+">"+chi.getName());
                        sb.append("</label>");
                        sb.append("</div>");
                        sb.append("</ul>");
                        sb.append("</li>");
                    }
                    categoryHtml(children);
                }
                sb.append("</li>");
            }
        }

        sb.append("</ul>");

        return sb.toString();
    }


}
