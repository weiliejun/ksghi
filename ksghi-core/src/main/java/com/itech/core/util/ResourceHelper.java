package com.itech.core.util;

import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

/*
 * ===========================================================================
 * Copyright 2007 WEBTRANING Corp. All Rights Reserved.
 * WEBTRANING PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * @version 1.0, 2007-8-11
 * @author  Jack Chen
 * reference spring ResourceUtils
 * ===========================================================================
 *
 */

/**
 * Utility methods for resolving resource locations to files in the file system.
 * Mainly for internal use within the framework.
 * <p>
 * <p>
 * Consider using Spring's Resource abstraction in the core package for handling
 * all kinds of file resources in a uniform manner. ResourceLoader's
 * <code>getLocation</code> can resolve any location to a Resource object, which
 * in turn allows to get a <code>java.io.File</code> in the file system through
 * its <code>getFile</code> method.
 * <p>
 * <p>
 * The main reason for these utility methods for resource location handling is
 * to support Log4jConfigurer, which must be able to resolve resource locations
 * <i>before the logging system has been initialized</i>. Spring' Resource
 * abstraction in the core package, on the other hand, already expects the
 * logging system to be available.
 */
public class ResourceHelper {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    public static final String CLASSPATH_URL_PREFIX = "classpath:";
    /**
     * URL prefix for loading from the file system: "file:"
     */
    public static final String FILE_URL_PREFIX = "file:";
    /**
     * URL protocol for a file in the file system: "file"
     */
    public static final String URL_PROTOCOL_FILE = "file";
    /**
     * URL protocol for an entry from a jar file: "jar"
     */
    public static final String URL_PROTOCOL_JAR = "jar";
    /**
     * URL protocol for an entry from a zip file: "zip"
     */
    public static final String URL_PROTOCOL_ZIP = "zip";
    /**
     * URL protocol for an entry from a WebSphere jar file: "wsjar"
     */
    public static final String URL_PROTOCOL_WSJAR = "wsjar";
    /**
     * Separator between JAR URL and file path within the JAR
     */
    public static final String JAR_URL_SEPARATOR = "!/";

    public ResourceHelper() {
        super();
        // constructor from parent
    }

    /**
     * Return whether the given resource location is a URL: either a special
     * "classpath" pseudo URL or a standard URL.
     *
     * @see #CLASSPATH_URL_PREFIX
     * @see java.net.URL
     */
    public static boolean isUrl(String resourceLocation) {
        if (resourceLocation == null) {
            return false;
        }
        if (resourceLocation.startsWith(CLASSPATH_URL_PREFIX)) {
            return true;
        }
        try {
            new URL(resourceLocation);
            return true;
        } catch (MalformedURLException ex) {
            return false;
        }
    }

    /**
     * Resolve the given resource location to a <code>java.net.URL</code>.
     * <p>
     * Does not check whether the URL actually exists; simply returns the URL
     * that the given location would correspond to.
     *
     * @param resourceLocation the resource location to resolve: either a "classpath:" pseudo
     *                         URL, a "file:" URL, or a plain file path
     * @return a corresponding URL object
     * @throws FileNotFoundException if the resource cannot be resolved to a URL
     */
    public static URL getURL(String resourceLocation) throws FileNotFoundException {
        Assert.notNull(resourceLocation, "Resource location must not be null");
        if (resourceLocation.startsWith(CLASSPATH_URL_PREFIX)) {
            String path = resourceLocation.substring(CLASSPATH_URL_PREFIX.length());
            URL url = ClassUtils.getDefaultClassLoader().getResource(path);
            if (url == null) {
                String description = "class path resource [" + path + "]";
                throw new FileNotFoundException(description + " cannot be resolved to URL because it does not exist");
            }
            return url;
        }
        try {
            // try URL
            return new URL(resourceLocation);
        } catch (MalformedURLException ex) {
            // no URL -> treat as file path
            try {
                return new URL(FILE_URL_PREFIX + resourceLocation);
            } catch (MalformedURLException ex2) {
                throw new FileNotFoundException("Resource location [" + resourceLocation + "] is neither a URL not a well-formed file path");
            }
        }
    }

