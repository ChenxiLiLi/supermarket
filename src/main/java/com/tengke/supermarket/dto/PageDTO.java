package com.tengke.supermarket.dto;

import lombok.Data;
import java.util.List;


/**
 * @author cgs
 */

@Data
public class PageDTO<T> {
    //分页查询的结果
    private List<T> data;
    //总页数
    Integer pagesNum;
    //记录总数
    private Integer recordsNum;

    private Integer start;

    private Integer pageSize;

    public PageDTO(int pageSize, int totalCount, int pageNo) {
        recordsNum = totalCount;
        //合法性判断
        if(pageNo <= 0) {
            pageNo = 1;
        }
        if(pageSize <= 0) {
            pageSize = 7;
        }
        //获取总页数
        pagesNum = totalCount % pageSize == 0 ? totalCount  / pageSize : totalCount / pageSize + 1;
        //判断当前页码是否在合法范围内
        if(pageNo > pagesNum) {
            pageNo = pagesNum;
        }
        this.pageSize = pageSize;
        this.start = (pageNo-1) * pageSize;
    }
}