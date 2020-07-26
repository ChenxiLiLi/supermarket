package com.tengke.supermarket.mapper;

import com.tengke.supermarket.model.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    /**
     * 查询所有商品
     * @return 商品列表
     */
    List<Goods> selectAllGoods();

    /**
     * 增加商品信息
     * @param goods 需要增加的商品信息
     * @return 行数
     */
    int addGoods(Goods goods);

    /**
     * 修改商品信息
     * @param goods 要修改的商品新信息
     * @return 行数
     */
    int updateGoods(Goods goods);

    /**
     * 删除商品信息
     * @param gdsId 商品编号
     * @return 行数
     */
    int deleteGoods(int gdsId);
}
