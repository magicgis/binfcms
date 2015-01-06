package me.binf.admin.service.impl;

import me.binf.admin.core.Configue;
import me.binf.admin.entity.FileBo;
import me.binf.admin.service.AbstractUploadService;
import me.binf.admin.service.UploadImageService;
import me.binf.entity.Image;
import me.binf.exception.GeneralException;
import me.binf.exception.GeneralExceptionHandler;
import me.binf.utils.FileUtil;
import me.binf.utils.ImageUtil;
import me.binf.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangbin on 2014/12/7.
 */
@Service
public class UploadImageServiceImpl extends AbstractUploadService implements UploadImageService {



    @Override
    public FileBo saveImage(MultipartFile file) {
        if (!FileUtil.isImage(file.getOriginalFilename())) {
            GeneralExceptionHandler.handle("文件格式不正确，请上传图片!");
        }
        FileBo result = null;
        try {
            result = super.save(file);
        } catch (IOException e) {
            GeneralExceptionHandler.handle("上传失败,服务器繁忙!");
        }
        return result;
    }

    @Override
    public Image uploadImage(MultipartFile file, String... thumbSizes) {
        try {
            FileBo fileBo = saveImage(file);
            Image image = new Image();
            image.setPath(fileBo.getPath());

            if (thumbSizes != null && thumbSizes.length > 0) {
                for (String size : thumbSizes) {
                    String regex = "(\\d+)x(\\d+)";
                    Pattern p = Pattern.compile(regex, Pattern.DOTALL);
                    Matcher m = p.matcher(size);
                    String destImage = fileBo.getForeName() + "_" + size + fileBo.getExt();
                    if (m.find()) {
                        int width = Integer.parseInt(m.group(1));// 宽
                        int height = Integer.parseInt(m.group(2));// 高
                        ImageUtil.thumbImage(fileBo.getFile(), Configue.getUploadPath(), destImage, width, height);
                    }
                    Map<String, String> thumb = new HashMap<String, String>();
                    thumb.put(size, destImage);
                    image.setThumbs(JsonUtil.obj2Json(thumb));
                }
            }
            return image;
        } catch (Exception e) {
            GeneralExceptionHandler.log(e);
        }

        return null;
    }


}
