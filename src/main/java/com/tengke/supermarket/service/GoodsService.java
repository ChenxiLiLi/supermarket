package com.tengke.supermarket.service;

import com.tengke.supermarket.dto.PageDTO;
import com.tengke.supermarket.dto.ResultDTO;
import com.tengke.supermarket.mapper.GoodsMapper;
import com.tengke.supermarket.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import java.util.Map;

/**
 * @author cgs
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 分页展示商品信息
     * @param pageNo 页码
     * @param size 页面大小
     * @return 商品信息列表
     */
    public ResultDTO showGoodsList(int pageNo, int size) {
        int totalCount = goodsMapper.countGoods();
        PageDTO<Goods> pageDTO = new PageDTO<>(size,totalCount,pageNo);

        Map<String, Integer> info = new HashMap<>(2);
        info.put("start",pageDTO.getStart());
        info.put("size",pageDTO.getPageSize());

        pageDTO.setData(goodsMapper.selectGoodsByPage(info));

        return ResultDTO.success("查询成功", pageDTO);

    }

    /**
     * 通过商品编号查找商品
     * @param id 商品编号
     * @return 返回商品以及信息
     */
    public ResultDTO searchGoodsById(int id) {
        Goods goods = goodsMapper.selectGoodsById(id);
        if(goods != null) {
            return ResultDTO.success("success",goods);
        }

        return ResultDTO.success("未找到该商品");
    }

}
