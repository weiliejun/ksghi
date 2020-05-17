package com.itech.ups.base.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 版本信息：v1.0 日期：2014-3-17 Copyright Mike Chen(chengang_mike@yahoo.cn) 版权所有
 */

public class FileContentTypeHelper {

    private static Map<String, String> CONTENT_TYPE_MAP = new HashMap<String, String>();

    static {
        CONTENT_TYPE_MAP.put("*", "application/octet-stream");
        CONTENT_TYPE_MAP.put("001", "application/x-001");
        CONTENT_TYPE_MAP.put("301", "application/x-301");
        CONTENT_TYPE_MAP.put("323", "text/h323");
        CONTENT_TYPE_MAP.put("906", "application/x-906");
        CONTENT_TYPE_MAP.put("907", "drawing/907");
        CONTENT_TYPE_MAP.put("a11", "application/x-a11");
        CONTENT_TYPE_MAP.put("acp", "audio/x-mei-aac");
        CONTENT_TYPE_MAP.put("ai", "application/postscript");
        CONTENT_TYPE_MAP.put("aif", "audio/aiff");
        CONTENT_TYPE_MAP.put("aifc", "audio/aiff");
        CONTENT_TYPE_MAP.put("aiff", "audio/aiff");
        CONTENT_TYPE_MAP.put("anv", "application/x-anv");
        CONTENT_TYPE_MAP.put("asa", "text/asa");
        CONTENT_TYPE_MAP.put("asf", "video/x-ms-asf");
        CONTENT_TYPE_MAP.put("asp", "text/asp");
        CONTENT_TYPE_MAP.put("asx", "video/x-ms-asf");
        CONTENT_TYPE_MAP.put("au", "audio/basic");
        CONTENT_TYPE_MAP.put("avi", "video/avi");
        CONTENT_TYPE_MAP.put("awf", "application/vnd.adobe.workflow");
        CONTENT_TYPE_MAP.put("biz", "text/xml");
        CONTENT_TYPE_MAP.put("bmp", "application/x-bmp");
        CONTENT_TYPE_MAP.put("bot", "application/x-bot");
        CONTENT_TYPE_MAP.put("c4t", "application/x-c4t");
        CONTENT_TYPE_MAP.put("c90", "application/x-c90");
        CONTENT_TYPE_MAP.put("cal", "application/x-cals");
        CONTENT_TYPE_MAP.put("cat", "application/vnd.ms-pki.seccat");
        CONTENT_TYPE_MAP.put("cdf", "application/x-netcdf");
        CONTENT_TYPE_MAP.put("cdr", "application/x-cdr");
        CONTENT_TYPE_MAP.put("cel", "application/x-cel");
        CONTENT_TYPE_MAP.put("cer", "application/x-x509-ca-cert");
        CONTENT_TYPE_MAP.put("cg4", "application/x-g4");
        CONTENT_TYPE_MAP.put("cgm", "application/x-cgm");
        CONTENT_TYPE_MAP.put("cit", "application/x-cit");
        CONTENT_TYPE_MAP.put("class", "java/*");
        CONTENT_TYPE_MAP.put("cml", "text/xml");
        CONTENT_TYPE_MAP.put("cmp", "application/x-cmp");
        CONTENT_TYPE_MAP.put("cmx", "application/x-cmx");
        CONTENT_TYPE_MAP.put("cot", "application/x-cot");
        CONTENT_TYPE_MAP.put("crl", "application/pkix-crl");
        CONTENT_TYPE_MAP.put("crt", "application/x-x509-ca-cert");
        CONTENT_TYPE_MAP.put("csi", "application/x-csi");
        CONTENT_TYPE_MAP.put("css", "text/css");
        CONTENT_TYPE_MAP.put("cut", "application/x-cut");
        CONTENT_TYPE_MAP.put("dbf", "application/x-dbf");
        CONTENT_TYPE_MAP.put("dbm", "application/x-dbm");
        CONTENT_TYPE_MAP.put("dbx", "application/x-dbx");
        CONTENT_TYPE_MAP.put("dcd", "text/xml");
        CONTENT_TYPE_MAP.put("dcx", "application/x-dcx");
        CONTENT_TYPE_MAP.put("der", "application/x-x509-ca-cert");
        CONTENT_TYPE_MAP.put("dgn", "application/x-dgn");
        CONTENT_TYPE_MAP.put("dib", "application/x-dib");
        CONTENT_TYPE_MAP.put("dll", "application/x-msdownload");
        CONTENT_TYPE_MAP.put("doc", "application/msword");
        CONTENT_TYPE_MAP.put("docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        CONTENT_TYPE_MAP.put("dot", "application/msword");
        CONTENT_TYPE_MAP.put("drw", "application/x-drw");
        CONTENT_TYPE_MAP.put("dtd", "text/xml");
        CONTENT_TYPE_MAP.put("dwf", "Model/vnd.dwf");
        // CONTENT_TYPE_MAP.put("dwf","application/x-dwf");
        CONTENT_TYPE_MAP.put("dwg", "application/x-dwg");
        CONTENT_TYPE_MAP.put("dxb", "application/x-dxb");
        CONTENT_TYPE_MAP.put("dxf", "application/x-dxf");
        CONTENT_TYPE_MAP.put("edn", "application/vnd.adobe.edn");
        CONTENT_TYPE_MAP.put("emf", "application/x-emf");
        CONTENT_TYPE_MAP.put("eml", "message/rfc822");
        CONTENT_TYPE_MAP.put("ent", "text/xml");
        CONTENT_TYPE_MAP.put("epi", "application/x-epi");
        CONTENT_TYPE_MAP.put("eps", "application/x-ps");
        // CONTENT_TYPE_MAP.put("eps","application/postscript");
        CONTENT_TYPE_MAP.put("etd", "application/x-ebx");
        CONTENT_TYPE_MAP.put("exe", "application/x-msdownload");
        CONTENT_TYPE_MAP.put("fax", "image/fax");
        CONTENT_TYPE_MAP.put("fdf", "application/vnd.fdf");
        CONTENT_TYPE_MAP.put("fif", "application/fractals");
        CONTENT_TYPE_MAP.put("fo", "text/xml");
        CONTENT_TYPE_MAP.put("frm", "application/x-frm");
        CONTENT_TYPE_MAP.put("g4", "application/x-g4");
        CONTENT_TYPE_MAP.put("gbr", "application/x-gbr");
        CONTENT_TYPE_MAP.put("gcd", "application/x-gcd");
        CONTENT_TYPE_MAP.put("gif", "image/gif");
        CONTENT_TYPE_MAP.put("gl2", "application/x-gl2");
        CONTENT_TYPE_MAP.put("gp4", "application/x-gp4");
        CONTENT_TYPE_MAP.put("hgl", "application/x-hgl");
        CONTENT_TYPE_MAP.put("hmr", "application/x-hmr");
        CONTENT_TYPE_MAP.put("hpg", "application/x-hpgl");
        CONTENT_TYPE_MAP.put("hpl", "application/x-hpl");
        CONTENT_TYPE_MAP.put("hqx", "application/mac-binhex40");
        CONTENT_TYPE_MAP.put("hrf", "application/x-hrf");
        CONTENT_TYPE_MAP.put("hta", "application/hta");
        CONTENT_TYPE_MAP.put("htc", "text/x-component");
        CONTENT_TYPE_MAP.put("htm", "text/html");
        CONTENT_TYPE_MAP.put("html", "text/html");
        CONTENT_TYPE_MAP.put("htt", "text/webviewhtml");
        CONTENT_TYPE_MAP.put("htx", "text/html");
        CONTENT_TYPE_MAP.put("icb", "application/x-icb");
        CONTENT_TYPE_MAP.put("ico", "image/x-icon");
        // CONTENT_TYPE_MAP.put("ico","application/x-ico");
        CONTENT_TYPE_MAP.put("iff", "application/x-iff");
        CONTENT_TYPE_MAP.put("ig4", "application/x-g4");
        CONTENT_TYPE_MAP.put("igs", "application/x-igs");
        CONTENT_TYPE_MAP.put("iii", "application/x-iphone");
        CONTENT_TYPE_MAP.put("img", "application/x-img");
        CONTENT_TYPE_MAP.put("ins", "application/x-internet-signup");
        CONTENT_TYPE_MAP.put("isp", "application/x-internet-signup");
        CONTENT_TYPE_MAP.put("IVF", "video/x-ivf");
        CONTENT_TYPE_MAP.put("java", "java/*");
        CONTENT_TYPE_MAP.put("jfif", "image/jpeg");
        CONTENT_TYPE_MAP.put("jpe", "image/jpeg");
        // CONTENT_TYPE_MAP.put("jpe","application/x-jpe");
        CONTENT_TYPE_MAP.put("jpeg", "image/jpeg");
        CONTENT_TYPE_MAP.put("jpg", "image/jpeg");
        // CONTENT_TYPE_MAP.put("jpg","application/x-jpg");
        CONTENT_TYPE_MAP.put("js", "application/x-javascript");
        CONTENT_TYPE_MAP.put("jsp", "text/html");
        CONTENT_TYPE_MAP.put("la1", "audio/x-liquid-file");
        CONTENT_TYPE_MAP.put("lar", "application/x-laplayer-reg");
        CONTENT_TYPE_MAP.put("latex", "application/x-latex");
        CONTENT_TYPE_MAP.put("lavs", "audio/x-liquid-secure");
        CONTENT_TYPE_MAP.put("lbm", "application/x-lbm");
        CONTENT_TYPE_MAP.put("lmsff", "audio/x-la-lms");
        CONTENT_TYPE_MAP.put("ls", "application/x-javascript");
        CONTENT_TYPE_MAP.put("ltr", "application/x-ltr");
        CONTENT_TYPE_MAP.put("m1v", "video/x-mpeg");
        CONTENT_TYPE_MAP.put("m2v", "video/x-mpeg");
        CONTENT_TYPE_MAP.put("m3u", "audio/mpegurl");
        CONTENT_TYPE_MAP.put("m4e", "video/mpeg4");
        CONTENT_TYPE_MAP.put("mac", "application/x-mac");
        CONTENT_TYPE_MAP.put("man", "application/x-troff-man");
        CONTENT_TYPE_MAP.put("math", "text/xml");
        CONTENT_TYPE_MAP.put("mdb", "application/msaccess");
        // CONTENT_TYPE_MAP.put("mdb","application/x-mdb");
        CONTENT_TYPE_MAP.put("mfp", "application/x-shockwave-flash");
        CONTENT_TYPE_MAP.put("mht", "message/rfc822");
        CONTENT_TYPE_MAP.put("mhtml", "message/rfc822");
        CONTENT_TYPE_MAP.put("mi", "application/x-mi");
        CONTENT_TYPE_MAP.put("mid", "audio/mid");
        CONTENT_TYPE_MAP.put("midi", "audio/mid");
        CONTENT_TYPE_MAP.put("mil", "application/x-mil");
        CONTENT_TYPE_MAP.put("mml", "text/xml");
        CONTENT_TYPE_MAP.put("mnd", "audio/x-musicnet-download");
        CONTENT_TYPE_MAP.put("mns", "audio/x-musicnet-stream");
        CONTENT_TYPE_MAP.put("mocha", "application/x-javascript");
        CONTENT_TYPE_MAP.put("movie", "video/x-sgi-movie");
        CONTENT_TYPE_MAP.put("mp1", "audio/mp1");
        CONTENT_TYPE_MAP.put("mp2", "audio/mp2");
        CONTENT_TYPE_MAP.put("mp2v", "video/mpeg");
        CONTENT_TYPE_MAP.put("mp3", "audio/mp3");
        CONTENT_TYPE_MAP.put("mp4", "video/mpeg4");
        CONTENT_TYPE_MAP.put("mpa", "video/x-mpg");
        CONTENT_TYPE_MAP.put("mpd", "application/vnd.ms-project");
        CONTENT_TYPE_MAP.put("mpe", "video/x-mpeg");
        CONTENT_TYPE_MAP.put("mpeg", "video/mpg");
        CONTENT_TYPE_MAP.put("mpg", "video/mpg");
        CONTENT_TYPE_MAP.put("mpga", "audio/rn-mpeg");
        CONTENT_TYPE_MAP.put("mpp", "application/vnd.ms-project");
        CONTENT_TYPE_MAP.put("mps", "video/x-mpeg");
        CONTENT_TYPE_MAP.put("mpt", "application/vnd.ms-project");
        CONTENT_TYPE_MAP.put("mpv", "video/mpg");
        CONTENT_TYPE_MAP.put("mpv2", "video/mpeg");
        CONTENT_TYPE_MAP.put("mpw", "application/vnd.ms-project");
        CONTENT_TYPE_MAP.put("mpx", "application/vnd.ms-project");
        CONTENT_TYPE_MAP.put("mtx", "text/xml");
        CONTENT_TYPE_MAP.put("mxp", "application/x-mmxp");
        CONTENT_TYPE_MAP.put("net", "image/pnetvue");
        CONTENT_TYPE_MAP.put("nrf", "application/x-nrf");
        CONTENT_TYPE_MAP.put("nws", "message/rfc822");
        CONTENT_TYPE_MAP.put("odc", "text/x-ms-odc");
        CONTENT_TYPE_MAP.put("out", "application/x-out");
        CONTENT_TYPE_MAP.put("p10", "application/pkcs10");
        CONTENT_TYPE_MAP.put("p12", "application/x-pkcs12");
        CONTENT_TYPE_MAP.put("p7b", "application/x-pkcs7-certificates");
        CONTENT_TYPE_MAP.put("p7c", "application/pkcs7-mime");
        CONTENT_TYPE_MAP.put("p7m", "application/pkcs7-mime");
        CONTENT_TYPE_MAP.put("p7r", "application/x-pkcs7-certreqresp");
        CONTENT_TYPE_MAP.put("p7s", "application/pkcs7-signature");
        CONTENT_TYPE_MAP.put("pc5", "application/x-pc5");
        CONTENT_TYPE_MAP.put("pci", "application/x-pci");
        CONTENT_TYPE_MAP.put("pcl", "application/x-pcl");
        CONTENT_TYPE_MAP.put("pcx", "application/x-pcx");
        CONTENT_TYPE_MAP.put("pdf", "application/pdf");
        CONTENT_TYPE_MAP.put("pdx", "application/vnd.adobe.pdx");
        CONTENT_TYPE_MAP.put("pfx", "application/x-pkcs12");
        CONTENT_TYPE_MAP.put("pgl", "application/x-pgl");
        CONTENT_TYPE_MAP.put("pic", "application/x-pic");
        CONTENT_TYPE_MAP.put("pko", "application/vnd.ms-pki.pko");
        CONTENT_TYPE_MAP.put("pl", "application/x-perl");
        CONTENT_TYPE_MAP.put("plg", "text/html");
        CONTENT_TYPE_MAP.put("pls", "audio/scpls");
        CONTENT_TYPE_MAP.put("plt", "application/x-plt");
        CONTENT_TYPE_MAP.put("png", "image/png");
        CONTENT_TYPE_MAP.put("png", "application/x-png");
        CONTENT_TYPE_MAP.put("pot", "application/vnd.ms-powerpoint");
        CONTENT_TYPE_MAP.put("ppa", "application/vnd.ms-powerpoint");
        CONTENT_TYPE_MAP.put("ppm", "application/x-ppm");
        CONTENT_TYPE_MAP.put("pps", "application/vnd.ms-powerpoint");
        CONTENT_TYPE_MAP.put("ppt", "application/vnd.ms-powerpoint");
        CONTENT_TYPE_MAP.put("pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation");
        CONTENT_TYPE_MAP.put("pr", "application/x-pr");
        CONTENT_TYPE_MAP.put("prf", "application/pics-rules");
        CONTENT_TYPE_MAP.put("prn", "application/x-prn");
        CONTENT_TYPE_MAP.put("prt", "application/x-prt");
        CONTENT_TYPE_MAP.put("ps", "application/x-ps");
        CONTENT_TYPE_MAP.put("ps", "application/postscript");
        CONTENT_TYPE_MAP.put("ptn", "application/x-ptn");
        CONTENT_TYPE_MAP.put("pwz", "application/vnd.ms-powerpoint");
        CONTENT_TYPE_MAP.put("r3t", "text/vnd.rn-realtext3d");
        CONTENT_TYPE_MAP.put("ra", "audio/vnd.rn-realaudio");
        CONTENT_TYPE_MAP.put("ram", "audio/x-pn-realaudio");
        CONTENT_TYPE_MAP.put("ras", "application/x-ras");
        CONTENT_TYPE_MAP.put("rat", "application/rat-file");
        CONTENT_TYPE_MAP.put("rdf", "text/xml");
        CONTENT_TYPE_MAP.put("rec", "application/vnd.rn-recording");
        CONTENT_TYPE_MAP.put("red", "application/x-red");
        CONTENT_TYPE_MAP.put("rgb", "application/x-rgb");
        CONTENT_TYPE_MAP.put("rjs", "application/vnd.rn-realsystem-rjs");
        CONTENT_TYPE_MAP.put("rjt", "application/vnd.rn-realsystem-rjt");
        CONTENT_TYPE_MAP.put("rlc", "application/x-rlc");
        CONTENT_TYPE_MAP.put("rle", "application/x-rle");
        CONTENT_TYPE_MAP.put("rm", "application/vnd.rn-realmedia");
        CONTENT_TYPE_MAP.put("rmf", "application/vnd.adobe.rmf");
        CONTENT_TYPE_MAP.put("rmi", "audio/mid");
        CONTENT_TYPE_MAP.put("rmj", "application/vnd.rn-realsystem-rmj");
        CONTENT_TYPE_MAP.put("rmm", "audio/x-pn-realaudio");
        CONTENT_TYPE_MAP.put("rmp", "application/vnd.rn-rn_music_package");
        CONTENT_TYPE_MAP.put("rms", "application/vnd.rn-realmedia-secure");
        CONTENT_TYPE_MAP.put("rmvb", "application/vnd.rn-realmedia-vbr");
        CONTENT_TYPE_MAP.put("rmx", "application/vnd.rn-realsystem-rmx");
        CONTENT_TYPE_MAP.put("rnx", "application/vnd.rn-realplayer");
        CONTENT_TYPE_MAP.put("rp", "image/vnd.rn-realpix");
        CONTENT_TYPE_MAP.put("rpm", "audio/x-pn-realaudio-plugin");
        CONTENT_TYPE_MAP.put("rsml", "application/vnd.rn-rsml");
        CONTENT_TYPE_MAP.put("rt", "text/vnd.rn-realtext");
        CONTENT_TYPE_MAP.put("rtf", "application/msword");
        // CONTENT_TYPE_MAP.put("rtf","application/x-rtf");
        CONTENT_TYPE_MAP.put("rv", "video/vnd.rn-realvideo");
        CONTENT_TYPE_MAP.put("sam", "application/x-sam");
        CONTENT_TYPE_MAP.put("sat", "application/x-sat");
        CONTENT_TYPE_MAP.put("sdp", "application/sdp");
        CONTENT_TYPE_MAP.put("sdw", "application/x-sdw");
        CONTENT_TYPE_MAP.put("sit", "application/x-stuffit");
        CONTENT_TYPE_MAP.put("slb", "application/x-slb");
        CONTENT_TYPE_MAP.put("sld", "application/x-sld");
        CONTENT_TYPE_MAP.put("slk", "drawing/x-slk");
        CONTENT_TYPE_MAP.put("smi", "application/smil");
        CONTENT_TYPE_MAP.put("smil", "application/smil");
        CONTENT_TYPE_MAP.put("smk", "application/x-smk");
        CONTENT_TYPE_MAP.put("snd", "audio/basic");
        CONTENT_TYPE_MAP.put("sol", "text/plain");
        CONTENT_TYPE_MAP.put("sor", "text/plain");
        CONTENT_TYPE_MAP.put("spc", "application/x-pkcs7-certificates");
        CONTENT_TYPE_MAP.put("spl", "application/futuresplash");
        CONTENT_TYPE_MAP.put("spp", "text/xml");
        CONTENT_TYPE_MAP.put("ssm", "application/streamingmedia");
        CONTENT_TYPE_MAP.put("sst", "application/vnd.ms-pki.certstore");
        CONTENT_TYPE_MAP.put("stl", "application/vnd.ms-pki.stl");
        CONTENT_TYPE_MAP.put("stm", "text/html");
        CONTENT_TYPE_MAP.put("sty", "application/x-sty");
        CONTENT_TYPE_MAP.put("svg", "text/xml");
        CONTENT_TYPE_MAP.put("swf", "application/x-shockwave-flash");
        CONTENT_TYPE_MAP.put("tdf", "application/x-tdf");
        CONTENT_TYPE_MAP.put("tg4", "application/x-tg4");
        CONTENT_TYPE_MAP.put("tga", "application/x-tga");
        CONTENT_TYPE_MAP.put("tif", "image/tiff");
        CONTENT_TYPE_MAP.put("tif", "application/x-tif");
        CONTENT_TYPE_MAP.put("tiff", "image/tiff");
        CONTENT_TYPE_MAP.put("tld", "text/xml");
        CONTENT_TYPE_MAP.put("top", "drawing/x-top");
        CONTENT_TYPE_MAP.put("torrent", "application/x-bittorrent");
        CONTENT_TYPE_MAP.put("tsd", "text/xml");
        CONTENT_TYPE_MAP.put("txt", "text/plain");
        CONTENT_TYPE_MAP.put("uin", "application/x-icq");
        CONTENT_TYPE_MAP.put("uls", "text/iuls");
        CONTENT_TYPE_MAP.put("vcf", "text/x-vcard");
        CONTENT_TYPE_MAP.put("vda", "application/x-vda");
        CONTENT_TYPE_MAP.put("vdx", "application/vnd.visio");
        CONTENT_TYPE_MAP.put("vml", "text/xml");
        CONTENT_TYPE_MAP.put("vpg", "application/x-vpeg005");
        CONTENT_TYPE_MAP.put("vsd", "application/vnd.visio");
        CONTENT_TYPE_MAP.put("vsd", "application/x-vsd");
        CONTENT_TYPE_MAP.put("vss", "application/vnd.visio");
        CONTENT_TYPE_MAP.put("vst", "application/vnd.visio");
        // CONTENT_TYPE_MAP.put("vst","application/x-vst");
        CONTENT_TYPE_MAP.put("vsw", "application/vnd.visio");
        CONTENT_TYPE_MAP.put("vsx", "application/vnd.visio");
        CONTENT_TYPE_MAP.put("vtx", "application/vnd.visio");
        CONTENT_TYPE_MAP.put("vxml", "text/xml");
        CONTENT_TYPE_MAP.put("wav", "audio/wav");
        CONTENT_TYPE_MAP.put("wax", "audio/x-ms-wax");
        CONTENT_TYPE_MAP.put("wb1", "application/x-wb1");
        CONTENT_TYPE_MAP.put("wb2", "application/x-wb2");
        CONTENT_TYPE_MAP.put("wb3", "application/x-wb3");
        CONTENT_TYPE_MAP.put("wbmp", "image/vnd.wap.wbmp");
        CONTENT_TYPE_MAP.put("wiz", "application/msword");
        CONTENT_TYPE_MAP.put("wk3", "application/x-wk3");
        CONTENT_TYPE_MAP.put("wk4", "application/x-wk4");
        CONTENT_TYPE_MAP.put("wkq", "application/x-wkq");
        CONTENT_TYPE_MAP.put("wks", "application/x-wks");
        CONTENT_TYPE_MAP.put("wm", "video/x-ms-wm");
        CONTENT_TYPE_MAP.put("wma", "audio/x-ms-wma");
        CONTENT_TYPE_MAP.put("wmd", "application/x-ms-wmd");
        CONTENT_TYPE_MAP.put("wmf", "application/x-wmf");
        CONTENT_TYPE_MAP.put("wml", "text/vnd.wap.wml");
        CONTENT_TYPE_MAP.put("wmv", "video/x-ms-wmv");
        CONTENT_TYPE_MAP.put("wmx", "video/x-ms-wmx");
        CONTENT_TYPE_MAP.put("wmz", "application/x-ms-wmz");
        CONTENT_TYPE_MAP.put("wp6", "application/x-wp6");
        CONTENT_TYPE_MAP.put("wpd", "application/x-wpd");
        CONTENT_TYPE_MAP.put("wpg", "application/x-wpg");
        CONTENT_TYPE_MAP.put("wpl", "application/vnd.ms-wpl");
        CONTENT_TYPE_MAP.put("wq1", "application/x-wq1");
        CONTENT_TYPE_MAP.put("wr1", "application/x-wr1");
        CONTENT_TYPE_MAP.put("wri", "application/x-wri");
        CONTENT_TYPE_MAP.put("wrk", "application/x-wrk");
        CONTENT_TYPE_MAP.put("ws", "application/x-ws");
        CONTENT_TYPE_MAP.put("ws2", "application/x-ws");
        CONTENT_TYPE_MAP.put("wsc", "text/scriptlet");
        CONTENT_TYPE_MAP.put("wsdl", "text/xml");
        CONTENT_TYPE_MAP.put("wvx", "video/x-ms-wvx");
        CONTENT_TYPE_MAP.put("xdp", "application/vnd.adobe.xdp");
        CONTENT_TYPE_MAP.put("xdr", "text/xml");
        CONTENT_TYPE_MAP.put("xfd", "application/vnd.adobe.xfd");
        CONTENT_TYPE_MAP.put("xfdf", "application/vnd.adobe.xfdf");
        CONTENT_TYPE_MAP.put("xhtml", "text/html");
        CONTENT_TYPE_MAP.put("xls", "application/vnd.ms-excel");
        CONTENT_TYPE_MAP.put("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        CONTENT_TYPE_MAP.put("xlw", "application/x-xlw");
        CONTENT_TYPE_MAP.put("xml", "text/xml");
        CONTENT_TYPE_MAP.put("xpl", "audio/scpls");
        CONTENT_TYPE_MAP.put("xq", "text/xml");
        CONTENT_TYPE_MAP.put("xql", "text/xml");
        CONTENT_TYPE_MAP.put("xquery", "text/xml");
        CONTENT_TYPE_MAP.put("xsd", "text/xml");
        CONTENT_TYPE_MAP.put("xsl", "text/xml");
        CONTENT_TYPE_MAP.put("xslt", "text/xml");
        CONTENT_TYPE_MAP.put("xwd", "application/x-xwd");
        CONTENT_TYPE_MAP.put("x_b", "application/x-x_b");
        CONTENT_TYPE_MAP.put("x_t", "application/x-x_t");
    }

    public static String getContentType(String fileName) {
        fileName = fileName.toLowerCase();
        int loc = fileName.lastIndexOf(".");
        String extension = (loc < 0) ? fileName : fileName.substring(fileName.lastIndexOf(".") + 1);
        String contentType = CONTENT_TYPE_MAP.get(extension);
        if (contentType == null) {
            contentType = CONTENT_TYPE_MAP.get("*");
        }
        return contentType + ";charset=utf-8";
    }
}
