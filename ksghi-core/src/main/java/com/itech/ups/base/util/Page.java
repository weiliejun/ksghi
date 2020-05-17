package com.itech.ups.base.util;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class Page {

    List<?> list = null;// 结果集
    private int totalPage;// 总页数
    private int totalRow;// 总行数
    private int currentPage = 1;// 当前页
    private int onePageCount = 10;// 每页行数
    private int rowStart;// 开始条数
    private int rowEnd;// 结束条数

    public Page() {
    }

    public Page(HttpServletRequest request, int totalRow) {
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        if (page != null && !page.isEmpty()) {
            this.currentPage = Integer.parseInt(page);
        }
        if (rows != null && !rows.isEmpty()) {
            this.onePageCount = Integer.parseInt(rows);
        }
        this.totalRow = totalRow;
        calculate();
    }

    public Page(String page, String rows, int totalRow) {
        if (page != null && !page.isEmpty()) {
            this.currentPage = Integer.parseInt(page);
        }
        if (rows != null && !rows.isEmpty()) {
            this.onePageCount = Integer.parseInt(rows);
        }
        this.totalRow = totalRow;
        calculate();
    }

    private void calculate() {
        totalPage = totalRow % onePageCount == 0 ? totalRow / onePageCount : (totalRow / onePageCount + 1);
        rowStart = (currentPage - 1) * onePageCount;
        rowEnd = rowStart + onePageCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public int getOnePageCount() {
        return onePageCount;
    }

    public void setOnePageCount(int onePageCount) {
        this.onePageCount = onePageCount;
    }

    public int getRowEnd() {
        return rowEnd;
    }

    public void setRowEnd(int rowEnd) {
        this.rowEnd = rowEnd;
    }

    public int getRowStart() {
        return rowStart;
    }

    public void setRowStart(int rowStart) {
        this.rowStart = rowStart;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

}
