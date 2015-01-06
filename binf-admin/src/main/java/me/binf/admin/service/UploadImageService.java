package me.binf.admin.service;

import me.binf.admin.entity.FileBo;
import me.binf.entity.Image;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by wangbin on 2014/12/7.
 */
public interface UploadImageService {

    public FileBo saveImage(MultipartFile file);

    public Image uploadImage(MultipartFile file,String ... thumbSizes);


}
