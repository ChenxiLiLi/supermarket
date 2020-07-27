package com.tengke.supermarket.mapper;

import com.tengke.supermarket.model.SellRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author cgs
 * @date 2020年7月26日23:45:07
 */
@Repository
public interface SellRecordMapper {
    /**
     * 分页查询销售记录
     * @param info 存放起始记录下标以及分页大小
     * @return 销售记录列表
     */
    List<SellRecord> selectRecordsByPages(Map<String,Integer> info);

    /**
     * 查询最后一条销售记录
     * @return 销售记录
     */
    SellRecord selectLastRecord();

    /**
     * 计算销售记录总条数
     * @return 总条数
     */
    int countRecords();


    /**
     * 增加一条销售记录
     * @param record 销售记录
     * @return 影响行数
     */
    int addSellRecord(SellRecord record);
}
