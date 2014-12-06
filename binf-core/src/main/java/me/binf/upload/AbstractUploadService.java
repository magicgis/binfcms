package me.binf.upload;

import me.binf.utils.FileUtil;
import me.binf.utils.UploadUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wangbin on 2014/12/6.
 */
public abstract class AbstractUploadService {

    public String save(MultipartFile file,String diskPath,String filePath) throws IOException {
        InputStream inputStream = file.getInputStream();
        FileUtils.copyInputStreamToFile(inputStream, new File(diskPath, filePath));
        return filePath;
    }

    public String save(MultipartFile file,String diskPath) throws IOException {
        String filePath =  getDesFileName(file.getOriginalFilename());
        return save(file,diskPath,filePath);
    }


    public String getDesFileName(String origFileName){
        String ext =  FileUtil.getFileExt(origFileName);
        String fileName = String.valueOf(System.currentTimeMillis());
        String uploadPath = UploadUtil.getImagesUpladPath();
        String desFilePathName = uploadPath+fileName+ext;
        return desFilePathName;

    }
}
