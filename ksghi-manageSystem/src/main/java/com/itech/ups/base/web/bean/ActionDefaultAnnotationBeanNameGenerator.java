package com.itech.ups.base.web.bean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * 版本信息：v1.0 日期：2011-12-28 Copyright Mike Chen(chengang_mike@yahoo.cn) 版权所有
 */

public class ActionDefaultAnnotationBeanNameGenerator extends AnnotationBeanNameGenerator {
    @Override
    protected String buildDefaultBeanName(BeanDefinition definition) {
        return definition.getBeanClassName();
    }
}
