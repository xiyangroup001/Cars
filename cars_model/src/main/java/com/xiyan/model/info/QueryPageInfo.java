package com.xiyan.model.info;

import java.io.Serializable;

/**
 * @antuor binwang
 * @date 2018/2/5  11:32
 */
public class QueryPageInfo implements Serializable {

    protected int pageIndex;

    protected int pageSize;

    protected int totalCount = 0;
    protected int startIndex = -1;

    public QueryPageInfo() {
    }

    public QueryPageInfo(int pageIndex, int pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public void checkQueryPageInfo() {
        if (this.pageIndex <= 0) {
            throw new IllegalArgumentException("分页页码(" + this.pageIndex + ")必须大于0！");
        } else if (this.pageSize <= 0) {
            throw new IllegalArgumentException("每页显示数量(" + this.pageSize + ")必须大于0！");
        } else {
            this.startIndex = (this.pageIndex - 1) * this.pageSize;
            if (this.startIndex < 0) {
                this.startIndex = 1;
            }

        }
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}

