package com.itech.core.components.pager;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * ===========================================================================
 * Copyright 2007 CHENGANG Corp. All Rights Reserved.
 * @version 1.0, ${date}
 * @author  Jack Chen
 * ===========================================================================
 * 分页对象. 包含当前页数据及分页信息.
 */

public class PagerInfo implements Serializable {

    private static int DEFAULT_PAGE_SIZE = 10;

    /**
     * 每页的记录数
     */
    private int pageSize = DEFAULT_PAGE_SIZE;

    /**
     * 当前页第一条数据在List中的位置,从0开始
     */
    private int startNum;

    /**
     * 当前页中存放的记录,类型一般为List
     */
    private List<?> data;

    /**
     * 总记录数
     */
    private int totalCount = 0;

    public PagerInfo(HttpServletRequest request, int pageSize) {
        String vstart = request.getParameter("pager.offset");
        if (vstart != null && !vstart.equals("")) {
            try {
                this.startNum = new Integer(vstart);
            } catch (Exception e) {
                this.startNum = 0;
            }
        }
        this.pageSize = pageSize;
        this.data = new ArrayList();
    }

    public PagerInfo(int pageNum, int pageSize) {
        int vstart = (pageNum - 1) * pageSize;
        if (vstart >= 0) {
            try {
                this.startNum = vstart;
            } catch (Exception e) {
                this.startNum = 0;
            }
        }
        this.pageSize = pageSize;
        this.data = new ArrayList();
    }

    /**
     * 当前页末条数据在List中的位置
     */
    public int getEndNum() {
        if (this.startNum + pageSize > totalCount)
            return totalCount;
        else
            return this.startNum + pageSize;
    }

    /**
     * 取总页数
     */
    public int getTotalPageCount() {
        if (totalCount % pageSize == 0)
            return totalCount / pageSize;
        else
            return totalCount / pageSize + 1;
    }

    /**
     * 取当前页码,页码从1开始
     */
    public int getCurrentPageNo() {
        return startNum / pageSize + 1;
    }

    /**
     * 是否有下一页
     */
    public boolean hasNextPage() {
        return this.getCurrentPageNo() < this.getTotalPageCount() - 1;
    }

    /**
     * 是否有上一页
     */
    public boolean hasPreviousPage() {
        return this.getCurrentPageNo() > 1;
    }

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
