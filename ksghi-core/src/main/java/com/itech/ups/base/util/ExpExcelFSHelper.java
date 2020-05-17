package com.itech.ups.base.util;

import jxl.format.Alignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableHyperlink;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *
 * 导出带子sheet的excel
 */
public final class ExpExcelFSHelper {

    /**
     * 导出带子sheet的excel
     *
     * @param pDescription 描述
     */
    @SuppressWarnings("unchecked")
    public static void expExcel(HttpServletRequest request, HttpServletResponse response, String excelName, String sheetName, String pDescription, String[] pTitle, List<Map<String, Object>> list, String[] cTitle) {

        String exportFileName = null;
        java.io.OutputStream os = null;
        jxl.write.WritableWorkbook wwb = null;
        try {
            // 导出时中文文件名为乱码的问题解决
            String encoding = request.getCharacterEncoding();
            exportFileName = new String((excelName + ".xls").getBytes("GBK"), "iso-8859-1");
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=GBK");
            response.setContentType("application/msexcel");// 设定输出类型
            response.setHeader("Content-Disposition", "attachment; filename=" + exportFileName);
            os = response.getOutputStream();

            wwb = jxl.Workbook.createWorkbook(os);// 创建可写工作薄
            jxl.write.WritableSheet ws = wwb.createSheet(sheetName, 0);// 创建可写工作表

            jxl.write.WritableFont wfHeader = new jxl.write.WritableFont(jxl.write.WritableFont.ARIAL, 11, jxl.write.WritableFont.BOLD, false);// 列标题
            jxl.write.WritableCellFormat wcfFHeader = new jxl.write.WritableCellFormat(wfHeader);
            wcfFHeader.setAlignment(Alignment.CENTRE);
            wcfFHeader.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);// 垂直居中
            jxl.write.WritableFont wfCell = new jxl.write.WritableFont(jxl.write.WritableFont.createFont("宋体"), 10, jxl.write.WritableFont.NO_BOLD, false);// 设置写入字体

            jxl.write.WritableCellFormat wcfL = new jxl.write.WritableCellFormat(wfCell);// 居左
            wcfL.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);// 垂直居中
            wcfL.setAlignment(Alignment.LEFT);// 水平居左
            wcfL.setWrap(true);
            jxl.write.WritableCellFormat wcfC = new jxl.write.WritableCellFormat(wfCell);// 居中
            wcfC.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
            wcfC.setAlignment(Alignment.CENTRE);
            wcfC.setWrap(true);
            jxl.write.WritableCellFormat wcfR = new jxl.write.WritableCellFormat(wfCell);// 居右
            wcfR.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
            wcfR.setAlignment(Alignment.RIGHT);
            wcfR.setWrap(true);

            int count = 0; // 行数
            int titleCount = pTitle.length;// title列数,没算序号列

            /**
             * 标题
             */
            if (pDescription != null && pDescription.length() > 0) {
                jxl.write.Label labelCF0 = null;
                ws.mergeCells(0, count, titleCount, 1);
                labelCF0 = new jxl.write.Label(0, count, pDescription, wcfL);
                ws.addCell(labelCF0);
                count += 2;
            }

            /**
             * 列标题
             */
            String[] keys = new String[titleCount];
            jxl.write.Label labelCF = new jxl.write.Label(0, count, "序号", wcfFHeader);
            ws.setColumnView(0, 8);
            ws.addCell(labelCF);
            Map<String, WritableCellFormat> cellFormatP = new HashMap<String, WritableCellFormat>();
            for (int i = 0; i < titleCount; i++) {
                String[] titleParams = pTitle[i].split(":");
                String name = titleParams[0];
                String key = titleParams[1];
                keys[i] = key;
                int cellSize = Integer.parseInt(titleParams[2]);
                String align = titleParams[3];

                ws.setColumnView(i + 1, cellSize);
                if (align.equals("left"))
                    cellFormatP.put(key, wcfL);
                if (align.equals("center"))
                    cellFormatP.put(key, wcfC);
                if (align.equals("right"))
                    cellFormatP.put(key, wcfR);
                ws.setColumnView(i + 1, cellSize);
                labelCF = new jxl.write.Label(i + 1, count, name, wcfFHeader);
                ws.addCell(labelCF);
            }
            count++;

            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    labelCF = new jxl.write.Label(0, count, (i + 1) + "", wcfC);// 序号
                    ws.addCell(labelCF);

                    Map<String, Object> map = list.get(i);
                    for (int j = 0; j < keys.length; j++) {// 主sheet
                        labelCF = new jxl.write.Label(j + 1, count, map.get(keys[j]) == null ? "" : map.get(keys[j]).toString(), cellFormatP.get(keys[j]));
                        ws.addCell(labelCF);
                    }

                    /**
                     * 子sheet
                     */
                    if (cTitle != null && cTitle.length > 0) {
                        String childName = map.get("childName").toString();
                        List<Map<String, Object>> childList = (List<Map<String, Object>>) map.get("childList");
                        String cDescription = map.get("cDescription").toString();
                        jxl.write.WritableSheet wsc = wwb.createSheet(childName, i + 1);

                        wsc.mergeCells(0, 0, cTitle.length - 1, 1);// 标题
                        jxl.write.Label labelCF0 = new jxl.write.Label(0, 0, cDescription, wcfL);
                        wsc.addCell(labelCF0);
                        Map<String, WritableCellFormat> cellFormatC = new HashMap<String, WritableCellFormat>();
                        String[] keyc = new String[cTitle.length];
                        for (int ci = 0; ci < cTitle.length; ci++) {
                            String[] titleParams = cTitle[ci].split(":");
                            String name = titleParams[0];
                            String key = titleParams[1];
                            keyc[ci] = key;
                            int cellSize = Integer.parseInt(titleParams[2]);
                            String align = titleParams[3];

                            if (align.equals("left"))
                                cellFormatC.put(key, wcfL);
                            if (align.equals("center"))
                                cellFormatC.put(key, wcfC);
                            if (align.equals("right"))
                                cellFormatC.put(key, wcfR);
                            wsc.setColumnView(ci, cellSize);
                            labelCF = new jxl.write.Label(ci, 2, name, wcfFHeader);
                            wsc.addCell(labelCF);
                        }
                        if (childList != null && childList.size() > 0) {
                            for (int k = 0; k < childList.size(); k++) {
                                Map<String, Object> child = childList.get(k);
                                for (int kc = 0; kc < keyc.length; kc++) {
                                    labelCF = new jxl.write.Label(kc, k + 3, child.get(keyc[kc]) == null ? "" : child.get(keyc[kc]).toString(), cellFormatC.get(keyc[kc]));
                                    wsc.addCell(labelCF);
                                }

                            }
                        }
                        if (map.get("linkCol") != null) {
                            int linkCol = Integer.parseInt(map.get("linkCol").toString());
                            WritableHyperlink hyperlink = new WritableHyperlink(linkCol, count, map.get("linkDes") == null ? (map.get(keys[linkCol - 1]) == null ? "" : map.get(keys[linkCol - 1]).toString()) : map.get("linkDes").toString(), wsc, 0, 0);
                            ws.addHyperlink(hyperlink);
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
