package com.team.hospital.util;

//分页工具
public class PageParmeter {
      private Integer page=1; //页码
      private Integer pageSize=4; //页大小

    public Integer getPage() {
        return page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
