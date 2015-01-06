package me.binf.admin.mvc.controller;

import me.binf.admin.core.Configue;
import me.binf.admin.mvc.common.CommonController;
import me.binf.admin.service.UploadImageService;
import me.binf.admin.utils.WebUtil;
import me.binf.entity.Image;
import me.binf.core.bean.Result;
import me.binf.exception.GeneralExceptionHandler;
import me.binf.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by wangbin on 2014/12/6.
 */
@Controller
@RequestMapping(value = "file")
public class FileController extends CommonController{

    @Autowired
    private UploadImageService uploadImageService;

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/upload")
    public String upload(HttpServletRequest request,
                            HttpServletResponse response
                            ){
        return "template/admin/upload";
    }


    @RequestMapping(value = "/image/save")
    public void save(HttpServletRequest request,
                     HttpServletResponse response,
                     @RequestParam(required=false) MultipartFile file){

        String filePath = "";
        try {
            Image image = uploadImageService.uploadImage(file);
            //图片完整路径
            image.setPath(Configue.getUploadUrl()+filePath);
            WebUtil.print(response, new Result(true).data(image).msg("上传图片成功!"));
        }catch (Exception e){
            GeneralExceptionHandler.log(e);
            WebUtil.print(response, new Result(false).msg(e.getMessage()));
        }

    }

    @RequestMapping(value = "/files")
    public String files(HttpServletRequest request,
                        HttpServletResponse response){

        return "template/admin/文件管理";
    }


}
