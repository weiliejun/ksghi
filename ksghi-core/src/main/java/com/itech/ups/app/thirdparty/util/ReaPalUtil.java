package com.itech.ups.app.thirdparty.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itech.core.util.DateHelper;
import com.itech.core.util.StringHelper;
import com.itech.ups.app.components.filesync.FileSynchronizer;
import com.itech.ups.app.thirdparty.exception.BaseRuntimeException;
import com.itech.ups.app.thirdparty.exception.DataProcessingException;
import com.itech.ups.app.thirdparty.exception.UnsupportedEncodingException;
import com.itech.ups.app.thirdparty.exception.VerificationSignErrorException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author 张可乐
 * @version 1.0
 * @description 融宝托付工具类
 * @update 2018-2-26 下午2:20:55
 */
public class ReaPalUtil {
    private final static Logger logger = Logger.getLogger(ReaPalUtil.class);
    static Properties prop = new Properties();
    private static String REAPAL_BASE_URL = "";
    private static String REAPAL_MD5_KEY = "";
    private static String VERSION = "1.0";//版本号
    private static String VERSION2 = "2.0";//版本号
    private static String VERSION3 = "3.0";//版本号
    private static String PARTNER = "";//商户号
    private static String SIGNTYPE = "0";//签名方式 MD5：0，RSA：1
    private static String DEFAULT_CHARSET = "UTF-8";
    private static String AUTO_TENDER = "1";//允许自动投标
    private static String NO_AUTO_TENDER = "0";//不允许自动投标
    private static String PRODUCT_STATUS_TENDER = "02";//募集中
    private static String PRODUCT_STATUS_REPAYING = "03";//已放款
    private static String PRODUCT_STATUS_REPAYED = "04";//已结清

