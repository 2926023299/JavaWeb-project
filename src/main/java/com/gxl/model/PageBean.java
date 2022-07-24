package com.gxl.model;

import java.util.List;

public class PageBean<T> {
    private List<T> list; // 当前页的数据
    private int pageSize; // 每页显示的记录数
    private int currentPage; // 当前页
    private int totalPage; //总页数
    private int totalCount; //总条数

    @Override
    public String toString() {
        return "PageBean{" +
                "list=" + list +
                ", pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                '}';
    }

    public PageBean(List<T> list, int pageSize, int currentPage, int totalCount) {
        this.list = list;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalCount = totalCount;

        this.totalPage = (int) Math.ceil(totalCount * 1.0 / pageSize);
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {

        return (int) Math.ceil(totalCount * 1.0 / pageSize);
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
