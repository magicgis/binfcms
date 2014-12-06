package me.binf.admin.service.impl;

import me.binf.admin.core.Configue;
import me.binf.upload.AbstractUploadService;
import me.binf.utils.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by wangbin on 2014/12/6.
 */
@Service
public class FileServiceImpl extends AbstractUploadService {


    /**
     * 返回文件的相对路径
     * @param file
     * @return
     */
    public String save(MultipartFile file) throws IOException {
        String origFileName =  file.getOriginalFilename();
        String ext =  FileUtil.getFileExt(origFileName);

        return super.save(file,Configue.getUploadPath());
    }






}
