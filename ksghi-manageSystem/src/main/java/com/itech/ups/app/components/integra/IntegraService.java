package com.itech.ups.app.components.integra;

import com.itech.core.util.DateHelper;
import com.itech.ups.app.components.integra.exception.ParameterNullPointerException;
import com.itech.ups.app.components.integra.exception.ProcessErrorException;
import com.itech.ups.app.components.integra.infrastructure.IntegraRepository;
import com.itech.ups.app.user.application.domain.UserIntegra;
import com.itech.ups.app.user.application.domain.UserIntegraRule;
import com.singularsys.jep.Jep;
import com.singularsys.jep.JepException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.*;

/*
 * ===========================================================================
 * Copyright 2007 WEBTRANING Corp. All Rights Reserved.
 * WEBTRANING PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * @version 1.0, 2014-7-1
 * @author  zqs
 * ===========================================================================
 *
 */

public class IntegraService {

    private static Logger logger = Logger.getLogger(IntegraService.class);

    private static IntegraRepository integraRepository;

    static {
        WebApplicationContext factory = ContextLoader.getCurrentWebApplicationContext();
        integraRepository = (IntegraRepository) factory.getBean("integraRepository");
    }

    private static String[] getExpressionVariable(String expressionStr) {
        String[] variables = StringUtils.substringsBetween(expressionStr.trim(), "${", "}");

        List<String> variablesList = new ArrayList<String>();
        if (!ArrayUtils.isEmpty(variables)) {
            for (int i = 0; i < variables.length; i++) {
                String varName = variables[i];
                if (CollectionUtils.isNotEmpty(variablesList)) {
                    for (Iterator<String> iterator = variablesList.iterator(); iterator.hasNext(); ) {
                        String varNameTmp = iterator.next();
                        if (varName.equals(varNameTmp)) {
                            break;
                        } else {
                            variablesList.add(varName);
                            break;
                        }
                    }
                } else {
                    variablesList.add(varName);
                }
            }
        }
        String[] result = new String[variablesList.size()];
        System.arraycopy(variablesList.toArray(), 0, result, 0, variablesList.size());

        return result;
    }

    public static long getPayIntegra(String busiType, Map<String, Long> params) throws ProcessErrorException, NullPointerException {
        long result = 0;

        UserIntegraRule userIntegraRule = integraRepository.findUserIntegraRuleByBusiType(busiType);
        if (null != userIntegraRule) {
            boolean enable = false;
            Calendar currentDate = DateHelper.getYMDFormatCalendar(DateHelper.getYMDFormatDate(new Date()));
            if (StringUtils.isNotBlank(userIntegraRule.getStartDate()) && StringUtils.isNotBlank(userIntegraRule.getEndDate())) {
                Calendar startDate = DateHelper.getYMDFormatCalendar(userIntegraRule.getStartDate());
                Calendar endDate = DateHelper.getYMDFormatCalendar(userIntegraRule.getEndDate());
                if (currentDate.compareTo(startDate) >= 0 && currentDate.compareTo(endDate) <= 0) {
                    enable = true;
                }
            }
            if (StringUtils.isNotBlank(userIntegraRule.getStartDate()) && StringUtils.isBlank(userIntegraRule.getEndDate())) {
                Calendar startDate = DateHelper.getYMDFormatCalendar(userIntegraRule.getStartDate());
                if (currentDate.compareTo(startDate) >= 0) {
                    enable = true;
                }
            }
            if (StringUtils.isBlank(userIntegraRule.getStartDate()) && StringUtils.isNotBlank(userIntegraRule.getEndDate())) {
                Calendar endDate = DateHelper.getYMDFormatCalendar(userIntegraRule.getEndDate());
                if (currentDate.compareTo(endDate) <= 0) {
                    enable = true;
                }
            }
            if (StringUtils.isBlank(userIntegraRule.getStartDate()) && StringUtils.isBlank(userIntegraRule.getEndDate())) {
                enable = true;
            }

            if (StringUtils.isNotBlank(userIntegraRule.getRuleExpression()) && enable) {
                String expression = userIntegraRule.getRuleExpression();

                Jep jep = new Jep();
                try {
                    String[] variableArray = getExpressionVariable(userIntegraRule.getRuleExpression());
                    if (!ArrayUtils.isEmpty(variableArray)) {
                        for (int i = 0; i < variableArray.length; i++) {
                            String key = variableArray[i];
                            if (StringUtils.isNotBlank(key)) {
                                Long value = params.get(key);
                                if (null == value) {
                                    throw new ParameterNullPointerException(key);
                                }

                                expression = expression.replace("${" + key + "}", key);
                                jep.addVariable(key, value);
                            }
                        }
                    }
                    jep.parse(expression);
                    result = new BigDecimal(jep.evaluateD()).setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
                } catch (JepException e) {
                    e.printStackTrace();
                    throw new ProcessErrorException("表达式处理异常" + e.getMessage());
                }
            }
        } else {
            throw new NullPointerException("UserIntegraRule");
        }

        return result;
    }

    public static boolean sendIntegra(String userInfoId, IntegraType integraType, String busiType, String relationId, String description, Map<String, Long> params) throws ParameterNullPointerException, ProcessErrorException, NullPointerException {
        boolean result = false;
        if (StringUtils.isBlank(userInfoId)) {
            throw new ParameterNullPointerException("userInfoId");
        }
        if (null == integraType) {
            throw new ParameterNullPointerException("integraType");
        }
        if (StringUtils.isBlank(busiType)) {
            throw new ParameterNullPointerException("busiType");
        }
        if (StringUtils.isBlank(relationId)) {
            throw new ParameterNullPointerException("relationId");
        }

        long integraAmount = getPayIntegra(busiType, params);
        if (integraAmount > 0) {
            UserIntegra userIntegra = new UserIntegra();
            userIntegra.setUserInfoId(userInfoId);
            userIntegra.setChangeNum(integraAmount);
            userIntegra.setType(integraType.toString());
            userIntegra.setBusiType(busiType);
            userIntegra.setRelationId(relationId);
            userIntegra.setDescription(description);
            userIntegra.setDataStatus("valid");
            userIntegra.setCreateTime(DateHelper.getYMDHMFormatDate(new Date()));

            integraRepository.addUserIntegra(userIntegra);
            logger.info("添加用户积分明细信息：" + new JSONObject(userIntegra));

            integraRepository.editUserInfoForIntegraAmount(userInfoId, integraType.toString(), integraAmount);
            result = true;
        }
        return result;
    }
}