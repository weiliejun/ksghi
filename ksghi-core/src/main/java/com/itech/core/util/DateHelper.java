package com.itech.core.util;

import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
 * ===========================================================================
 * Copyright 2007 WEBTRANING Corp. All Rights Reserved.
 * WEBTRANING PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * @version 1.0, 2007-8-11
 * @author  Jack Chen
 * ===========================================================================
 *
 */

public class DateHelper {
    public static final String DATE_FORMAT_YMDHMS = "YYYY-MM-DD HH24:MI:SS";
    public static final String DATE_FORMAT_YMD = "YYYY-MM-DD";
    private static Logger logger = Logger.getLogger(DateHelper.class);

    public DateHelper() {
        super();
        // constructor from parent
    }

    /**
     * 返回系统当前日期
     *
     * @return
     */

    public static java.sql.Date getCurrentDate() {
        return new java.sql.Date(System.currentTimeMillis());
    }

    /**
     * 将日期型数据转换成 YYYY-MM-DD 格式的字符串
     *
     * @param d java.util.Date
     * @return 格式化后的字符串
     */
    public static String getYMDFormatDate(Date d) {
        return getDate(d, "YYYY-MM-DD");
    }

    /**
     * 将日期型数据转换成 YYYY-MM 格式的字符串
     *
     * @param d java.util.Date
     * @return 格式化后的字符串
     */
    public static String getYMFormatDate(Date d) {
        return getDate(d, "YYYY-MM");
    }

    /**
     * 将YYYY-MM-DD HH24:MI:SS型数据转换成 yyyy年MM月dd日 格式的字符串
     *
     * @param d YYYY-MM-DD HH24:MI:SS
     * @return 格式化后的字符串
     */
    public static String getYMDFormatDate(String d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        return sdf.format(stringToDate(d, DATE_FORMAT_YMDHMS));
    }

    /**
     * 将日期型数据转换成 YYYYMMDDHH24MISS 格式的字符串
     *
     * @param d java.util.Date
     * @return 格式化后的字符串
     */
    public static String getNoSeparatorYMDHMSFormatDate(Date d) {
        return getDate(d, "YYYYMMDDHH24MISS");
    }

    /**
     * 将YYYY-MM-DD型数据转换成 yyyy年MM月dd日 格式的字符串
     *
     * @param d YYYY-MM-DD HH24:MI:SS
     * @return 格式化后的字符串
     */
    public static String getYMDFormatDatess(String d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        return sdf.format(stringToDate(d, DATE_FORMAT_YMD));
    }

    /**
     * 将日期型数据转换成 YYYYMMDD 格式的字符串
     *
     * @param d java.util.Date
     * @return 格式化后的字符串
     */
    public static String getNoSeparatorYMDFormatDate(Date d) {
        return getDate(d, "YYYYMMDD");
    }

    /**
     * 获取当前日期字符串，格式为：YYYY-MM-DD HH24:MI:SS
     *
     * @param time
     * @return
     */
    public static String getNowDateStr() {
        return getYMDHMSFormatDate(new Date());
    }

    /**
     * 将日期型数据转换成 YYYY-MM-DD HH24:MI:SS 格式的字符串
     *
     * @param d java.util.Date
     * @return 格式化后的字符串
     */
    public static String getYMDHMSFormatDate(Date d) {
        return getDate(d, "YYYY-MM-DD HH24:MI:SS");
    }


