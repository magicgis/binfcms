package me.binf.web.service.impl;

import freemarker.template.Template;
import me.binf.exception.GeneralExceptionHandler;
import me.binf.web.service.FreeMarkForHtmlService;
import me.binf.web.utils.BeanUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.*;
import java.util.Map;

/**
 * Created by Administrator on 14-5-19.
 */
@Service
public class FreeMarkForHtmlServiceImpl implements FreeMarkForHtmlService {


    @Override
    public void geneHtmlFile(String templateFileName,
                             String htmlFilePath,
                             String htmlFileName,
                             Map propMap)throws Exception{

        FreeMarkerConfigurer freeMarkerConfigurer =  (FreeMarkerConfigurer) BeanUtil.getBean("freemarkerConfig");
        Writer out = null;
        try {
            Template   t= freeMarkerConfigurer.getConfiguration().getTemplate(templateFileName);

            // 如果根路径存在,则递归创建子目录
            this.creatDirs(htmlFilePath);

            String htmlFile=htmlFilePath + "/" + htmlFileName;
            if(htmlFileName.startsWith("/")){
            	htmlFile=htmlFilePath + htmlFileName;
            }
            
            File afile = new File(htmlFile);

            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(afile),"UTF-8"));
            t.process(propMap, out);
            out.flush();

        }catch (Exception e){
            GeneralExceptionHandler.handle(e);
        }finally {
            out.close();
        }

    }


    @Override
    public void geneHtmlFile(String templatePathName,
                             String templateFileName,
                             String htmlFilePath,
                             String htmlFileName,
                             Map propMap)throws Exception{

        FreeMarkerConfigurer freeMarkerConfigurer =  (FreeMarkerConfigurer) BeanUtil.getBean("freemarkerConfig");
        Writer out = null;
        try {
            Template t= freeMarkerConfigurer.getConfiguration().getTemplate(templatePathName+templateFileName);

            // 如果根路径存在,则递归创建子目录
            this.creatDirs(htmlFilePath);

            String htmlFile=htmlFilePath + "/" + htmlFileName;
            if(htmlFileName.startsWith("/")){
                htmlFile=htmlFilePath + htmlFileName;
            }
            File afile = new File(htmlFile);

            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(afile),"UTF-8"));
            t.process(propMap, out);
            out.flush();
        }catch (Exception e){
            GeneralExceptionHandler.handle(e);
        }finally {
            out.close();
        }



    }


    /**
     * 创建多级目录
     */
    private boolean creatDirs(String path) {
        File aFile = new File(path);
        if (!aFile.exists()) {
            return aFile.mkdirs();
        } else {
            return true;
        }
    }

    /**
     * 判断文件是否存在
     * @param path
     * @return
     */
    private boolean hasFile(String path){
        File aFile = new File(path);
        return aFile.exists();
    }

}
