package com.tengke.supermarket.dto;


import lombok.Data;
import java.util.List;


/**
 * @author cgs
 */
@Data
public class PageDTO<T> {

    /**
     * 数据记录集合
     */
    private List<T> data;
    /**
     * 总页码
     */
    Integer pagesNum;
    /**
     * 偏移量
     */
    private Integer recordsNum;

    private Integer start;

    private Integer pageSize;

    /**
     * @param pageSize
     * @param totalCount
     * @param pageNo
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
        //获取总页数
        pagesNum = totalCount % pageSize == 0 ? totalCount  / pageSize : totalCount / pageSize + 1;
        if(pageNo > pagesNum) {
            pageNo = pagesNum;
        }
        this.pageSize = pageSize;
        this.start = (pageNo-1) * pageSize;
    }

}


