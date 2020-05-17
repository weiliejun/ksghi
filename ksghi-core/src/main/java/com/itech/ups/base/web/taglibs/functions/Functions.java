package com.itech.ups.base.web.taglibs.functions;

import com.itech.core.util.DateHelper;
import com.itech.core.util.ThousandsHelper;

import java.util.regex.Pattern;

public class Functions {

    public static String substringWithEllipsis(String input, int beginIndex, int endIndex) {
        if (input == null)
            input = "";
        if (beginIndex >= input.length())
            return "";
        if (beginIndex < 0)
            beginIndex = 0;
        if (endIndex < 0 || endIndex > input.length())
            endIndex = input.length();
        if (endIndex < beginIndex)
            return "";
        if (input.length() > endIndex)
            return input.substring(beginIndex, endIndex) + "...";
        return input.substring(beginIndex, endIndex);
    }

    public static String substringWithEllipsisAndRemoveHtml(String input, int beginIndex, int endIndex) {
        if (input == null)
            input = "";
        input = html2Text(input);
        if (beginIndex >= input.length())
            return "";
        if (beginIndex < 0)
            beginIndex = 0;
        if (endIndex < 0 || endIndex > input.length())
            endIndex = input.length();
        if (endIndex < beginIndex)
            return "";
        if (input.length() > endIndex)
            return input.substring(beginIndex, endIndex) + "...";
        return input.substring(beginIndex, endIndex);
    }

    public static String html2Text(String inputString) {
        String htmlStr = inputString; // 含html标签的字符串
        String textStr = "";
        java.util.regex.Pattern p_script;
        java.util.regex.Matcher m_script;
        java.util.regex.Pattern p_style;
        java.util.regex.Matcher m_style;
        java.util.regex.Pattern p_html;
        java.util.regex.Matcher m_html;

        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
            // }
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
            // }
            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); // 过滤script标签

            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); // 过滤style标签

            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤html标签

            textStr = htmlStr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textStr;// 返回文本字符串
    }

    public static String formateThousands(Object input, boolean addZero) {
        return ThousandsHelper.formateThousands(input, addZero);
    }

    public static String getMDAHMMFormatDate(String input) {
        return DateHelper.getMDAHMMFormatDate(input);
    }

    /**
     * 得到百分数 忽略掉小数点后数字
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String getPercent(Double num1, Double num2) {
        return (num1 / num2 * 100 + "").split("\\.")[0];
    }
}