    static {
        try {
            InputStream is = FileSynchronizer.class.getResourceAsStream("/config/reapal.properties");
            prop.load(is);
            REAPAL_BASE_URL = prop.getProperty("reapalBaseUrl");
            REAPAL_MD5_KEY = prop.getProperty("reapalMD5Key");
            VERSION = prop.getProperty("reapalVersion");
            PARTNER = prop.getProperty("reapalPartner");
            SIGNTYPE = prop.getProperty("reapalSignType");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param content
     * @param key
     * @param charset
     * @return
     * @throws Exception
     * @description MD5加密
     * @version 1.0
     * @author 张可乐
     * @update 2018-2-26 下午2:41:06
     */
    public static String sign(String content, String key, String charset) {
        String signData = content + key;
        String sign = null;
        try {
            sign = DigestUtils.md5Hex(signData.getBytes(charset));
            return sign;
        } catch (java.io.UnsupportedEncodingException e) {
            logger.error("MD5签名[content = " + content + "; charset = " + charset + "]时发生异常！", e);
            throw new BaseRuntimeException("MD5签名[content = " + content + "; charset = " + charset + "]时发生异常！");
        }
    }

    /**
     * 请求参数添加公共参数
     */
    public static Map<String, String> addCommonParams(String apiName, Map<String, String> param) {
        String version = param.get("version");
        APIName api = APIName.valueOf(apiName);

        if (version == null || "".equals(version)) {
            param.put("version", api.getVersion());
        }

        param.put("service", api.getService());
        param.put("partner", PARTNER);
        param.put("signType", SIGNTYPE);

        //
        return param;
    }

    /**
     * 请求参数添加签名
     */
    public static Map<String, String> addSign(Map<String, String> param) {
        String reqData = param.get("reqData");
        String sign = null;
        try {
            sign = sign(reqData, REAPAL_MD5_KEY, DEFAULT_CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        param.put("sign", sign);
        return param;
    }

    /**
     * 生成订单号
     */
    public static String getOrderNo() {
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String uuid = format.format(new Date().getTime()) + new Double(Math.random() * 100000).intValue();
        while (uuid.length() < 22) {
            uuid = uuid + "0";
        }
        uuid = uuid.substring(2);
        return uuid;
    }


    /**
     * @param params
     * @return
     * @description 请求融宝托付接口
     * @version 1.0
     * @author 张可乐
     * @update 2018-2-26 下午2:38:05
     */
    public static String httpPost(Map<String, String> params) {
        String respContent = "";
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String service = params.get("service");
        String requestURI = getRequestUrl(service);
        HttpPost post = new HttpPost(requestURI);
        UrlEncodedFormEntity formEntiry = buildUrlEncodedFormEntity(params);
        post.setEntity(formEntiry);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(post);
            if (response == null) {
                throw new NullPointerException("后台调用返回response响应对象为空！");
            }
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                respContent = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != response) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return respContent;
    }


    public static UrlEncodedFormEntity buildUrlEncodedFormEntity(Map<String, String> params) {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        UrlEncodedFormEntity formEntity = null;
        try {
            formEntity = new UrlEncodedFormEntity(nvps, DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException("请求融宝托付接口,参数编码异常");
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new DataProcessingException();
        }
        return formEntity;
    }

    /**
     * 解析请求返回结果
     */
    public static Map<String, String> parseResponseContent(String responseContent) {
        Map<String, String> paramsMap = new HashMap<String, String>();
        if (responseContent != null && responseContent.length() > 0) {
            String[] paramPair = responseContent.split("&");
            int length = paramPair.length;
            if (length > 1) {
                String[] keyValue = null;
                String key = null;
                String value = null;
                for (int i = 0; i < length; i++) {
                    keyValue = paramPair[i].split("=");
                    key = keyValue[0];
                    value = keyValue.length == 1 ? "" : keyValue[1];
                    paramsMap.put(key, value);
                }
            } else {
                paramsMap.put("resError", responseContent);
                JSONObject errorJson = JSON.parseObject(responseContent);
                paramsMap.put("resultCode", errorJson.getString("errorCode"));
                paramsMap.put("resultMsg", errorJson.getString("errorMsg"));
            }
        }
        //正常业务返回,验证签名
        String resData = StringHelper.replaceBlank(paramsMap.get("resData"));
        if (resData != null && resData.length() > 0) {
            paramsMap.put("resData", resData);
            JSONObject successJson = JSON.parseObject(resData);
            String resultCode = successJson.getString("resultCode");
            String resultMsg = successJson.getString("resultMsg");
            resultCode = resultCode == null ? "0000" : resultCode;
            resultMsg = resultMsg == null ? "业务处理成功" : resultMsg;
            paramsMap.put("resultCode", resultCode);
            paramsMap.put("orderNo", successJson.getString("orderNo"));
            paramsMap.put("contracts", successJson.getString("contracts"));
            paramsMap.put("resultMsg", resultMsg);
            String sign = paramsMap.get("sign");
            String verifySign = sign(resData, REAPAL_MD5_KEY, DEFAULT_CHARSET);
            //签名错误
            if (!sign.equals(verifySign)) {
                throw new VerificationSignErrorException();
            }
        }

        return paramsMap;
    }

    /**
     * 解析Form请求返回结果
     */
    public static Map<String, String> parseFormResponseContent(HttpServletRequest request) {
        Map<String, String> resultMap = new HashMap<String, String>();
        Enumeration e = request.getParameterNames();
        while (e.hasMoreElements()) {
            String paramName = (String) e.nextElement();//调用nextElement方法获得元素
            String paramValue = request.getParameter(paramName);
            resultMap.put(paramName, paramValue);
        }
        //正常业务返回,验证签名
        String resData = StringHelper.replaceBlank(resultMap.get("resData"));
        if (resData != null && resData.length() > 0) {
            resultMap.put("resData", resData);
            JSONObject successJson = JSON.parseObject(resData);
            String resultCode = successJson.getString("resultCode");
            String errorCode = successJson.getString("errorCode");
            String errorMsg = successJson.getString("errorMsg");
            if (StringHelper.isNotEmpty(resultCode)) {
                resultMap.put("resultCode", resultCode);
            } else {
                resultMap.put("resultCode", errorCode);
            }
            if (StringHelper.isNotEmpty(errorMsg)) {
                resultMap.put("resultMsg", errorMsg);
            } else {
                resultMap.put("resultMsg", "业务处理成功");
            }
            resultMap.put("orderNo", successJson.getString("orderNo"));
            resultMap.put("contracts", successJson.getString("contracts"));
            String sign = resultMap.get("sign");
            String verifySign = sign(resData, REAPAL_MD5_KEY, DEFAULT_CHARSET);
            //签名错误
            if (!sign.equals(verifySign)) {
                throw new VerificationSignErrorException();
            }
        } else {
            //错误业务返回
            String resError = StringHelper.replaceBlank(resultMap.get("resError"));
            JSONObject errorJson = JSON.parseObject(resError);
            resultMap.put("orderNo", errorJson.getString("orderNo"));
            resultMap.put("resultCode", errorJson.getString("errorCode"));
            resultMap.put("resultMsg", errorJson.getString("errorMsg"));
        }
        return resultMap;
    }

    /**
     * 根据接口名称获取请求url
     */
    public static String getRequestUrl(String service) {
        APIName api = APIName.getAPIName(service);
        return REAPAL_BASE_URL + api.getApiCallUrl();
    }

    /**
     * 获取商户号
     */
    public static String getPartner() {
        return PARTNER;
    }

    /**
     * 获取商户协议号
     */
    public static String getPartnerContracts() {
        return "R" + PARTNER;
    }

    /**
     * app返回结果参数转化
     */
    public static Map<String, String> paramConvert(Map<String, String> param) {
        String resultCode = param.get("resultCode");

        if (StringHelper.isNotEmpty(resultCode)) {
            param.remove("resultCode");
            if ("0000".equals(resultCode)) {
                param.put("flag", "true");
            } else {
                param.put("flag", "false");
            }

        }
        String resultMsg = param.get("resultMsg");
        if (StringHelper.isNotEmpty(resultMsg)) {
            param.remove("resultMsg");
            param.put("msg", resultMsg);

        }
        return param;
    }

    /**
     * 通过商户余额查询接口判断服务器是否正常运行
     */
    public static boolean isConnServer() {
        //组装参数，发送请求
        Map<String, String> param = new HashMap<String, String>();
        JSONObject temp = new JSONObject();
        temp.put("contracts", ReaPalUtil.getPartnerContracts());
        temp.put("queryTime", DateHelper.getYMDHMSFormatDate(new Date()));
        param.put("reqData", JSON.toJSONString(temp));
        addCommonParams(APIName.balanceQuery.toString(), param);
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String service = param.get("service");
        String requestURI = getRequestUrl(service);
        HttpPost post = new HttpPost(requestURI);
        UrlEncodedFormEntity formEntiry = buildUrlEncodedFormEntity(param);
        post.setEntity(formEntiry);
        HttpResponse response = null;
        try {
            response = httpClient.execute(post);
            if (response == null) {
                return false;
            }
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return true;
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static enum APIName {
        //个人签约[Form 形式]
        userContract(VERSION3, "reapal.trust.userContract", "/reagw/agreement/agree.htm"),
        //一键签约
        onekeyContract(VERSION3, "reapal.trust.onekeyContract", "/reagw/agreement/agree.htm"),
        //企业一键签约 [Form 形式]
        comContract(VERSION3, "reapal.trust.comContract", "/reagw/agreement/agree.htm"),
        //企业一键签约
        comContractAPI(VERSION3, "/reagw/agreement/agree.htm", "/reagw/agreement/agree.htm"),
        //签约查询
        contractQuery(VERSION3, "reapal.trust.contractQuery", "/reagw/agreement/agreeApi.htm"),
        //余额查询
        balanceQuery(VERSION3, "reapal.trust.balanceQuery", "/reagw/agreement/agreeApi.htm"),
        //签约手机号修改（Form）
        mobileModify(VERSION3, "reapal.trust.mobileModify", "/reagw/user/rest.htm"),
        //签约手机号修改（短信）(API)
        mobileModifyApplyAPI(VERSION3, "reapal.trust.mobileModifyApplyAPI", "/reagw/user/restApi.htm"),
        //签约手机号修改（确认）
        mobileModifyConfirmAPI(VERSION3, "reapal.trust.mobileModifyConfirmAPI", "/reagw/user/restApi.htm"),
        //签约手机号修改（重发短信）
        mobileModifyRepeatAPI(VERSION3, "reapal.trust.mobileModifyRepeatAPI", "/reagw/user/restApi.htm"),
        //手机号查询
        mobileQuery(VERSION3, "reapal.trust.mobileQuery", "/reagw/user/restApi.htm"),
        //网银充值 [Form]
        depositApply(VERSION3, "reapal.trust.depositApply", "/reagw/service/deposit.htm"),
        //快捷充值（签约）
        depositApplyAPI(VERSION3, "reapal.trust.depositApplyAPI", "/reagw/service/depwit.htm"),
        //快捷充值（确认）
        depositConfirmAPI(VERSION3, "reapal.trust.depositConfirmAPI", "/reagw/service/depwit.htm"),
        //快捷充值（重发短信）
        depositSmsAPI(VERSION3, "reapal.trust.depositSmsAPI", "/reagw/service/depwit.htm"),
        //快捷充值（卡密鉴权）
        certificate(VERSION3, "reapal.trust.certificate", "/reagw/service/depwit.htm"),
        //充值查询
        depositQuery(VERSION3, "reapal.trust.depositQuery", "/reagw/service/depwit.htm"),
        //提现
        withdrawApply(VERSION3, "reapal.trust.withdrawApply", "/reagw/service/withdraw.htm"),
        //提现查询
        withdrawQuery(VERSION3, "reapal.trust.withdrawQuery", "/reagw/service/depwit.htm"),
        //银行卡绑定
        bankCardAdd(VERSION3, "reapal.trust.bankCardAdd", "/reagw/bankcard/bankCardForm.htm"),
        //绑卡查询
        bindQuery(VERSION3, "reapal.trust.bindQuery", "/reagw/user/restApi.htm"),
        // 撤销绑卡
        undoBindBankCard(VERSION3, "reapal.trust.undoBindBankCard", "/reagw/bankcard/undoBindBankApi.htm"),
        //修改绑卡
        modifyBindBankCard(VERSION3, "reapal.trust.modifyBindBankCard", "/reagw/bankcard/modifyBindBankApi.htm"),
        //企业分账
        subAccount(VERSION3, "reapal.trust.subAccount", "/reagw/service/depwit.htm"),
        //企业分账查询
        subAccountQuery(VERSION3, "reapal.trust.subAccountQuery", "/reagw/service/depwit.htm"),
        // 修改交易密码
        modifyTradePassword(VERSION3, "reapal.trust.modifyTradePassword", "/reagw/findTradePassword/findTradePassword.htm"),
        // 重置交易密码（Form）
        findTradePassword(VERSION3, "reapal.trust.findTradePassword", "/reagw/findTradePassword/findTradePassword.htm"),
        //发 标
        tenderApply(VERSION3, "reapal.trust.tenderApply", "/reagw/tender/rest.htm"),
        //投 标 [From]
        tenderInvest(VERSION3, "reapal.trust.tenderInvest", "/reagw/tender/rest.htm"),
        // 一键投标
        onekeyInvest(VERSION3, "reapal.trust.onekeyInves", "/reagw/tender/rest.htm"),
        //一键投标（短信）
        onekeyInvestSMS(VERSION3, "reapal.trust.onekeyInvestSMS", "/reagw/tender/rest.htm"),
        //一键投标（确认）
        onekeyInvestConfirm(VERSION3, "reapal.trust.onekeyInvestConfirm", "/reagw/tender/rest.htm"),
        // 一键投标（重发短信）
        onekeyInvestSmsAPIAgain(VERSION3, "reapal.trust.onekeyInvestSmsAPIAgain", "/reagw/tender/rest.htm"),
        // 单笔投标撤销
        tenderAllCancel(VERSION3, "reapal.trust.tenderAllCancel", "/reagw/tender/rest.htm"),
        //满标
        tenderFinish(VERSION3, "reapal.trust.tenderFinish", "/reagw/tender/rest.htm"),
        // 流水号查询（ 满标查询）
        tenderFinishSQuery(VERSION3, "reapal.trust.tenderFinishSQuerys", "/reagw/tender/rest.htm"),
        // 流水号查询（还款查询）
        tenderRefundSQuery(VERSION3, "reapal.trust.tenderRefundSQuery", "/reagw/tender/rest.htm"),
        // 流水号查询（债权转让）
        tenderTransferSQuery(VERSION3, "reapal.trust.tenderTransferSQuery", "/reagw/tender/rest.htm"),
        // 订单号-单笔-查询（发标单笔）
        tenderApplySQuery(VERSION3, "reapal.trust.tenderApplySQuery", "/reagw/tender/rest.htm"),
        // 订单号-单笔-查询（投标单笔）
        tenderInvestSQuery(VERSION3, "reapal.trust.tenderInvestSQuery", "/reagw/tender/rest.htm"),
        //订单号-批量-查询（投标撤消）
        tenderCancelMQuery(VERSION3, "reapal.trust.tenderCancelMQuery", "/reagw/tender/rest.htm"),
        //订单号-批量-查询（满标）
        tenderFinishMQuery(VERSION3, "reapal.trust.tenderFinishMQuery", "/reagw/tender/rest.htm"),
        //订单号-批量-查询（还款）
        tenderRefundMQuery(VERSION3, "reapal.trust.tenderRefundMQuery", "/reagw/tender/rest.htm"),
        //订单号-批量-查询（债权转让）
        tenderTransferMQuery(VERSION3, "reapal.trust.tenderTransferMQuery", "/reagw/tender/rest.htm"),
        //债权转让  [From]
        signleTenderTransfer(VERSION3, "reapal.trust.signleTenderTransfer", "/reagw/tender/rest.htm"),
        //一键 债权转让
        onekeySignleTransfer(VERSION3, "reapal.trust.onekeySignleTransfer", "/reagw/tender/rest.htm"),
        //一键债权转让（短信）
        onekeySignleTransferSMS(VERSION3, "reapal.trust.onekeySignleTransferSMS", "/reagw/tender/rest.htm"),
        //一键债权转让（确认）
        onekeySignleTransferConfirm(VERSION3, "reapal.trust.onekeySignleTransferConfirm", "/reagw/tender/rest.htm"),
        //一键债权转让（重发短信）
        onekeySignleTransferSmsAgain(VERSION3, "reapal.trust.onekeySignleTransferSmsAgain", "/reagw/tender/rest.htm"),
        // 还款 [异步Form]
        tenderRefund(VERSION3, "reapal.trust.tenderRefund", "/reagw/tender/rest.htm"),
        //一键还款
        onekeyRefund(VERSION3, "reapal.trust.onekeyRefund", "/reagw/tender/rest.htm"),
        //一键还款（短信）
        onekeyRefundSMS(VERSION3, "reapal.trust.onekeyRefundSMS", "/reagw/tender/rest.htm"),
        //一键还款（确认）
        onekeyRefundConfirm(VERSION3, "reapal.trust.onekeyRefundConfirm", "/reagw/tender/rest.htm"),
        //一键还款（重发短信）
        onekeyRefundSMSAPIAgain(VERSION3, "reapal.trust.onekeyRefundSMSAPIAgain", "/reagw/tender/rest.htm"),
        // 设置历史用户角色（API）
        setHistoryUserType(VERSION3, "reapal.trust.setHistoryUserType", "/reagw/agreement/setHistoryUserType.htm"),
        // 历史标的信息修改（API）
        historyTenderInfoModify(VERSION3, "reapal.trust.historyTenderInfoModify", "/reagw/tender/rest.htm"),
        //快捷充值（Form）
        depositWebPay(VERSION3, "reapal.trust.depositWebPay", "/reagw/service/depwit.htm");


        /**
         * 版本号
         */
        private String version;
        /**
         * 接口名称
         */
        private String service;
        /**
         * 接口请求地址
         */
        private String apiCallUrl;

        private APIName() {

        }

        private APIName(String version, String service, String apiCallUrl) {
            this.version = version;

            this.service = service;

            this.apiCallUrl = apiCallUrl;
        }

        /**
         * 根据接口名称获取接口枚举
         *
         * @param service
         * @return
         */
        public static APIName getAPIName(String service) {
            for (APIName api : APIName.values()) {
                if (api.getService().equals(service)) {
                    return api;
                }
            }
            return null;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }

        public String getApiCallUrl() {
            return apiCallUrl;
        }

        public void setApiCallUrl(String apiCallUrl) {
            this.apiCallUrl = apiCallUrl;
        }
    }

    //设备通道
    public static class Busway {
        public static final String PC = "00";//PC端
        public static final String MOBILE = "01";//手机端
        public static final String PAD = "02";//Pad端
        public static final String OTHER = "03";//其它

    }

}
