package com.tengke.supermarket.mapper;

import com.tengke.supermarket.model.PurchaseRecord;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 彤老板
 */

@Component
public interface PurchaseMapper {
    /**
     * 增加一条进货记录
     * @param purchaseRecord 进货信息
     * @return
     */
    int addPurRecord(PurchaseRecord purchaseRecord);

    /**
     * 通过进货编号查找所有进货记录
     * @param purchaseId 进货编号
     * @return 进货记录列表
     */

    List<PurchaseRecord> selectPurRecordById(int purchaseId);


    /**
     * 分页查询商品编号在list集合中的所有进货记录
     * @param start 偏移量
     * @param pageSize 页面大小
     * @param list 商品编号集合
     * @return 记录集合
     */
    List<PurchaseRecord> selectPurRecordByPage(Integer start, Integer pageSize, List<Integer> list);

    /**
     * 通过商品名字分页查询进货记录
     * @param start 偏移量
     * @param pageSize 页面大小
     * @param name 商品名字
     * @return
     */
    List<PurchaseRecord> selectPurRecordByGoodsName(Integer start, Integer pageSize, String name);

    /**
     * 查询商品编号集合的记录总条数
     * @param list 商品编号集合
     * @return 条数
     */
    int getCount(List<Integer> list);
}