    /**
     * Resolve the given resource location to a <code>java.io.File</code>, i.e.
     * to a file in the file system.
     * <p>
     * Does not check whether the fil actually exists; simply returns the File
     * that the given location would correspond to.
     *
     * @param resourceLocation the resource location to resolve: either a "classpath:" pseudo
     *                         URL, a "file:" URL, or a plain file path
     * @return a corresponding File object
     * @throws FileNotFoundException if the resource cannot be resolved to a file in the file
     *                               system
     */
    public static File getFile(String resourceLocation) throws FileNotFoundException {
        Assert.notNull(resourceLocation, "Resource location must not be null");
        if (resourceLocation.startsWith(CLASSPATH_URL_PREFIX)) {
            String path = resourceLocation.substring(CLASSPATH_URL_PREFIX.length());
            String description = "class path resource [" + path + "]";
            URL url = ClassUtils.getDefaultClassLoader().getResource(path);
            if (url == null) {
                throw new FileNotFoundException(description + " cannot be resolved to absolute file path " + "because it does not reside in the file system");
            }
            return getFile(url, description);
        }
        try {
            // try URL
            return getFile(new URL(resourceLocation));
        } catch (MalformedURLException ex) {
            // no URL -> treat as file path
            return new File(resourceLocation);
        }
    }

    /**
     * Resolve the given resource URL to a <code>java.io.File</code>, i.e. to a
     * file in the file system.
     *
     * @param resourceUrl the resource URL to resolve
     * @return a corresponding File object
     * @throws FileNotFoundException if the URL cannot be resolved to a file in the file system
     */
    public static File getFile(URL resourceUrl) throws FileNotFoundException {
        return getFile(resourceUrl, "URL");
    }

    /**
     * Resolve the given resource URL to a <code>java.io.File</code>, i.e. to a
     * file in the file system.
     *
     * @param resourceUrl the resource URL to resolve
     * @param description a description of the original resource that the URL was
     *                    created for (for example, a class path location)
     * @return a corresponding File object
     * @throws FileNotFoundException if the URL cannot be resolved to a file in the file system
     */
    public static File getFile(URL resourceUrl, String description) throws FileNotFoundException {
        Assert.notNull(resourceUrl, "Resource URL must not be null");
        if (!URL_PROTOCOL_FILE.equals(resourceUrl.getProtocol())) {
            throw new FileNotFoundException(description + " cannot be resolved to absolute file path " + "because it does not reside in the file system: " + resourceUrl);
        }
        return new File(URLDecoder.decode(resourceUrl.getFile()));
    }

    /**
     * Determine whether the given URL points to a resource in a jar file, that
     * is, has protocol "jar", "zip" or "wsjar".
     * <p>
     * "zip" and "wsjar" are used by BEA WebLogic Server and IBM WebSphere,
     * respectively, but can be treated like jar files.
     *
     * @param url the URL to check
     */
    public static boolean isJarURL(URL url) {
        String protocol = url.getProtocol();
        return (URL_PROTOCOL_JAR.equals(protocol) || URL_PROTOCOL_ZIP.equals(protocol) || URL_PROTOCOL_WSJAR.equals(protocol));
    }

    /**
     * Extract the URL for the actual jar file from the given URL (which may
     * point to a resource in a jar file or to a jar file itself).
     *
     * @param jarUrl the original URL
     * @return the URL for the actual jar file
     * @throws MalformedURLException if no valid jar file URL could be extracted
     */
    public static URL extractJarFileURL(URL jarUrl) throws MalformedURLException {
        String urlFile = jarUrl.getFile();
        int separatorIndex = urlFile.indexOf(JAR_URL_SEPARATOR);
        if (separatorIndex != -1) {
            return new URL(urlFile.substring(0, separatorIndex));
        } else {
            return jarUrl;
        }
    }

}
