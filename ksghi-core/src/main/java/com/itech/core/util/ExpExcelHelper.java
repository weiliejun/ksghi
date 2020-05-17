package com.itech.core.util;

import jxl.format.BorderLineStyle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.regex.Pattern;

/*
 * ===========================================================================
 * Copyright 2007 CHENGANG Corp. All Rights Reserved.
 * @version 1.0, ${date}
 * @author  Jack Chen
 * ===========================================================================
 *
 */
public final class ExpExcelHelper {

    /**
     * 导出Excel
     *
     * @param request
     * @param response
     * @param datas
     * @param heads
     * @param sheeTTitle
     * @param fileName
     */
    public static void expExcel(HttpServletRequest request, HttpServletResponse response, List datas, String[] heads, String reportTitle, String sheeTTitle, String fileName) {

        String exportFileName = fileName + ".xls";
        java.io.OutputStream os = null;
        jxl.write.WritableWorkbook wwb = null;
        try {
            // 导出时中文文件名为乱码的问题解决
            String encoding = request.getCharacterEncoding();
            exportFileName = new String(exportFileName.getBytes("GBK"), "iso-8859-1");
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=GBK");
            response.setContentType("application/msexcel");// 设定输出类型
            response.setHeader("Content-Disposition", "attachment; filename=" + exportFileName);
            List list = datas;
            // 输出流
            os = response.getOutputStream();
            // 创建可写工作薄
            wwb = jxl.Workbook.createWorkbook(os);
            // 创建可写工作表
            jxl.write.WritableSheet ws = wwb.createSheet(sheeTTitle, 0);
            ws.getSettings().setDefaultColumnWidth(18); // 设置列的默认宽度
            // ws.getSettings().setProtected(true); //设置只读
            // 设置写入字体

            jxl.write.WritableFont wf = new jxl.write.WritableFont(jxl.write.WritableFont.ARIAL, 11, jxl.write.WritableFont.NO_BOLD, false);
            // 设置CellFormat
            jxl.write.WritableCellFormat wcfF = new jxl.write.WritableCellFormat(wf);
            jxl.write.WritableFont wfHeader = new jxl.write.WritableFont(jxl.write.WritableFont.ARIAL, 11, jxl.write.WritableFont.NO_BOLD, false);
            // 设置CellFormat
            jxl.write.WritableCellFormat wcfFHeader = new jxl.write.WritableCellFormat(wfHeader);
            // 把水平对齐方式指定为左对齐
            wcfF.setAlignment(jxl.format.Alignment.LEFT);
            wcfF.setBorder(jxl.format.Border.ALL, BorderLineStyle.THIN, jxl.format.Colour.BLACK);// 设置边框
            wcfFHeader.setBorder(jxl.format.Border.ALL, BorderLineStyle.THIN, jxl.format.Colour.BLACK);// 设置边框

            // 把垂直对齐方式指定为居中对齐
            wcfF.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);

            // 开始循环表头
            int count = 0; // 行数
            int mergeCell = 0; // 列数
            // 开始写表标题
            if (reportTitle != null && reportTitle.length() > 0) {
                jxl.write.Label labelCF0 = null;
                mergeCell = mergeCell + heads.length;
                ws.mergeCells(0, count, mergeCell, 1);
                labelCF0 = new jxl.write.Label(0, count, reportTitle, wcfFHeader);
                ws.addCell(labelCF0);
                count += 2;
            }

            jxl.write.Label labelCF = new jxl.write.Label(0, count, "序号", wcfFHeader);
            ws.addCell(labelCF);
            for (int i = 0; i < heads.length; i++) {
                labelCF = new jxl.write.Label(i + 1, count, heads[i], wcfFHeader);
                ws.addCell(labelCF);
            }
            count++;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    Object[] obj = (Object[]) list.get(i);
                    if (obj != null) {
                        labelCF = new jxl.write.Label(0, count, (i + 1) + "", wcfF);
                        ws.addCell(labelCF);
                        for (int j = 0; j < obj.length; j++) {
                            String patternStr = "([0-9]+)";
                            if (obj[j] == null) {
                                obj[j] = "";
                            }
                            boolean result = Pattern.matches(patternStr, obj[j] + "");
                            if (result) {
                                if ((obj[j] + "").length() <= 15) {
                                    jxl.write.Number labelN = new jxl.write.Number(j + 1, count, Double.parseDouble(obj[j] + ""), wcfF);// 数字类型
                                    ws.addCell(labelN);
                                    // System.out.println("字符串"+obj[j].toString()+"匹配模式"+patternStr+"成功");
                                } else {
                                    labelCF = new jxl.write.Label(j + 1, count, obj[j] + "", wcfF);
                                    ws.addCell(labelCF);
                                }
                            } else {
                                if (obj[j] != null) {
                                    labelCF = new jxl.write.Label(j + 1, count, obj[j] + "", wcfF);
                                    ws.addCell(labelCF);
                                } else {
                                    jxl.write.Number labelN = new jxl.write.Number(j + 1, count, Double.parseDouble(obj[j] + ""), wcfF);// 数字类型
                                    ws.addCell(labelN);
                                }

                                // System.out.println("字符串"+obj[j].toString()+"匹配模式"+patternStr+"失败");
                            }

                        }
                    }
                    count++;
                }

            }
            try {
                wwb.write();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (wwb != null) {
                    wwb.close();
                }
                if (os != null) {
                    os.flush();
                    os.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
