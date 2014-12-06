package me.binf.admin.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by wangbin on 2014/12/7.
 */
public interface UploadImageService {

    public String saveImage(MultipartFile file);

}
