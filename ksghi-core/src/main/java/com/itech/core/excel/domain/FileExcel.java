package com.itech.core.excel.domain;

import com.itech.core.util.StringHelper;
import com.itech.ups.app.product.application.domain.ProductSharesData;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileExcel {
    // 获取map字段映射集合
    public static Map<Object, String> getMap(Class cla) throws Exception {
        Method me = cla.getMethod("getMp", null);
        Map<Object, String> mp = (Map<Object, String>) me.invoke(cla, null);
        return mp;
    }

    public static void main(String[] args) throws Exception {
        FileExcel rf = new FileExcel();
        // s = rf.readEXCEL("d:/02.xls");
        ProductSharesData data = new ProductSharesData();
        String filepath = "D://原始数据（股票）_2015-06-18.xls";
        String type = filepath.substring(filepath.indexOf(".xls") + 1, filepath.length());
        InputStream is = new FileInputStream(filepath);
        // System.out.println(data.getClass().newInstance());
        // productData data2 = new productData();
        List<Object> dt = rf.readEXCEL2003(is, data.getClass());
        // List<productDynamicData> dt2 =
        // rf.readEXCEL2007("D:/document/产品动态数据_2015-04-03 -
        // 副本.xlsx",data2.getClass());
        for (int i = 0; i < dt.size(); i++) {
            ProductSharesData d = (ProductSharesData) dt.get(i);
            // System.out.println(d.getProductId()+"sadf=="+i);
        }
        // for(int i=0;i<dt2.size();i++){
        // System.out.println(dt.get(i).getProductId()+"==asdf"+i);
        // }
        // productDynamicData data = new productDynamicData();
        // getMap(data.getClass());
    }

    private String convertCell(Cell cell) {
        try {
            NumberFormat formater = NumberFormat.getInstance();
            // setMaximumFractionDigits(int) 设置数值的小数部分允许的最大位数。
            // setMinimumFractionDigits(int) 设置数值的小数部分允许的最小位数。
            formater.setMaximumFractionDigits(4);
            formater.setMinimumFractionDigits(0);
            DecimalFormat df = new DecimalFormat("#.00");
            df.setRoundingMode(RoundingMode.HALF_DOWN);// 不用四舍五入
            formater.setGroupingUsed(false);
            String cellValue = "";
            if (cell == null) {
                return cellValue;
            }
            // 日期格式转换
            if (0 == cell.getCellType() && HSSFDateUtil.isCellDateFormatted((HSSFCell) cell)) {
                Date d = cell.getDateCellValue();
                DateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
                cell.setCellValue(dformat.format(d));
            }
            switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_NUMERIC:
                    if (HSSFDateUtil.isCellDateFormatted((HSSFCell) cell)) {// 处理日期格式、时间格式
                        SimpleDateFormat sdf = null;
                        if (cell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("h:mm")) {
                            sdf = new SimpleDateFormat("HH:mm");
                        } else {// 日期
                            sdf = new SimpleDateFormat("yyyy-MM-dd");
                        }
                        Date date = cell.getDateCellValue();
                        cellValue = sdf.format(date);
                    } else if (cell.getCellStyle().getDataFormat() == 58 || cell.getCellStyle().getDataFormat() == 31) {// yyyy年m月d日----->31
                        // m月d日---->58
                        // h时mm分--->32
                        // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        double value = cell.getNumericCellValue();
                        Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
                        cellValue = sdf.format(date);
                    } else {
                        cellValue = formater.format(cell.getNumericCellValue());
                    }
                    break;
                case HSSFCell.CELL_TYPE_STRING:
                    cellValue = cell.getStringCellValue();
                    break;
                case HSSFCell.CELL_TYPE_FORMULA:// 公式
                    cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                    cellValue = cell.getNumericCellValue() + "";
                    break;
                case HSSFCell.CELL_TYPE_BLANK:
                    cellValue = cell.getStringCellValue();
                    break;
                case HSSFCell.CELL_TYPE_BOOLEAN:
                    cellValue = Boolean.valueOf(cell.getBooleanCellValue()).toString();
                    break;
                case HSSFCell.CELL_TYPE_ERROR:
                    cellValue = String.valueOf(cell.getErrorCellValue());
                    break;
                default:
                    cellValue = "";
            }
            return cellValue.trim();
        } catch (Exception ex) {

            ex.printStackTrace();
            return null;
        }
    }

    // 重新创建实体,防止productDynamicData存的对象永远是一个
    public Object getnewData(Object data) throws Exception {
        Object dt = data.getClass().newInstance();
        // productDynamicData dt = new productDynamicData();
        BeanUtils.copyProperties(data, dt);
        return dt;
    }

    // 读取xls文件
    @SuppressWarnings("deprecation")
    public String readEXCEL(InputStream is) throws IOException {
        StringBuilder content = new StringBuilder();
        HSSFWorkbook workbook = new HSSFWorkbook(is);// 创建对Excel工作簿文件的引用
        for (int numSheets = 0; numSheets < workbook.getNumberOfSheets(); numSheets++) {
            if (null != workbook.getSheetAt(numSheets)) {
                HSSFSheet aSheet = workbook.getSheetAt(numSheets);// 获得一个sheet
                for (int rowNumOfSheet = 0; rowNumOfSheet <= aSheet.getLastRowNum(); rowNumOfSheet++) {
                    if (null != aSheet.getRow(rowNumOfSheet)) {
                        HSSFRow aRow = aSheet.getRow(rowNumOfSheet); // 获得一个行
                        for (short cellNumOfRow = 0; cellNumOfRow <= aRow.getLastCellNum(); cellNumOfRow++) {
                            if (null != aRow.getCell(cellNumOfRow)) {
                                HSSFCell aCell = aRow.getCell(cellNumOfRow);// 获得列值
                                if (this.convertCell((Cell) aCell).length() > 0) {
                                    content.append(this.convertCell((Cell) aCell));
                                }
                            }
                            content.append("\n");
                        }
                    }
                }
            }
        }
        return content.toString();
    }

    // 读取xls文件
    @SuppressWarnings("deprecation")
    public List<Object> readEXCEL2003(InputStream is, Class cla) throws Exception {
        // 获取实际对象
        Object data = cla.newInstance();
        Map<Object, String> mp = getMap(cla);
        List<Object> returndata = new ArrayList<Object>();// 返回结果
        StringBuilder content = new StringBuilder();
        HSSFWorkbook workbook = new HSSFWorkbook(is);// 创建对Excel工作簿文件的引用
        Map<Short, Field> objmp = new HashMap<Short, Field>();// 存放实体map
        // for (int numSheets = 0; numSheets < workbook.getNumberOfSheets();
        // numSheets++){
        int numSheets = 0;// 只截取第一个sheet中的内容
        if (null != workbook.getSheetAt(numSheets)) {
            HSSFSheet aSheet = workbook.getSheetAt(numSheets);// 获得一个sheet
            // 处理子集
            // System.out.println(aSheet.getLastRowNum()-1+"=="+aSheet);
            for (int rowNumOfSheet = 0; rowNumOfSheet <= aSheet.getLastRowNum(); rowNumOfSheet++) {
                if (null != aSheet.getRow(rowNumOfSheet)) {
                    HSSFRow aRow = aSheet.getRow(rowNumOfSheet); // 获得一个行
                    if (aRow.getCell((short) 0) == null || aRow.getCell((short) 0).toString().equals("")) {
                        // 如果第一列是null则代表此行无效,跳出循环
                        continue;
                    }
                    for (short cellNumOfRow = 0; cellNumOfRow <= aRow.getLastCellNum(); cellNumOfRow++) {
                        if (null != aRow.getCell(cellNumOfRow)) {
                            HSSFCell aCell = aRow.getCell(cellNumOfRow);// 获得列值
                            String value = this.convertCell((Cell) aCell);
                            // 处理第一行
                            if (rowNumOfSheet == 0 && !"".equals(value)) {
                                // 开始处理
                                // 通过反射回去字段并放入值
                                String key = mp.get(value);
                                Field field = cla.getDeclaredField(key);
                                objmp.put(cellNumOfRow, field);
                            } else if (!"".equals(value)) {
                                Field fd = objmp.get(cellNumOfRow);
                                fd.setAccessible(true);// 关键。。。可访问私有变量。
                                if (value != null) {
                                    Class type = fd.getType();
                                    if (type == String.class) {
                                        fd.set(data, value);// 重新赋值
                                    } else if (type == Integer.class) {
                                        fd.setInt(data, StringHelper.isNotEmpty(value) ? Integer.parseInt(value) : null);// int型
                                    } else if (type == BigDecimal.class) {
                                        fd.set(data, StringHelper.isNotEmpty(value) ? new BigDecimal(value) : null);// 重新赋值
                                    } else if (type == Boolean.class) {
                                        fd.set(data, StringHelper.isNotEmpty(value) ? new Boolean(value) : null);// 布尔型
                                    } else if (type == Long.class) {
                                        fd.set(data, StringHelper.isNotEmpty(value) ? new Long(value) : null);// lang型
                                    } else if (type == Float.class) {
                                        fd.set(data, StringHelper.isNotEmpty(value) ? new Float(value) : null);// lang型
                                    } else {
                                        fd.set(data, value);
                                    }

                                }
                            }
                        }
                    }
                    // 第一行标题行不存
                    if (rowNumOfSheet != 0) {
                        returndata.add(getnewData(data));
                    }
                }
                // }
            }
        }
        return returndata;
    }

    // 读取xlsx文件
    public List<Object> readEXCEL2007(InputStream is, Class cla) throws Exception {
        // 获取实际对象
        try {
            Object data = cla.newInstance();
            Map<Object, String> mp = getMap(cla);
            List<Object> returndata = new ArrayList<Object>();// 返回结果
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            Map<Short, Field> objmp = new HashMap<Short, Field>();// 存放实体map
            // for (int numSheets = 0; numSheets < workbook.getNumberOfSheets();
            // numSheets++){
            int numSheets = 0;// 只截取第一个sheet中的内容
            if (null != workbook.getSheetAt(numSheets)) {
                XSSFSheet aSheet = workbook.getSheetAt(numSheets);// 获得一个sheet
                // 处理子集
                for (int rowNumOfSheet = 0; rowNumOfSheet <= aSheet.getLastRowNum(); rowNumOfSheet++) {
                    if (null != aSheet.getRow(rowNumOfSheet)) {
                        XSSFRow aRow = aSheet.getRow(rowNumOfSheet); // 获得一个行
                        if (aRow.getCell(0) == null || aRow.getCell(0).toString().equals("")) {
                            // 如果第一列是null则代表此行无效,跳出循环
                            continue;
                        }
                        for (short cellNumOfRow = 0; cellNumOfRow <= aRow.getLastCellNum(); cellNumOfRow++) {
                            if (null != aRow.getCell(cellNumOfRow)) {
                                XSSFCell aCell = aRow.getCell(cellNumOfRow);// 获得列值
                                // System.out.println(cellNumOfRow+"=="+rowNumOfSheet);
                                String value = this.convertCell(aCell);
                                // 处理第一行
                                if (rowNumOfSheet == 0) {
                                    // 开始处理
                                    // 通过反射回去字段并放入值
                                    String key = mp.get(value);
                                    if (cla.getDeclaredField(key) == null)
                                        continue;
                                    Field field = cla.getDeclaredField(key);
                                    // field.setAccessible(true);//关键。。。可访问私有变量。
                                    objmp.put(cellNumOfRow, field);
                                } else {
                                    Field fd = objmp.get(cellNumOfRow);
                                    fd.setAccessible(true);// 关键。。。可访问私有变量。
                                    if (value != null) {
                                        Class type = fd.getType();
                                        if (type == String.class) {
                                            fd.set(data, value);// 重新赋值
                                        } else if (type == Integer.class) {
                                            fd.setInt(data, StringHelper.isNotEmpty(value) ? Integer.parseInt(value) : null);// int型
                                        } else if (type == BigDecimal.class) {
                                            fd.set(data, StringHelper.isNotEmpty(value) ? new BigDecimal(value) : null);// 重新赋值
                                        } else if (type == Boolean.class) {
                                            fd.set(data, StringHelper.isNotEmpty(value) ? new Boolean(value) : null);// 布尔型
                                        } else if (type == Long.class) {
                                            fd.set(data, StringHelper.isNotEmpty(value) ? new Long(value) : null);// lang型
                                        } else if (type == Float.class) {
                                            fd.set(data, StringHelper.isNotEmpty(value) ? new Float(value) : null);// lang型
                                        } else {
                                            fd.set(data, value);
                                        }

                                    }
                                }
                            }
                        }
                        // 第一行标题行不存
                        if (rowNumOfSheet != 0) {
                            returndata.add(getnewData(data));
                        }
                        // }
                    }
                }
            }
            return returndata;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
