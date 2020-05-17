package com.baidu.ueditor.upload;

import com.baidu.ueditor.PathFormat;
import com.baidu.ueditor.define.BaseState;
import com.baidu.ueditor.define.FileType;
import com.baidu.ueditor.define.State;
import com.itech.core.util.CommonReadParam;
import com.itech.ups.app.components.filesync.FileSynchronizer;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component(value = "binaryUploader")
public class BinaryUploader {
    @Resource
    FileSynchronizer fileSynce;

    public static final State save(HttpServletRequest request, Map<String, Object> conf) {
        FileItemStream fileStream = null;
        boolean isAjaxUpload = request.getHeader("X_Requested_With") != null;

        if (!(ServletFileUpload.isMultipartContent(request))) {
            return new BaseState(false, 5);
        }

        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());

        if (isAjaxUpload)
            upload.setHeaderEncoding("UTF-8");

        try {
            FileItemIterator iterator = upload.getItemIterator(request);

            while (iterator.hasNext()) {
                fileStream = iterator.next();

                if (!(fileStream.isFormField()))
                    break;
                fileStream = null;
            }

            if (fileStream == null) {
                return new BaseState(false, 7);
            }

            String savePath = (String) conf.get("savePath");
            String originFileName = fileStream.getName();
            String suffix = FileType.getSuffixByFilename(originFileName);

            originFileName = originFileName.substring(0, originFileName.length() - suffix.length());
            savePath = savePath + suffix;

            long maxSize = ((Long) conf.get("maxSize")).longValue();

            if (!(validType(suffix, (String[]) conf.get("allowFiles")))) {
                return new BaseState(false, 8);
            }

            savePath = PathFormat.parse(savePath, originFileName);
            // 特殊处理
            // String physicalPath = ((String)conf.get("rootPath")) + savePath;
            CommonReadParam param = new CommonReadParam("config/application");
            String serverPath = param.getString("product.pictureServerURL");
            String physicalPath = savePath.replace(suffix, "");
            FileSynchronizer sync = new FileSynchronizer();
            InputStream is = fileStream.openStream();
            try {
                // sync.syncFileByIs(physicalPath,fileStream.getName(),is);
                // String filePath = "D:/周笔畅 - 谁动了我的琴弦.mp3";
                // String fileName = "周笔畅 - 谁动了我的琴弦.mp3";
                // File file = new File(filePath);
                // FileInputStream iss = new FileInputStream(file);
                sync.syncFileByIs(physicalPath, fileStream.getName(), is);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            State storageState = new BaseState(true);
            storageState.putInfo("size", "");
            storageState.putInfo("title", "");
            // State storageState = StorageManager.saveFileByInputStream(is,
            // physicalPath, maxSize);
            is.close();
            // �ڴ��޸�Դ�룬��֤�ܹ��ڱ༭������ʾ
            // if (storageState.isSuccess()) {

            storageState.putInfo("url", serverPath + physicalPath + "/" + fileStream.getName());
            // storageState.putInfo("url",
            // PathFormat.format(request.getSession().getServletContext().getContextPath()+savePath));
            // storageState.putInfo("url", PathFormat.format(savePath));
            storageState.putInfo("type", suffix);
            storageState.putInfo("original", originFileName + suffix);
            // }

            return storageState;
        } catch (FileUploadException e) {
            return new BaseState(false, 6);
        } catch (java.io.IOException e) {
        }
        return new BaseState(false, 4);
    }

    private static boolean validType(String type, String[] allowTypes) {
        List list = Arrays.asList(allowTypes);

        return list.contains(type);
    }
}