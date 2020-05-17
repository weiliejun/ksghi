package com.itech.core.excel.domain;

import com.itech.core.util.StringHelper;
import com.itech.ups.app.product.application.domain.ProductFuturesData;
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

public class OtherFileExcel {
    // 获取map字段映射集合
    public static Map<Object, String> getMap(Class cla) throws Exception {
        Method me = cla.getMethod("getMp", null);
        Map<Object, String> mp = (Map<Object, String>) me.invoke(cla, null);
        return mp;
    }

    public static void main(String[] args) throws Exception {
        OtherFileExcel rf = new OtherFileExcel();
        // s = rf.readEXCEL("d:/02.xls");
        ProductFuturesData data = new ProductFuturesData();
        String filepath = "D:\\document\\财富360\\1005_20150519.xlsx";
        String type = filepath.substring(filepath.indexOf(".xls") + 1, filepath.length());
        InputStream is = new FileInputStream(filepath);
        List<Object> dt = rf.readEXCEL2007(is, data.getClass());
        for (int i = 0; i < dt.size(); i++) {
            ProductFuturesData d = (ProductFuturesData) dt.get(i);
        }

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
                    // formater.format(cell.getNumericCellValue())
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
        Map<String, Integer[]> resultmp = new HashMap<String, Integer[]>();
        try {
            Object data = cla.newInstance();
            Map<Object, String> mp = getMap(cla);
            List<Object> returndata = new ArrayList<Object>();// 返回结果
            HSSFWorkbook workbook = new HSSFWorkbook(is);
            Map<Short, Field> objmp = new HashMap<Short, Field>();// 存放实体map
            // for (int numSheets = 0; numSheets < workbook.getNumberOfSheets();
            // numSheets++){
            int numSheets = 0;// 只截取第一个sheet中的内容
            if (null != workbook.getSheetAt(numSheets)) {
                HSSFSheet aSheet = workbook.getSheetAt(numSheets);// 获得一个sheet
                // 处理子集
                for (int rowNumOfSheet = 0; rowNumOfSheet <= aSheet.getLastRowNum(); rowNumOfSheet++) {
                    if (null != aSheet.getRow(rowNumOfSheet)) {
                        HSSFRow aRow = aSheet.getRow(rowNumOfSheet); // 获得一个行
                        for (short cellNumOfRow = 0; cellNumOfRow <= aRow.getLastCellNum(); cellNumOfRow++) {
                            if (null != aRow.getCell(cellNumOfRow)) {
                                HSSFCell aCell = aRow.getCell(cellNumOfRow);// 获得列值
                                // System.out.println(cellNumOfRow+"=="+rowNumOfSheet);
                                String value = this.convertCell((Cell) aCell);
                                // 处理列
                                Iterator<Object> it = mp.keySet().iterator();
                                while (it.hasNext()) {
                                    Object keystr = it.next();
                                    if (value.equals(keystr)) {
                                        resultmp.put(value + "=" + mp.get(value), new Integer[]{rowNumOfSheet, Integer.valueOf(cellNumOfRow)});
                                    }
                                }
                                // mp.put(value, new
                                // Object[rowNumOfSheet][cellNumOfRow]);
                            }
                        }
                    }
                }
                return shaixuan(null, aSheet, resultmp, cla);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // 读取xlsx文件
    public List<Object> readEXCEL2007(InputStream is, Class cla) throws Exception {
        // 获取实际对象
        Map<String, Integer[]> resultmp = new HashMap<String, Integer[]>();
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
                        for (short cellNumOfRow = 0; cellNumOfRow <= aRow.getLastCellNum(); cellNumOfRow++) {
                            if (null != aRow.getCell(cellNumOfRow)) {
                                XSSFCell aCell = aRow.getCell(cellNumOfRow);// 获得列值
                                // System.out.println(cellNumOfRow+"=="+rowNumOfSheet);
                                String value = this.convertCell(aCell);
                                // 处理列
                                Iterator<Object> it = mp.keySet().iterator();
                                while (it.hasNext()) {
                                    Object keystr = it.next();
                                    if (value.equals(keystr)) {
                                        resultmp.put(value + "=" + mp.get(value), new Integer[]{rowNumOfSheet, Integer.valueOf(cellNumOfRow)});
                                    }
                                }
                                // mp.put(value, new
                                // Object[rowNumOfSheet][cellNumOfRow]);
                            }
                        }
                    }
                }
                return shaixuan(aSheet, null, resultmp, cla);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // 处理结果集，返回字段名称和字段结果
    public List<Object> shaixuan(XSSFSheet aSheet, HSSFSheet hSheet, Map<String, Integer[]> oldmp, Class cla) throws Exception {
        List<Object> returndata = new ArrayList<Object>();// 返回结果
        // 获取实际对象
        Object data = cla.newInstance();
        Map<Object, Object> obj = new HashMap<Object, Object>();
        Iterator it = oldmp.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next().toString();
            Integer[] ovalue = oldmp.get(key);
            // Object uservalue =
            Cell aCell = null;
            if (aSheet != null) {
                aCell = aSheet.getRow(ovalue[0]).getCell(ovalue[1] + 2); // 从表格规律来看，第一例是标题，第二列是内容。因此
                // 这里取值行不变，列+2
            }
            if (hSheet != null) {
                aCell = (Cell) hSheet.getRow(ovalue[0]).getCell((short) (ovalue[1] + 2)); // 从表格规律来看，第一例是标题，第二列是内容。因此
                // 这里取值行不变，列+2
            }
            String value = convertCell(aCell);
            obj.put(key.split("=")[1], convertCell(aCell));

            Field field = cla.getDeclaredField(key.split("=")[1]);// 获取字段
            field.setAccessible(true);// 关键。。。可访问私有变量。
            Class type = field.getType();
            if (type == String.class) {
                field.set(data, value);// 重新赋值
            } else if (type == Integer.class) {
                field.setInt(data, StringHelper.isNotEmpty(value) ? Integer.parseInt(value) : null);// int型
            } else if (type == BigDecimal.class) {
                field.set(data, StringHelper.isNotEmpty(value) ? new BigDecimal(value) : null);// 重新赋值
            } else if (type == Boolean.class) {
                field.set(data, StringHelper.isNotEmpty(value) ? new Boolean(value) : null);// 布尔型
            } else if (type == Long.class) {
                field.set(data, StringHelper.isNotEmpty(value) ? new Long(value) : null);// lang型
            } else if (type == Float.class) {
                field.set(data, StringHelper.isNotEmpty(value) ? new Float(value) : null);// lang型
            } else {
                field.set(data, value);
            }
        }
        returndata.add(getnewData(data));
        return returndata;
    }
}
