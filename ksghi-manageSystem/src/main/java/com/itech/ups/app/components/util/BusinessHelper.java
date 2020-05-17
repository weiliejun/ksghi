package com.itech.ups.app.components.util;

import com.itech.core.util.StringHelper;

import java.util.Map;

/**
 * 业务工具类
 */
public class BusinessHelper {
    /**
     * 用户分类转换
     */
    public static Map<String, Object> userClassConvert(Map<String, Object> param, Map<String, String> dict) {
        String userLabel = (String) param.get("USER_LABEL");// 用户标签
        String personCode = (String) param.get("PERSON_CODE");// 用户推荐码
        String personOrgCode = (String) param.get("ORG_PERSON_CODE");// 用户机构推荐码
        String orgCode = (String) param.get("ORG_CODE");// 用户机构码
        String recommenderUserLabel = (String) param.get("RECOMMENDER_USER_LABEL");// 推荐人用户标签
        String recommenderPersonCode = (String) param.get("PERSONCODE");// 推荐人用户推荐码
        String recommenderPersonOrgCode = (String) param.get("ORGPERSONCODE");// 推荐人用户机构推荐码
        String recommenderOrgCode = (String) param.get("RECOMMENDER_ORG_CODE");// 推荐人用户机构码
        if ("interior".equals(userLabel)) {// 内部员工
            param.put("USER_CLASS_NAME", dict.get("label-interior-register"));
            param.put("USER_CLASS_CODE", "label-interior-register");
        }

        if ("general".equals(userLabel)) {// 普通会员
            param.put("USER_CLASS_NAME", dict.get("label-general-register"));
            param.put("USER_CLASS_CODE", "label-general-register");
        }
        if ("interior".equals(recommenderUserLabel)) {// 内部员工推荐
            param.put("USER_CLASS_NAME", dict.get("label-interior-recommend"));
            param.put("USER_CLASS_CODE", "label-interior-recommend");
        }

        if ("general".equals(recommenderUserLabel)) {// 普通会员推荐
            param.put("USER_CLASS_NAME", dict.get("label-general-recommend"));
            param.put("USER_CLASS_CODE", "label-general-recommend");
        }

        if (StringHelper.isNotEmpty(orgCode) && StringHelper.isNotEmpty(personOrgCode)) {// 机构用户
            param.put("USER_CLASS_NAME", dict.get("org-" + orgCode.trim().toUpperCase() + "-register"));
            param.put("USER_CLASS_CODE", "org-" + orgCode.trim().toUpperCase() + "-register");
        }
        if (StringHelper.isNotEmpty(recommenderOrgCode) && StringHelper.isNotEmpty(recommenderPersonOrgCode)) {// 机构用户推荐用户
            param.put("USER_CLASS_NAME", dict.get("org-" + recommenderOrgCode.trim().toUpperCase() + "-recommend"));
            param.put("USER_CLASS_CODE", "org-" + recommenderOrgCode.trim().toUpperCase() + "-recommend");
        }
        return param;
    }
}
