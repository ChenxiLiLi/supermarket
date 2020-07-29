package com.tengke.supermarket.mapper;

import com.tengke.supermarket.model.SellItem;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cgs
 * @date 2020年7月26日23:04:38
 */
@Component
public interface SellItemMapper {
    /**
     * 批量增加销售项
     * @param items 销售项集合
     * @return 影响行数
     */
    int addItems(SellItem[] items);

    /**
     * 按销售编号查找所有销售项
     * @param sellId 销售编号
     * @return 所有销售项的列表
     */
    List<SellItem> selectAllItemsById(int sellId);



}
