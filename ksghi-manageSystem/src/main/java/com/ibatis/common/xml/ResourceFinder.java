package com.ibatis.common.xml;
/**
 * 版本信息：v1.0
 * 日期：2014-3-21
 * Copyright Mike Chen(chengang_mike@yahoo.cn) 版权所有
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

public class ResourceFinder {

    private static final Log logger = LogFactory.getLog(ResourceFinder.class);

    public ResourceFinder() {
    }

    public static String[] getFile(String location) {
        Resource aresource[] = null;
        PathMatchingResourcePatternResolver pathmatchingresourcepatternresolver = new PathMatchingResourcePatternResolver();
        try {
            aresource = pathmatchingresourcepatternresolver.getResources(location);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (aresource == null) {
            return null;
        }
        String[] xmlFiles;
        try {
            xmlFiles = new String[aresource.length];
            int i = 0;
            Resource[] aresource1 = aresource;
            int j = aresource1.length;
            for (int k = 0; k < j; k++) {
                Resource resource = aresource1[k];
                String filePath = resource.getURL().getPath();
                logger.info("realPath = " + filePath);
                String filePath1;
                if (filePath.indexOf(".jar!") > -1) {
                    filePath1 = filePath.substring(filePath.indexOf(".jar!") + 6);
                } else {
                    filePath1 = filePath.substring(filePath.indexOf("classes") + 8);
                }
                xmlFiles[i] = filePath1;
                i++;
            }

        } catch (IOException ioexception) {
            logger.error("error in find resource", ioexception);
            throw new RuntimeException(ioexception);
        }
        return xmlFiles;
    }

}
