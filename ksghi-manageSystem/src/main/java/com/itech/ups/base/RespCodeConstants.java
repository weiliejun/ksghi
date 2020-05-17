package com.itech.ups.base;

import java.util.HashMap;
import java.util.Map;

public class RespCodeConstants {
    public static final String SUCCESS = "0000";
    public static final String FAIL = "0001";
    public static final String ERROR = "0002";
    public static final String SIGN_ERROR = "0003";


    /**
     * 系统编码
     */
    //平台系统未在微金客中注册
    public static final String PTR_NO_REGISTER = "9999";
    //平台系统未授权
    public static final String PTR_NO_ACCESS = "9998";
    //平台系统服务器ip没有访问权限
    public static final String PTR_IP_ERROR = "9997";
    //加签名失败
    public static final String ADD_SIGN_ERROR = "9996";
    //验证签名失败
    public static final String VALID_SIGN_ERROR = "9995";
    //请求参数不能为空
    public static final String PARAMS_NULL = "9994";
    //请求参数格式不正确
    public static final String PARAMS_FORMAT_ERROR = "9993";


    public static final Map<String, String> codeMapMsg = new HashMap<String, String>();

    static {
        codeMapMsg.put(SUCCESS, "接口调用成功");
        codeMapMsg.put(FAIL, "接口调用失败");
        codeMapMsg.put(ERROR, "系统异常");
        codeMapMsg.put(SIGN_ERROR, "签名错误");
    }
}
