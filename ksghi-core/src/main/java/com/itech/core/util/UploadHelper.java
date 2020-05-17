package com.itech.core.util;

import com.itech.ups.app.components.filesync.FileSynchronizer;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import org.apache.commons.io.FileUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class UploadHelper {

    public static String createThumb(String fileId, String realPath, String picPath, String rootPath, FileSynchronizer fileSynce) throws Exception {
        int UPLOAD_SMALL_PICTURE_MAX_WIDTH = 120;
        int UPLOAD_SMALL_PICTURE_MAX_HEIGHT = 120;
        String smallPictureFileName = fileId + "_thumbnail.jpg";
        String smallPictureFilePath = realPath + rootPath + "/" + smallPictureFileName;
        File smallPictureFile = new File(smallPictureFilePath);
        if (smallPictureFile.exists()) {
            FileUtils.forceDeleteOnExit(smallPictureFile);
        }
        BufferedImage image = ImageHelper.resizeImage(realPath + picPath, ImageHelper.IMAGE_JPEG, UPLOAD_SMALL_PICTURE_MAX_WIDTH, UPLOAD_SMALL_PICTURE_MAX_HEIGHT);
        ImageHelper.saveImage(image, smallPictureFilePath, ImageHelper.IMAGE_JPEG);

        fileSynce.syncFile(new File(smallPictureFilePath), rootPath, smallPictureFileName); // 上传到网站端

        return rootPath + "/" + smallPictureFileName;

    }

    public static String pdfIndexToJpg(String fileId, String realPath, String pdfPath, String jpgDestPath, FileSynchronizer fileSynce) throws Exception {

        String jpgPath = null;

        File file = new File(realPath + pdfPath);
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        FileChannel channel = raf.getChannel();
        MappedByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());

        PDFFile pdffile = new PDFFile(buf);
        PDFPage page = pdffile.getPage(1);

        Rectangle rect = new Rectangle(0, 0, ((int) page.getBBox().getWidth()), ((int) page.getBBox().getHeight()));
        Image img = page.getImage(rect.width, rect.height, rect, null, // null
                // for
                // the
                // ImageObserver
                true, // fill background with white
                true // block until drawing is done
        );
        BufferedImage tag = new BufferedImage(rect.width, rect.height, BufferedImage.TYPE_INT_RGB);
        tag.getGraphics().drawImage(img, 0, 0, rect.width, rect.height, null);

        jpgPath = jpgDestPath + "/" + fileId + "_thumbnail.jpg";
        FileOutputStream out = new FileOutputStream(realPath + jpgPath);

        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(tag);
        param.setQuality(1f, false);// 1f是提高生成的图片质量

        encoder.setJPEGEncodeParam(param);
        encoder.encode(tag); // JPEG编码

        out.close();

        channel.close();
        raf.close();
        fileSynce.syncFile(new File(realPath + jpgPath), jpgDestPath, fileId + "_thumbnail.jpg");
        return jpgPath;
    }

}
