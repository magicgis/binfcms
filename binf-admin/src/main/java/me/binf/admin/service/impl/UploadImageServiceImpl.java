package me.binf.admin.service.impl;

import me.binf.admin.core.Configue;
import me.binf.admin.service.UploadImageService;
import me.binf.exception.GeneralException;
import me.binf.exception.GeneralExceptionHandler;
import me.binf.upload.AbstractUploadService;
import me.binf.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by wangbin on 2014/12/7.
 */
@Service
public class UploadImageServiceImpl extends AbstractUploadService implements UploadImageService {


    @Override
    public String saveImage(MultipartFile file) {

        if(!FileUtil.isImage(file.getOriginalFilename())){
            GeneralExceptionHandler.handle("文件格式不正确，请上传图片!");
        }
        String result = null;
        try {
            result= super.save(file, Configue.getUploadPath());
        }catch (IOException e){
            GeneralExceptionHandler.handle("上传失败,服务器繁忙!");
        }
        return result;
    }




}
