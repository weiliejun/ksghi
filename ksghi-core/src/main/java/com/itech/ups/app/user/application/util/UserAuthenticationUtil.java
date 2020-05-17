package com.itech.ups.app.user.application.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itech.core.util.HttpClientHelper;
import com.itech.core.util.MD5Util;
import com.itech.core.util.StringHelper;
import org.apache.commons.net.util.Base64;
import org.apache.http.HttpRequest;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 张可乐
 * @version 1.0
 * @description 实名认证工具类
 * @upda+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++te 2018-1-29 下午1:05:34
 */
public class UserAuthenticationUtil {

    public static final String AUTHENTICATION_BASE_URL = "https://ali.ksghi.com/vjk-ali-services/";

    public static final String AUTHENTICATION_TOKEN = "VwO7V8Q__";

    public static final String AUTHENTICATION_KEY = "VwO7V8QVu8azqQ__";


    private static Map<String, String> codeMsgMap = new HashMap<String, String>();

    static {
        codeMsgMap.put("1", "认证通过");
        codeMsgMap.put("-1", "没有提交记录");
        codeMsgMap.put("0", "认证中");
        codeMsgMap.put("2", "认证不通过");
        codeMsgMap.put("error0", "请求数据包内容中相关参数含有空值或非法值");
        codeMsgMap.put("error2", "请求方式错误，请使用 POST 方式发送请求");
        codeMsgMap.put("error3", "请求方式与调用接口凭证（token）错误");
        codeMsgMap.put("Error.DuplicatedTicketId", "重复提交");
        codeMsgMap.put("Error.MaterialsUploadError", "认证资料中错误，请检查图片地址的有效性");
        codeMsgMap.put("Error.RealNameCheckFail", "姓名和证件号不匹配");
        codeMsgMap.put("InvalidParam.RecordNotFound", "没有找到和 ticket_id 关联的记录");
    }

    /**
     * 认证图片名称
     */
    public static String generatePhotoName(String userId, String fileType, String extension) {
        StringBuilder photoName = new StringBuilder();
        photoName.append(MD5Util.Md5(userId));
        photoName.append(fileType);
        photoName.append(".");
        photoName.append(extension);
        return photoName.toString();
    }

    /**
     * 获取实名认证请求url
     */
    public static String getAuthenticationUrl(String apiType) {
        StringBuilder url = new StringBuilder(AUTHENTICATION_BASE_URL);
        url.append(StringHelper.captureName(apiType));
        url.append("?token=");
        url.append(AUTHENTICATION_TOKEN);
        return url.toString();
    }

    /**
     * 获取实名认证请求参数
     */
    public static String getAuthenticationRequestJson(Map<String, String> param) {
        JSONObject paramJson = new JSONObject();
        if (ApiType.submitAuthenticationData.toString().equals(param.get("apiType"))) {
            paramJson.put("ticket_id", param.get("ticketId"));
            paramJson.put("person_name", param.get("personName"));
            paramJson.put("id_number", param.get("idNumber"));
            paramJson.put("face_pic", param.get("facePic"));
            paramJson.put("card_front_pic", param.get("cardFrontPic"));
            paramJson.put("card_back_pic", param.get("cardBackPic"));
        } else if (ApiType.queryAuthenticationInfo.toString().equals(param.get("apiType"))) {
            paramJson.put("ticket_id", param.get("ticketId"));
        } else if (ApiType.getAuthenticationData.toString().equals(param.get("apiType"))) {
            paramJson.put("ticket_id", param.get("ticketId"));
        } else {
            paramJson.putAll(param);
        }
        return JSON.toJSONString(paramJson);
    }

    /**
     * 获取实名认证codeMsg
     */
    public static String getAuthenticationCodeMsg(String code) {
        String msg = codeMsgMap.get(code);
        return msg != null ? msg : "请联系管理员排查";
    }

    /**
     * 实名认证 加密
     */
    public static String encrypt(String input, String key) {
        byte[] crypted = null;
        try {
            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            //用GBK解决中文乱码
            crypted = cipher.doFinal(input.getBytes("GBK"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(Base64.encodeBase64(crypted));
    }


    /**
     * 实名认证解密
     */
    public static String decrypt(String input, String key) {
        byte[] decrypted = null;
        try {
            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skey);
            decrypted = cipher.doFinal(Base64.decodeBase64(input));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //用GBK解决中文乱码
        return new String(decrypted, Charset.forName("GBK"));
    }

    /**
     * 实名认证发送请求
     */
    public static String httpPost(Map<String, String> param) {
        String url = getAuthenticationUrl(param.get("apiType"));
        String data = getAuthenticationRequestJson(param);
        //请求参数需要加密
        data = encrypt(data, AUTHENTICATION_KEY);
        CloseableHttpClient httpClient = HttpClientHelper.getHttpClient();
        HttpRequest request = new HttpPost(url);
        CloseableHttpResponse response = null;
        String respContent = "";
        try {
            HttpPost httpPost = (HttpPost) request;
            httpPost.setEntity(new StringEntity(data, ContentType.create("text/plain", "UTF-8")));
            response = httpClient.execute(httpPost);
            if (response == null) {
                throw new NullPointerException("后台调用返回response响应对象为空！");
            }
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                respContent = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
            return decrypt(respContent, AUTHENTICATION_KEY);
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    /**
     * 实名认证apiType
     */
    public static enum ApiType {
        submitAuthenticationData,//提交认证资料
        queryAuthenticationInfo,//查询认证状态
        getAuthenticationData//获取认证资料
    }

    /**
     * 实名认证业务类型
     */
    public static enum BusinessType {
        openAccount,//开户
        accountSafe//账户安全
    }

    /**
     * 实名认证图片类型
     */
    public static enum FileType {
        cardFront,//身份证正面
        cardBack,//身份证反面面
        face//手持身份证
    }
}
