package com.tengke.supermarket.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author cgs
 */

@Data
public class PageDTO<T> {
    //分页查询的结果
    private List<T> list;
    //分页总数
    private Integer pagesNum;
    //记录总数
    private Integer recordsNum;

    //首记录地址
    private Integer start;
    //页面大小
    private Integer pageSize;

    /**
     *
     * @param pageSize 页面大小
     * @param totalCount 记录总数
     * @param pageNo 页面编号
     */
    public PageDTO(int pageSize, int totalCount, int pageNo) {
        recordsNum = totalCount;
        //合法性判断
        if(pageNo <= 0) {
            pageNo = 1;
        }
        if(pageSize <= 0) {
            pageSize = 7;
        }
        //页数的计算
        pagesNum = totalCount % pageSize == 0 ? totalCount  / pageSize : totalCount / pageSize + 1;
        //如果页码超出总页数，则页码等于最后一页
        if(pageNo > pagesNum) {
            pageNo = pagesNum;
        }
        this.pageSize = pageSize;
        this.start = (pageNo-1) * pageSize;
    }
}
