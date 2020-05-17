package com.itech.core.util;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 添加图片水印的服务类
 */
public class WaterMark {
    private static Logger logger = Logger.getLogger(WaterMark.class);

    /**
     * 把图片印刷到图片上
     *
     * @param pressImg  -- 水印文件
     * @param targetImg -- 目标文件
     * @param x         --x坐标
     * @param y         --y坐标
     */
    public final static void pressImage(String pressImg, String targetImg, int x, int y) {
        try {
            // 目标文件
            File _file = new File(targetImg);
            Image src = ImageIO.read(_file);
            int wideth = src.getWidth(null);
            int height = src.getHeight(null);
            BufferedImage image = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = image.createGraphics();
            g.drawImage(src, 0, 0, wideth, height, null);

            // 水印文件
            File _filebiao = new File(pressImg);
            Image src_biao = ImageIO.read(_filebiao);
            int wideth_biao = src_biao.getWidth(null);
            int height_biao = src_biao.getHeight(null);

            // 平铺效果
            int count_x = wideth / wideth_biao;
            int count_y = height / height_biao;
            int height_y = 0;
            if (wideth % wideth_biao != 0) {
                count_x += 1;
            }
            if (height % height_biao != 0) {
                count_y += 1;
            }
            for (int i = 0; i < count_y; i++) {
                int width_x = 0;
                for (int j = 0; j < count_x; j++) {
                    g.drawImage(src_biao, width_x, height_y, wideth_biao, height_biao, null);
                    width_x += wideth_biao;
                }
                height_y += height_biao;
            }

            // 中心 水印
            // g.drawImage(src_biao, (wideth - wideth_biao) / 2, (height -
            // height_biao) / 2, wideth_biao, height_biao, null);

            // 水印文件结束
            g.dispose();
            FileOutputStream out = new FileOutputStream(targetImg);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(image);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印文字水印图片
     *
     * @param pressText --文字
     * @param targetImg -- 目标图片
     * @param fontName  -- 字体名
     * @param fontStyle -- 字体样式
     * @param color     -- 字体颜色
     * @param fontSize  -- 字体大小
     * @param x         -- 偏移量
     * @param y
     */

    public static void pressText(String pressText, String targetImg, String fontName, int fontStyle, int color, int fontSize, int x, int y) {
        try {
            File _file = new File(targetImg);
            Image src = ImageIO.read(_file);
            int wideth = src.getWidth(null);
            int height = src.getHeight(null);
            BufferedImage image = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = image.createGraphics();
            g.drawImage(src, 0, 0, wideth, height, null);
            g.setColor(Color.GRAY);
            g.setFont(new Font(fontName, fontStyle, fontSize));

            int j = pressText.length();
            // 斜线型 水印字
            /*
             * if (j >= 15) { g.drawString(pressText, wideth - fontSize - x,
             * height - fontSize/ 2 - y); } else { for (int k = 0; k < j; k++) {
             * char c = pressText.charAt(k); g.drawString(""+c , wideth -
             * fontSize - x, height - fontSize/ 2 - y); x -= 20; y -= 20; } }
             */
            // 普通 水印字
            g.drawString(pressText, wideth - fontSize * (j + 1) - x, height - fontSize / 2 - y);
            g.dispose();
            FileOutputStream out = new FileOutputStream(targetImg);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(image);
            out.close();
        } catch (Exception e) {
            logger.info(e);
        }
    }

    /**
     * pdf 加水印
     *
     * @param imageFilePath 添加水印LOGO路径
     * @param pdfFilePath   PDF文件路径
     **/
    @SuppressWarnings("deprecation")
    public static void pdfWaterMark(String imageFilePath, String pdfFilePath) {
        try {
            File fileDest = File.createTempFile("tempFile", ".pdf"); // 创建临时文件
            File fileSrc = new File(pdfFilePath);
            FileUtils.copyFile(fileSrc, fileDest);
            fileDest.deleteOnExit();
            PdfReader reader = new PdfReader(fileDest.getPath());
            PdfStamper stamper;
            stamper = new PdfStamper(reader, new FileOutputStream(pdfFilePath));

            int total = reader.getNumberOfPages() + 1;

            com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance(imageFilePath);

            // 图片位置 单个水印
            // image.setAbsolutePosition(0, 0);
            PdfContentByte under;
            for (int i = 1; i < total; i++) {
                // under = stamper.getUnderContent(i);
                under = stamper.getOverContent(i);

                Rectangle pageSize = reader.getPageSize(i);
                float width = pageSize.getRight();
                float height = pageSize.getTop();
                float width_biao = image.getWidth();
                float height_biao = image.getHeight();

                // 平铺效果
                int count_x = (int) (width / width_biao);
                int count_y = (int) (height / height_biao);
                int height_y = (int) height;
                if (width % width_biao != 0) {
                    count_x += 1;
                }
                if (height % height_biao != 0) {
                    count_y += 1;
                }
                for (int x = 0; x < count_y; x++) {
                    int width_x = 0;
                    for (int y = 0; y < count_x; y++) {
                        image.setAbsolutePosition(width_x, height_y - height_biao);
                        // 添加水印图片
                        under.addImage(image);
                        width_x += width_biao;
                    }
                    height_y -= height_biao;
                }

                // 添加水印图片 单个水印
                // under.addImage(image);
            }

            stamper.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // pressImage("D:/logo.png", "D:/123.png", 0, 0);
        // pressText("test", "D:/123.png", "SimSun", 1, 255, 20, 320, 320);
        pdfWaterMark("D:/logo.png", "D:/itext.pdf");
    }

}
