package me.binf.utils;

import net.coobird.thumbnailator.Thumbnails;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by wangbin on 2014/12/30.
 */
public class ImageUtil {


    public static void thumbImage(File srcFile,String destDir,String destImage,int width,int height)throws IOException {
        BufferedImage srcImage = javax.imageio.ImageIO.read(srcFile);
        Thumbnails.of(srcImage)
                .size(width,height)
                .outputQuality(1)
                .keepAspectRatio(false)
                .toFile(new File(destDir, destImage));
    }





}