    /**
     * 将日期型数据转换成 YYYY年MM月DD日 E HH24:MI 格式的字符串
     *
     * @param d java.util.Date
     * @return 格式化后的字符串
     */
    public static String getYMDEHMFormatDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 E HH:MM");
        return sdf.format(new Date());
    }

    /**
     * 将日期型数据转换成 YYYY年MM月DD日格式的字符串
     *
     * @param d java.util.Date
     * @return 格式化后的字符串
     */
    public static String getYMDFormatDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        return sdf.format(new Date());
    }

    /**
     * 将日期型数据转换成 YYYY-MM-DD HH24:MI 格式的字符串
     *
     * @param d java.util.Date
     * @return 格式化后的字符串
     */
    public static String getYMDHMFormatDate(Date d) {
        return getDate(d, "YYYY-MM-DD HH24:MI");
    }

    /**
     * 获取输入格式的日期字符串，字符串遵循Oracle格式
     *
     * @param d      -日期
     * @param format -指定日期格式，格式的写法为Oracle格式
     * @return 按指定的日期格式转换后的日期字符串
     */
    public static String getDate(Date d, String format) {
        if (d == null)
            return "";
        Hashtable h = new Hashtable();
        String javaFormat = new String();
        String s = format.toLowerCase();
        if (s.indexOf("yyyy") != -1)
            h.put(new Integer(s.indexOf("yyyy")), "yyyy");
        else if (s.indexOf("yy") != -1)
            h.put(new Integer(s.indexOf("yy")), "yy");
        if (s.indexOf("mm") != -1)
            h.put(new Integer(s.indexOf("mm")), "MM");

        if (s.indexOf("dd") != -1)
            h.put(new Integer(s.indexOf("dd")), "dd");
        if (s.indexOf("hh24") != -1)
            h.put(new Integer(s.indexOf("hh24")), "HH");
        if (s.indexOf("mi") != -1)
            h.put(new Integer(s.indexOf("mi")), "mm");
        if (s.indexOf("ss") != -1)
            h.put(new Integer(s.indexOf("ss")), "ss");

        int intStart = 0;
        while (s.indexOf("-", intStart) != -1) {
            intStart = s.indexOf("-", intStart);
            h.put(new Integer(intStart), "-");
            intStart++;
        }

        intStart = 0;
        while (s.indexOf("/", intStart) != -1) {
            intStart = s.indexOf("/", intStart);
            h.put(new Integer(intStart), "/");
            intStart++;
        }

        intStart = 0;
        while (s.indexOf(" ", intStart) != -1) {
            intStart = s.indexOf(" ", intStart);
            h.put(new Integer(intStart), " ");
            intStart++;
        }

        intStart = 0;
        while (s.indexOf(":", intStart) != -1) {
            intStart = s.indexOf(":", intStart);
            h.put(new Integer(intStart), ":");
            intStart++;
        }

        intStart = 0;
        while (s.indexOf(".", intStart) != -1) {
            intStart = s.indexOf(".", intStart);
            h.put(new Integer(intStart), ".");
            intStart++;
        }

        if (s.indexOf("年") != -1)
            h.put(new Integer(s.indexOf("年")), "年");
        if (s.indexOf("月") != -1)
            h.put(new Integer(s.indexOf("月")), "月");
        if (s.indexOf("日") != -1)
            h.put(new Integer(s.indexOf("日")), "日");
        if (s.indexOf("时") != -1)
            h.put(new Integer(s.indexOf("时")), "时");
        if (s.indexOf("分") != -1)
            h.put(new Integer(s.indexOf("分")), "分");
        if (s.indexOf("秒") != -1)
            h.put(new Integer(s.indexOf("秒")), "秒");

        int i = 0;
        while (h.size() != 0) {
            Enumeration e = h.keys();
            int n = 0;
            while (e.hasMoreElements()) {
                i = ((Integer) e.nextElement()).intValue();
                if (i >= n)
                    n = i;
            }
            String temp = (String) h.get(new Integer(n));
            h.remove(new Integer(n));

            javaFormat = temp + javaFormat;
        }
        SimpleDateFormat df = new SimpleDateFormat(javaFormat, new DateFormatSymbols());

        return df.format(d);
    }

    /**
     * 将指定格式的字符串转换为日期型
     *
     * @param strDate      -日期
     * @param oracleFormat --oracle型日期格式
     * @return 转换得到的日期
     */
    public static Date stringToDate(String strDate, String oracleFormat) {
        // SimpleDateFormat df=new SimpleDateFormat(javaFormat,new
        // DateFormatSymbols());
        // SimpleDateFormat df = new SimpleDateFormat(javaFormat);
        if (strDate == null || "".equals(strDate))
            return null;
        Hashtable h = new Hashtable();
        String javaFormat = new String();
        String s = oracleFormat.toLowerCase();
        if (s.indexOf("yyyy") != -1)
            h.put(new Integer(s.indexOf("yyyy")), "yyyy");
        else if (s.indexOf("yy") != -1)
            h.put(new Integer(s.indexOf("yy")), "yy");
        if (s.indexOf("mm") != -1)
            h.put(new Integer(s.indexOf("mm")), "MM");

        if (s.indexOf("dd") != -1)
            h.put(new Integer(s.indexOf("dd")), "dd");
        if (s.indexOf("hh24") != -1)
            h.put(new Integer(s.indexOf("hh24")), "HH");
        if (s.indexOf("mi") != -1)
            h.put(new Integer(s.indexOf("mi")), "mm");
        if (s.indexOf("ss") != -1)
            h.put(new Integer(s.indexOf("ss")), "ss");

        int intStart = 0;
        while (s.indexOf("-", intStart) != -1) {
            intStart = s.indexOf("-", intStart);
            h.put(new Integer(intStart), "-");
            intStart++;
        }

        intStart = 0;
        while (s.indexOf("/", intStart) != -1) {
            intStart = s.indexOf("/", intStart);
            h.put(new Integer(intStart), "/");
            intStart++;
        }

        intStart = 0;
        while (s.indexOf(" ", intStart) != -1) {
            intStart = s.indexOf(" ", intStart);
            h.put(new Integer(intStart), " ");
            intStart++;
        }

        intStart = 0;
        while (s.indexOf(":", intStart) != -1) {
            intStart = s.indexOf(":", intStart);
            h.put(new Integer(intStart), ":");
            intStart++;
        }

        if (s.indexOf("年") != -1)
            h.put(new Integer(s.indexOf("年")), "年");
        if (s.indexOf("月") != -1)
            h.put(new Integer(s.indexOf("月")), "月");
        if (s.indexOf("日") != -1)
            h.put(new Integer(s.indexOf("日")), "日");
        if (s.indexOf("时") != -1)
            h.put(new Integer(s.indexOf("时")), "时");
        if (s.indexOf("分") != -1)
            h.put(new Integer(s.indexOf("分")), "分");
        if (s.indexOf("秒") != -1)
            h.put(new Integer(s.indexOf("秒")), "秒");

        int i = 0;
        while (h.size() != 0) {
            Enumeration e = h.keys();
            int n = 0;
            while (e.hasMoreElements()) {
                i = ((Integer) e.nextElement()).intValue();
                if (i >= n)
                    n = i;
            }
            String temp = (String) h.get(new Integer(n));
            h.remove(new Integer(n));

            javaFormat = temp + javaFormat;
        }
        // logger.info(javaFormat);
        SimpleDateFormat df = new SimpleDateFormat(javaFormat);

        Date myDate;
        try {
            myDate = df.parse(strDate);
        } catch (Exception e) {
            return null;
        }

        return myDate;
    }

    // 需要注意的是：月份是从0开始的，比如说如果输入5的话，实际上显示的是4月份的最后一天，千万不要搞错了哦
    public static String getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
        return new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
    }

    public static String getFirstDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
        return new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
    }

    public static String getLastDayOfMonth(String strDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate;
        Calendar cal = Calendar.getInstance();
        try {
            newDate = format.parse(strDate);
            cal.setTime(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
        return format.format(cal.getTime());
    }

    public static String getFirstDayOfMonth(String strDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate;
        Calendar cal = Calendar.getInstance();
        try {
            newDate = format.parse(strDate);
            cal.setTime(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
        return format.format(cal.getTime());
    }

    /**
     * 将字符串类型时间串（YYYY-MM-DD）转成Calendar类型
     *
     * @param dateStr
     * @return
     */
    public static Calendar getYMDFormatCalendar(String dateStr) {
        Calendar result = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        result.setTime(date);

        return result;
    }

    /**
     * 将日期型数据转换成 YYYY年MM月DD日 E HH24时MI分 格式的字符串
     *
     * @param d java.util.Date
     * @return 格式化后的字符串
     */
    public static String getYMDEHMFormatDate(String d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
        return sdf.format(stringToDate(d, DATE_FORMAT_YMDHMS));
    }

    /**
     * 将日期型数据转换成 MM月DD日 E HH12时MI分 格式的字符串
     *
     * @param YYYY-MM-DD HH24:MI d
     * @return 格式化后的字符串
     */
    public static String getStartTime(String d) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分");
        String dateStr = sd.format(stringToDate(d, DATE_FORMAT_YMDHMS));

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
        Date date = null;
        try {
            date = sdf.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        GregorianCalendar ca = new GregorianCalendar();
        ca.setTime(date);
        String ampm = "下午";
        if (ca.get(GregorianCalendar.AM_PM) == 0) {
            ampm = "上午";
        }

        return dateStr.substring(5, 12) + "" + ampm + dateStr.substring(12, 18);
    }

    /**
     * 将日期型数据转换成 YYYY年MM月DD日 E HH24时MI分 格式的字符串
     *
     * @param d java.util.Date
     * @return 格式化后的字符串
     */
    public static String getYMDEHMFormatDate(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
        return sdf.format(d);
    }

    public static String getMDAHMMFormatDate(String d) {
        SimpleDateFormat sdf = new SimpleDateFormat("M月d号  HH:mm", Locale.CHINESE);
        return sdf.format(stringToDate(d, DATE_FORMAT_YMDHMS));
    }

    // 日期格式转换成时间戳
    public static long getTimeStamp(String strDate, String pattern) {
        long returnTimeStamp = 0;
        Date aDate = null;
        try {
            aDate = stringToDate(strDate, pattern);
        } catch (Exception pe) {
            aDate = null;
        }
        if (aDate == null) {
            returnTimeStamp = 0;
        } else {
            returnTimeStamp = aDate.getTime();
        }
        return returnTimeStamp;
    }

    // 返回毫秒数
    public static long getTimeInMillis(String orgTime) {
        Calendar c = Calendar.getInstance();
        int year = Integer.valueOf(orgTime.substring(0, 4));
        int month = Integer.valueOf(orgTime.substring(5, 7)) - 1;
        int day = Integer.valueOf(orgTime.substring(8, 10));
        int hour = Integer.valueOf(orgTime.substring(11, 13));
        int minute = Integer.valueOf(orgTime.substring(14, 16));
        int second = Integer.valueOf(orgTime.substring(17, 19));
        c.set(year, month, day, hour, minute, second);

        return c.getTimeInMillis();
    }

    // 距离日期d已经过去多少天
    public static int daysFromDate(String d) throws Exception {
        Date date = new Date();
        long a = date.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long b = sdf.parse(d).getTime();
        int success = (int) ((a - b) / (1000 * 60 * 60 * 24) + 1); // 1000毫秒*60分钟*60秒*24小时
        // = 天
        // logger.info("距离"+d+"已经过去"+success+"天");
        return success;
    }

    /**
     * 判断2个时间相差多少天、多少小时、多少分<br>
     * <br>
     *
     * @param pBeginTime 请假开始时间<br>
     * @param pEndTime   请假结束时间<br>
     * @return String 计算结果<br>
     * @Exception 发生异常<br>
     */
    public static String TimeDiff(String pBeginTime, String pEndTime) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Long beginL = format.parse(pBeginTime).getTime();
        Long endL = format.parse(pEndTime).getTime();
        Long day = (endL - beginL) / 86400000;
        Long hour = ((endL - beginL) % 86400000) / 3600000;
        Long min = ((endL - beginL) % 86400000 % 3600000) / 60000;
        logger.info("实际请假" + day + "小时" + hour + "分钟" + min);
        logger.info(day + "天");
        logger.info(hour + "小时");
        logger.info(min + "分钟");
        return ("实际请假" + day + "小时" + hour + "分钟" + min);
    }

    /**
     * 判断2个时间多少小时<br>
     * <br>
     *
     * @param pBeginTime 请假开始时间<br>
     * @param pEndTime   请假结束时间<br>
     * @return String 计算结果<br>
     * @Exception 发生异常<br>
     */
    public static long TimeDiffHours(String pBeginTime, String pEndTime) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Long beginL = format.parse(pBeginTime).getTime();
        Long endL = format.parse(pEndTime).getTime();
        Long hour = (endL - beginL) / 3600000;
        logger.info(hour + "小时");
        return hour;
    }

    /**
     * 取得天数差
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     */
    public static int daysBetween(String smdate, String bdate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        long between_days = 0;
        try {
            cal.setTime(sdf.parse(smdate));
            long time1 = cal.getTimeInMillis();
            cal.setTime(sdf.parse(bdate));
            long time2 = cal.getTimeInMillis();
            between_days = (time2 - time1) / (1000 * 3600 * 24);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
            // log.error("String转换Long错误，请确认数据可以转换！between_days：" +
            // between_days);
        }
        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 适用于（年-月）格式的比较取得天数差 ： yyyy-MM (MM是大写)
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     */
    public static int daysBetweenYYYYMM(String smdate, String bdate, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        long between_days = 0;
        try {
            cal.setTime(sdf.parse(smdate));
            long time1 = cal.getTimeInMillis();
            cal.setTime(sdf.parse(bdate));
            long time2 = cal.getTimeInMillis();
            between_days = (time2 - time1) / (1000 * 3600 * 24);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
            // log.error("String转换Long错误，请确认数据可以转换！between_days：" +
            // between_days);
        }
        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 时间之间的 计算毫秒数 pEndTime-pBeginTime
     *
     * @param pBeginTime
     * @param pEndTime
     * @return
     */
    public static long TimeDiffSecond(String pBeginTime, String pEndTime) {
        long cha = 0;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            Long beginL = format.parse(pBeginTime).getTime();
            Long endL = format.parse(pEndTime).getTime();
            cha = endL - beginL;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return cha;
    }

    /**
     * 计算某个时间到当前时间相差的天数
     *
     * @param time
     * @return
     */
    public static long timeDiffCurrentTimeOfDay(Object time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long timeMs = 0l;
        long currentTimeMs = 0l;
        try {
            if (time instanceof java.util.Date) {
                timeMs = sdf.parse(sdf.format((java.util.Date) time)).getTime();
            }
            if (time instanceof java.sql.Date) {
                timeMs = sdf.parse(sdf.format((java.sql.Date) time)).getTime();
            }
            if (time instanceof java.lang.String) {
                timeMs = sdf.parse((String) time).getTime();
            }
            Date currentDate = new Date();
            currentTimeMs = sdf.parse(sdf.format(currentDate)).getTime();
            long VIPDays = Math.abs(currentTimeMs - timeMs) / (1000 * 60 * 60 * 24);
            return VIPDays;
        } catch (ParseException e) {
            throw new RuntimeException("计算某个时间到当前时间相差的天数时，日期格式错误", e);
        }
    }

    /**
     * 判断时间格式 格式必须为“YYYY-MM-dd” 2004-2-30 是无效的 2003-2-29 是无效的
     *
     * @param sDate
     * @return
     */
    public static boolean isValidDate(String str) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = (Date) formatter.parse(str);
            return str.equals(formatter.format(date));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 功能：时间+72小时 应用：债权转让期
     *
     * @param dateHMS yyyy-MM-dd HH:mm:ss
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String addDatebyHours(String dateHMS) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        Long curren = null;
        try {
            curren = dateFormat.parse(dateHMS).getTime();

        } catch (ParseException e) {
            try {
                curren = dateFormat2.parse(dateHMS).getTime();
                logger.info("==========addDatebyHours方法========时间格式不是默认的  yyyy-MM-dd HH:mm:ss ================");
            } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }
        curren += 72 * 60 * 60 * 1000;
        String newDate = dateFormat.format(new Date(curren));
        return newDate;

        /*
         * // 当前系统时间+72小时：方式1 long curren = System.currentTimeMillis(); curren
         * += 72 * 60 * 60 * 1000; Date da = new Date(curren);
         * logger.info(dateFormat.format(da));
         *
         * // 当前系统时间+72小时：方式2 Calendar now=Calendar.getInstance();
         * now.add(Calendar.HOUR,24); String
         * dateStr=dateFormat.format(now.getTimeInMillis());
         * logger.info(dateStr);
         */

    }


    /**
     * 计算当前时间加N个月的时间
     *
     * @param time
     * @return
     */
    public static String addMonths(int months) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, months);
        return sdf.format(cal.getTime());
    }

    /**
     * @param beginCalendar
     * @param endCalendar
     * @return
     * @description 计算两个日期之间相差的天数
     */
    public static int getDayDiff(Calendar beginCalendar, Calendar endCalendar) {
        beginCalendar.set(Calendar.AM_PM, 0);
        beginCalendar.set(Calendar.HOUR_OF_DAY, 0);
        beginCalendar.set(Calendar.HOUR, 0);
        beginCalendar.set(Calendar.MINUTE, 0);
        beginCalendar.set(Calendar.SECOND, 0);
        beginCalendar.set(Calendar.MILLISECOND, 0);

        endCalendar.set(Calendar.AM_PM, 0);
        endCalendar.set(Calendar.HOUR_OF_DAY, 0);
        endCalendar.set(Calendar.HOUR, 0);
        endCalendar.set(Calendar.MINUTE, 0);
        endCalendar.set(Calendar.SECOND, 0);
        endCalendar.set(Calendar.MILLISECOND, 0);
        long beginTime = beginCalendar.getTimeInMillis();
        long endTime = endCalendar.getTimeInMillis();
        long differentDate = (endTime - beginTime) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(differentDate));
    }

    /**
     * 指定日期加上天数后的日期
     *
     * @param num     为增加的天数
     * @param newDate 创建时间
     * @return
     * @throws ParseException
     */
    public static String plusDay(int num, String newDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date currdate = format.parse(newDate);
        System.out.println("现在的日期是：" + currdate);
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
        currdate = ca.getTime();
        String enddate = format.format(currdate);
        System.out.println("增加天数以后的日期：" + enddate);
        return enddate;
    }


    // 使用当前月份,得到上一个月的月份:月份的格式是:yyyy-MM
    public static String getLastDate(String currentDate) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(currentDate + "-" + "01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -1);

        String lastDate = c.get(Calendar.YEAR) + "-"
                + (c.get(Calendar.MONTH) + 1);

        return lastDate;

    }

    //返回上个月的第一天
    public static String getFirstYMD() {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        //获取上个月的第一天
        Calendar cal_1 = Calendar.getInstance();//获取当前日期
        cal_1.add(Calendar.MONTH, -1);
        cal_1.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        String firstDay = format.format(cal_1.getTime());

        return firstDay;
    }

    //返回上个月的最后一天
    public static String getLastYMD() {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        //获取上个月的最后一天
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 0);//设置为1号,当前日期既为本月第一天
        String lastDay = format.format(cale.getTime());
        return lastDay;
    }

    /**
     * 将日期型数据转换成 YYYYMMDD 格式的字符串
     *
     * @param d java.util.Date
     * @return 格式化后的字符串
     */
    public static String getStringYMDFormatDate(String d) {
        String[] strings = d.split("-");
        return (strings[0] + strings[1] + strings[2].trim());
    }

    public static String thisBeforDay() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String mDateTime = formatter.format(c.getTime());
        String strStart = mDateTime.substring(0, 10);// 2007-10-29 09:30
        return strStart;
    }


    /**
     * 获取当月的第一天
     */
    public static String getMonthStartDate(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM");
        Date date = null;
        try {
            date = format2.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("获取当月第一天日期异常");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return format.format(c.getTime());
    }

    /**
     * 获取当月的最后一天
     */
    public static String getMonthEndDate(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM");
        Date date = null;
        try {
            date = format2.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("获取当月最后一天日期异常");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, 0);

        return format.format(c.getTime());
    }


    /**
     * 获取当年的第一天
     */
    public static String getYearStartDate(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM");
        Date date = null;
        try {
            date = format2.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("获取当年第一天日期异常");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return format.format(c.getTime());
    }

    /**
     * @Title: differenceTime @Description: TODO(时间差，精确到天) @param firstDate
     * 开始时间 @param secondDate 结束时间 @return @return int 返回类型 @create_time
     * 2015-3-17 下午2:26:06 @throws
     */
    public static int differenceTime(Date beginDate, Date endDate) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        try {
            calendar.setTime(beginDate);
            calendar2.setTime(endDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long dateLen = (calendar2.getTimeInMillis() - calendar.getTimeInMillis()) / (24 * 60 * 60 * 1000);// 获取相减值的绝对值
        return (int) dateLen;
    }

    /**
     * @Description: (时间差 ， 精确到天)
     */
    public static int differenceTime(Calendar beginCalendar, Calendar endCalendar) {
        long beginTime = beginCalendar.getTimeInMillis();
        long endTime = endCalendar.getTimeInMillis();
        long differentDate = (endTime - beginTime) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(differentDate));
    }

    /**
     * @param c1
     * @return
     * @description 日期格式化
     * @version 1.0
     */
    public static String getCalendarFormat(Calendar c1) {
        Date date = new Date(c1.getTimeInMillis());
        return DateHelper.getYMDFormatDate(date);
    }


    /**
     * @param c1
     * @param c2
     * @return
     * @description 计算两个日期之间相差的月份
     */
    public static int getMonthDiff(Calendar c1, Calendar c2) {
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        if (year1 > year2) {
            return (year1 - year2) * 12 + month1 - month2;
        } else if (year2 > year1) {
            return (year2 - year1) * 12 + month2 - month1;
        } else {
            return Math.abs(month2 - month1);
        }

    }

    /**
     * @param srcDate
     * @param date
     * @return
     * @description 给定的日期加上天数
     */
    public static Calendar addDateCalendar(Calendar srcDate, int date) {
        Calendar result = Calendar.getInstance();
        result.set(Calendar.YEAR, srcDate.get(Calendar.YEAR));
        result.set(Calendar.MONTH, srcDate.get(Calendar.MONTH));
        result.set(Calendar.DATE, srcDate.get(Calendar.DATE) + date);
        return result;
    }


    public static void main(String[] args) throws Exception {
        int remaindDays = DateHelper.daysBetween(DateHelper.getYMDFormatDate(new Date()), "2025-01-27 ");
        logger.info(remaindDays + "===================");

        /*
         * TimeDiff("2016-05-27 10:10","2016-05-29 12:30");
         * TimeDiffHours("2016-07-18 09:55:00","2016-07-18 10:00:00");
         * TimeDiff("2016-07-18 10:00:00","2016-07-18 09:55:00");
         * daysBetween("2016-07-18 01:00:00","2016-07-18 09:55:00");
         * logger.info(TimeDiffSecond("2016-07-18 10:10:05"
         * ,"2016-07-18 10:01:10"));
         */
        // Calendar curr = Calendar.getInstance();
        Calendar curr = DateHelper.getYMDFormatCalendar("2016-10-30");
        curr.set(Calendar.DAY_OF_MONTH, curr.get(Calendar.DAY_OF_MONTH) + 3);
        String currTime = DateHelper.getYMDFormatDate(curr.getTime());
        logger.info("----------------------" + currTime + "" + DateHelper.isValidDate("2018-10-32"));
        logger.info(daysBetween(currTime, DateHelper.getYMDFormatDate(new Date())));

        Calendar ca = getYMDFormatCalendar("2016-08-14");
        logger.info(ca.get(Calendar.MONTH) + 1);

        //// ==========================
        String dateStr = DateHelper.addDatebyHours("2016-11-32");
        logger.info(dateStr);

        int num = DateHelper.daysBetweenYYYYMM("2016-11-32", "2016-12-32", "yyyy-MM");
        logger.info(num);

        String days = plusDay(3, DateHelper.getYMDFormatDate(new Date()));
        System.out.println("days=====" + days);

        String mobile = "18800000001";
        System.out.println(mobile.substring(mobile.length() - 4, mobile.length()));
        String firstDate = DateHelper.getFirstYMD();
        System.out.println("firstDate上个月的最后一天" + firstDate);


    }
}
