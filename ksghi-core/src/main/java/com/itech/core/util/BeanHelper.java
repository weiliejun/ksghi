package com.itech.core.util;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.*;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * ===========================================================================
 * Copyright 2007 CHENGANG Corp. All Rights Reserved.
 * @version 1.0, ${date}
 * @author  Jack Chen
 * ===========================================================================
 *
 */

/**
 * 扩展Apache Commons BeanUtils, 提供一些反射方面缺失的封装.
 */
public class BeanHelper extends org.apache.commons.beanutils.BeanUtils {

    private BeanHelper() {
    }

    /**
     * 暴力获取当前类声明的private/protected变量
     */
    static public Object getDeclaredProperty(Object object, String propertyName) throws IllegalAccessException, NoSuchFieldException {
        Assert.notNull(object);
        Assert.hasText(propertyName);
        Field field = object.getClass().getDeclaredField(propertyName);
        return getDeclaredProperty(object, field);
    }

    /**
     * 暴力获取当前类声明的private/protected变量
     */
    static public Object getDeclaredProperty(Object object, Field field) throws IllegalAccessException {
        Assert.notNull(object);
        Assert.notNull(field);
        boolean accessible = field.isAccessible();
        field.setAccessible(true);
        Object result = field.get(object);
        field.setAccessible(accessible);
        return result;
    }

    /**
     * 暴力设置当前类声明的private/protected变量
     */
    static public void setDeclaredProperty(Object object, String propertyName, Object newValue) throws IllegalAccessException, NoSuchFieldException {
        Assert.notNull(object);
        Assert.hasText(propertyName);

        Field field = object.getClass().getDeclaredField(propertyName);
        setDeclaredProperty(object, field, newValue);
    }

    /**
     * 暴力设置当前类声明的private/protected变量
     */
    static public void setDeclaredProperty(Object object, Field field, Object newValue) throws IllegalAccessException {
        boolean accessible = field.isAccessible();
        field.setAccessible(true);
        field.set(object, newValue);
        field.setAccessible(accessible);
    }

    /**
     * 暴力调用当前类声明的private/protected函数
     */
    static public Object invokePrivateMethod(Object object, String methodName, Object[] params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Assert.notNull(object);
        Assert.hasText(methodName);
        Class[] types = new Class[params.length];
        for (int i = 0; i < params.length; i++) {
            types[i] = params[i].getClass();
        }
        Method method = object.getClass().getDeclaredMethod(methodName, types);

        boolean accessible = method.isAccessible();
        method.setAccessible(true);
        Object result = method.invoke(object, params);
        method.setAccessible(accessible);
        return result;
    }

    /**
     * 获得field的getter名称
     */
    public static String getAccessorName(Class type, String fieldName) {
        Assert.hasText(fieldName, "FieldName required");
        Assert.notNull(type, "Type required");

        if (type.getName().equals("boolean")) {
            return "is" + StringUtils.capitalize(fieldName);
        } else {
            return "get" + StringUtils.capitalize(fieldName);
        }
    }

    /**
     * Copy the property values of the given source bean into the target bean.
     * <p>
     * Note: The source and target classes do not have to match or even be
     * derived from each other, as long as the properties match. Any bean
     * properties that the source bean exposes but the target bean does not will
     * silently be ignored.
     * <p>
     * This is just a convenience method. For more complex transfer needs,
     * consider using a full BeanWrapper.
     *
     * @param source the source bean
     * @param target the target bean
     * @throws BeansException if the copying failed
     * @see BeanWrapper
     */
    public static void copyProperties(Object source, Object target) throws BeansException {
        copyProperties(source, target, null, null);
    }

    /**
     * Copy the property values of the given source bean into the given target
     * bean, only setting properties defined in the given "editable" class (or
     * interface).
     * <p>
     * Note: The source and target classes do not have to match or even be
     * derived from each other, as long as the properties match. Any bean
     * properties that the source bean exposes but the target bean does not will
     * silently be ignored.
     * <p>
     * This is just a convenience method. For more complex transfer needs,
     * consider using a full BeanWrapper.
     *
     * @param source   the source bean
     * @param target   the target bean
     * @param editable the class (or interface) to restrict property setting to
     * @throws BeansException if the copying failed
     * @see BeanWrapper
     */
    public static void copyProperties(Object source, Object target, Class editable) throws BeansException {

        copyProperties(source, target, editable, null);
    }

    /**
     * Copy the property values of the given source bean into the given target
     * bean, ignoring the given "ignoreProperties".
     * <p>
     * Note: The source and target classes do not have to match or even be
     * derived from each other, as long as the properties match. Any bean
     * properties that the source bean exposes but the target bean does not will
     * silently be ignored.
     * <p>
     * This is just a convenience method. For more complex transfer needs,
     * consider using a full BeanWrapper.
     *
     * @param source           the source bean
     * @param target           the target bean
     * @param ignoreProperties array of property names to ignore
     * @throws BeansException if the copying failed
     * @see BeanWrapper
     */
    public static void copyProperties(Object source, Object target, String[] ignoreProperties) throws BeansException {

        copyProperties(source, target, null, ignoreProperties);
    }

    /**
     * Copy the property values of the given source bean into the given target
     * bean.
     * <p>
     * Note: The source and target classes do not have to match or even be
     * derived from each other, as long as the properties match. Any bean
     * properties that the source bean exposes but the target bean does not will
     * silently be ignored.
     *
     * @param source           the source bean
     * @param target           the target bean
     * @param editable         the class (or interface) to restrict property setting to
     * @param ignoreProperties array of property names to ignore
     * @throws BeansException if the copying failed
     * @see BeanWrapper
     */
    private static void copyProperties(Object source, Object target, Class editable, String[] ignoreProperties) throws BeansException {

        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");

        Class actualEditable = target.getClass();
        if (editable != null) {
            if (!editable.isInstance(target)) {
                throw new IllegalArgumentException("Target class [" + target.getClass().getName() + "] not assignable to Editable class [" + editable.getName() + "]");
            }
            actualEditable = editable;
        }
        PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(actualEditable);
        List ignoreList = (ignoreProperties != null) ? Arrays.asList(ignoreProperties) : null;

        for (int i = 0; i < targetPds.length; i++) {
            PropertyDescriptor targetPd = targetPds[i];
            if (targetPd.getWriteMethod() != null && (ignoreProperties == null || (!ignoreList.contains(targetPd.getName())))) {
                PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd != null && sourcePd.getReadMethod() != null) {
                    try {
                        Method readMethod = sourcePd.getReadMethod();
                        if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                            readMethod.setAccessible(true);
                        }
                        Object value = readMethod.invoke(source, new Object[0]);
                        Method writeMethod = targetPd.getWriteMethod();
                        if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                            writeMethod.setAccessible(true);
                        }
                        writeMethod.invoke(target, new Object[]{value});
                    } catch (Exception ex) {
                        throw new FatalBeanException("Could not copy properties from source to target", ex);
                    }
                }
            }
        }
    }

    public static String getProperties(Object bean) {

        return BeanHelperBean.getInstance().getProperties(bean);
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null || srcValue.equals("null")) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
