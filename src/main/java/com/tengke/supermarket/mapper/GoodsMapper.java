package com.tengke.supermarket.mapper;

import com.tengke.supermarket.model.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: cgs
 * @Description： 商品操作接口
 * @Date:Created in 17:17 2020/7/26
 */
@Repository
public interface GoodsMapper {
    /**
     * 查询所有商品
     * @return 商品信息列表
     */
    List<Goods> selectAllGoods();

    /**
     * 分页查询商品信息
     * @param info 存放起始记录下标和页面大小
     * @return 商品信息列表
     */
    List<Goods> selectGoodsByPage(Map<String,Integer> info);

    /**
     * 根据商品编号查找商品信息
     * @param gdsId 商品编号
     * @return 商品信息
     */
    Goods selectGoodsById(int gdsId);

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
