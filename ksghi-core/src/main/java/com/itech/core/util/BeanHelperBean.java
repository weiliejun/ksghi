package com.itech.core.util;

import com.itech.core.exception.BaseRuntimeException;
import org.apache.commons.beanutils.ContextClassLoaderLocal;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class BeanHelperBean {

    private static final ContextClassLoaderLocal beansByClassLoader = new ContextClassLoaderLocal() {
        protected Object initialValue() {
            return new BeanHelperBean();
        }
    };

    public BeanHelperBean() {
        ConvertUtils.deregister();
        ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class);
        ConvertUtils.register(new BigIntegerConverter(null), BigInteger.class);
        ConvertUtils.register(new BooleanConverter(null), Boolean.TYPE);
        ConvertUtils.register(new BooleanConverter(null), Boolean.class);
        ConvertUtils.register(new ByteConverter(null), Byte.TYPE);
        ConvertUtils.register(new ByteConverter(null), Byte.class);
        ConvertUtils.register(new CharacterConverter(null), Character.TYPE);
        ConvertUtils.register(new CharacterConverter(null), Character.class);
        ConvertUtils.register(new DoubleConverter(null), Double.TYPE);
        ConvertUtils.register(new DoubleConverter(null), Double.class);
        ConvertUtils.register(new FloatConverter(null), Float.TYPE);
        ConvertUtils.register(new FloatConverter(null), Float.class);
        ConvertUtils.register(new IntegerConverter(null), Integer.TYPE);
        ConvertUtils.register(new IntegerConverter(null), Integer.class);
        ConvertUtils.register(new LongConverter(null), Long.TYPE);
        ConvertUtils.register(new LongConverter(null), Long.class);
        ConvertUtils.register(new ShortConverter(null), Short.TYPE);
        ConvertUtils.register(new ShortConverter(null), Short.class);
        ConvertUtils.register(new StringConverter(), String.class);
        ConvertUtils.register(new SqlDateConverter(null), java.sql.Date.class);
        ConvertUtils.register(new SqlTimeConverter(null), java.sql.Time.class);
        ConvertUtils.register(new SqlTimestampConverter(null), java.sql.Timestamp.class);
    }

    public synchronized static BeanHelperBean getInstance() {
        return (BeanHelperBean) beansByClassLoader.get();
    }

    /**
     * 得到javabean所有的属性,要求javabean的所有属性是从Object继承下来的。
     *
     * @param bean bean实例
     * @return 形如“name=value,name1=value1”的String值
     */
    public synchronized String getProperties(Object bean) {
        StringBuffer sb = new StringBuffer(512);
        int index = 0;
        Method[] methodsOfBean = bean.getClass().getMethods();
        Field[] fields = bean.getClass().getDeclaredFields();
        String property = null;
        String objStr = null;
        String nameGet = null;
        String nameGetAttr = null;
        String fieldName = null;
        try {
            for (int j = 0; j < fields.length; j++) {
                Field field = fields[j];
                fieldName = field.getName();

                for (int i = 0; i < methodsOfBean.length; i++) {
                    nameGet = methodsOfBean[i].getName().substring(0, 3);
                    nameGetAttr = methodsOfBean[i].getName().substring(3);
                    if (fieldName.toLowerCase().equalsIgnoreCase(nameGetAttr.toLowerCase())) {
                        if (("get".equalsIgnoreCase(nameGet)) && !("class".equalsIgnoreCase(nameGetAttr)) && !("SERVLETWRAPPER".equalsIgnoreCase(nameGetAttr.toUpperCase())) && !("MULTIPARTREQUESTHANDLER").equalsIgnoreCase(nameGetAttr.toUpperCase())) {
                            Object args = methodsOfBean[i].invoke(bean, null);
                            if (args != null) {
                                objStr = args.toString();
                            } else {
                                objStr = "null";
                            }

                            property = getObj(args, objStr);

                            if (index == 0) {
                                sb.append(nameGetAttr.toUpperCase() + "=" + property);
                                index++;
                            } else {
                                sb.append("," + nameGetAttr.toUpperCase() + "=" + property);
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            throw new BaseRuntimeException(ex);
        }

        return sb.toString();
    }

    /**
     * 得到数组的每个元素的值
     *
     * @param obj Object[] 对象数组
     * @return String
     */
    private String getArray(Object[] obj) { // array
        StringBuffer sb = new StringBuffer(512);
        String property;
        String objStr = null;
        for (int index = 0; index < obj.length; index++) {
            objStr = obj[index].toString();
            property = getObj(obj[index], objStr);

            if (index == 0) {
                sb.append("[" + index + "]=" + property);
            } else {
                sb.append(",[" + index + "]=" + property);
            }
        }
        return sb.toString();
    }

    /**
     * 得到map的每个元素的值
     *
     * @param map Map
     * @return String
     */
    private String getMap(Map map) { // map
        return getIterator(map.values().iterator());
    }

    /**
     * 获取Iterator所有元素的值
     *
     * @param iterator
     * @return 以“,”隔开的元素值字符串
     */
    private String getIterator(Iterator iterator) { // iterator
        StringBuffer sb = new StringBuffer(512);
        String property = null;
        String objStr = null;
        int index = 0;
        for (Iterator it = iterator; it.hasNext(); ) {
            Object obj = it.next();
            objStr = obj.toString();
            property = getObj(obj, objStr);

            if (index == 0) {
                sb.append(property);
                index++;
            } else {
                sb.append("," + property);
            }
        }
        return sb.toString();
    }

    /**
     * 得到对象指定的属性值
     *
     * @param obj      javabean对象
     * @param property 属性
     * @return String
     */
    private String getObj(Object obj, String property) { // 集合
        if (obj instanceof java.lang.String) {
            property = "<" + getProperties(obj) + ">";
        } else if (obj instanceof Collection) {
            if (property.startsWith("[") && property.endsWith("]")) {
                Collection collection = (Collection) obj;
                property = "<coll: " + getIterator(collection.iterator()) + " coll>";
            }

        } else if (obj instanceof Map) {

            if (property.startsWith("{") && property.endsWith("}")) {
                Map map = (Map) obj;
                property = "<map: " + getMap(map) + " map>";

            }

        } else if (obj instanceof Object[]) {
            if (property.startsWith("[") && !property.endsWith("]")) {
                Object[] arr = ((Object[]) obj);
                property = "<arr: " + getArray(arr) + " arr>";
            }
        }

        return property;
    }
}
