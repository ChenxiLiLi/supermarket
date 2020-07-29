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
     * 分页查询商品信息,并且不显示停产商品
     * @param info 存放起始记录下标和页面大小
     * @return 商品信息列表
     */
    List<Goods> selectGoodsByPage(Map<String,Integer> info);

    /**
     * 分页查询库存告急的商品信息
     * @param start 偏移量
     * @param size 页大小
     * @return 商品列表
     */
    List<Goods> selectGoodsLessByPage(int start, int size);

    /**
     * 查询库存不足的商品记录条数
     * @return
     */
    int countGoodsLess();

    /**
     * 查询商品信息总数
     * @return 总数
     */
    int countGoods();

    /**
     * 根据商品编号查找商品信息
     * @param gdsId 商品编号
     * @return 商品信息
     */
    Goods selectGoodsById(int gdsId);

    /**
     * 通过商品名字查找商品编号
     * @param name 商品名称
     * @return 商品编号
     */
    List<Integer> selectIdByName(String name);

    /**
     * 增加商品信息
     * @param goods 需要增加的商品信息
     * @return 行数
     */
    int addGoods(Goods goods);

    /**
     * 修改商品信息
     * @param goods 要修改的商品新信息
     * @return
     */
    int updateGoods(Goods goods);

    /**
     * 删除商品信息
     * @param gdsId 商品编号
     * @return 行数
     */
    int deleteGoods(int gdsId);

    /**
     * 通过商品编号查找商品名字
     * @param gdsId 商品编号
     * @return 商品名称
     */
    String selectNameById(int gdsId);
}
