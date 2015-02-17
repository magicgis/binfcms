package me.binf.admin.mvc.common;

import me.binf.admin.mvc.editor.*;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * Created by wangbin on 2014/12/6.
 */
public class CommonController {


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(MultipartFile.class, new CustomFileEditor());
        binder.registerCustomEditor(Double.class, new CustomDoubleEditor());
        binder.registerCustomEditor(Float.class, new CustomFloatEditor());
        binder.registerCustomEditor(Integer.class, new CustomIntegerEditor());
        binder.registerCustomEditor(Long.class, new CustomLongEditor());
        binder.registerCustomEditor(Date.class, new CustomDateEditor());
    }

    public Integer getPageNum(Integer start,Integer length){
        if(start==null){
            start = 0;
        }
        if(length == null){
            length = 10;
        }
        int pageNum = (start/length)+1;
        return pageNum;
    }
}
