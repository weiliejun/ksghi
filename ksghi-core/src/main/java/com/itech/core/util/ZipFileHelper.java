package com.itech.core.util;

import org.apache.log4j.Logger;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

import java.io.*;
import java.util.List;

/**
 * 把多个文件打包到一个文件
 *
 * @author xiaofei.hu
 */
public class ZipFileHelper {
    /**
     * The buffer.
     */
    protected static byte[] buf = new byte[1024];
    private static Logger logger = Logger.getLogger(ZipFileHelper.class);

    public static void toZip(File[] files, File zipFile) {

    }

    /**
     * 遍历目录并添加文件.
     *
     * @param jos      - JAR 输出流
     * @param file     - 目录文件名
     * @param pathName - ZIP中的目录名
     * @throws IOException
     * @throws FileNotFoundException
     */
    private static void recurseFiles(ZipOutputStream jos, File file, String pathName) throws IOException, FileNotFoundException {
        if (file.isDirectory()) {
            pathName = pathName + file.getName() + "/";
            jos.putNextEntry(new ZipEntry(pathName));
            String[] fileNames = file.list();
            if (fileNames != null) {
                for (int i = 0; i < fileNames.length; i++)
                    recurseFiles(jos, new File(file, fileNames[i]), pathName);

            }
        } else {
            ZipEntry jarEntry = new ZipEntry(pathName + file.getName());
            // logger.info(pathName + " " + file.getName());
            FileInputStream fin = new FileInputStream(file);
            BufferedInputStream in = new BufferedInputStream(fin);
            jos.putNextEntry(jarEntry);

            int len;
            while ((len = in.read(buf)) >= 0)
                jos.write(buf, 0, len);
            in.close();
            jos.closeEntry();
        }
    }

    public static void toZip(List<File> files, File zipFile, String zipFolderName, int level) throws IOException, FileNotFoundException {
        level = checkZipLevel(level);

        if (zipFolderName == null) {
            zipFolderName = "";
        }

        ZipOutputStream jos = new ZipOutputStream(new FileOutputStream(zipFile));
        jos.setLevel(level);

        for (int i = 0; i < files.size(); i++) {
            recurseFiles(jos, files.get(i), files.get(i).getPath());
        }

        jos.close();

    }

    /**
     * 创建 ZIP/JAR 文件.
     *
     * @param directory     - 要添加的目录
     * @param zipFile       - 保存的 ZIP 文件名
     * @param zipFolderName - ZIP 中的路径名
     * @param level         - 压缩级别(0~9)
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void makeDirectoryToZip(File directory, File zipFile, String zipFolderName, int level) throws IOException, FileNotFoundException {
        level = checkZipLevel(level);

        if (zipFolderName == null) {
            zipFolderName = "";
        }

        ZipOutputStream jos = new ZipOutputStream(new FileOutputStream(zipFile));
        jos.setLevel(level);

        String[] fileNames = directory.list();
        if (fileNames != null) {
            for (int i = 0; i < fileNames.length; i++)
                recurseFiles(jos, new File(directory, fileNames[i]), zipFolderName);

        }
        jos.close();
    }

    /**
     * 检查并设置有效的压缩级别.
     *
     * @param level - 压缩级别
     * @return 有效的压缩级别或者默认压缩级别
     */
    public static int checkZipLevel(int level) {
        if (level < 0 || level > 9)
            level = 7;
        return level;
    }

}