package com.tengke.supermarket.service;

import com.tengke.supermarket.mapper.GoodsMapper;
import com.tengke.supermarket.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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
    public List<Goods> showGoodsList(int pageNo, int size) {
        Map<String, Integer> info = new HashMap<>(2);
        /*
            start：数据库表记录的开始下标，从0开始。
            对应公式：start = (pageNo-1)*size
            比如一页4条记录，当前页码为1，则开始记录下标为(1-1)*4=0，对应记录0 1 2 3
        */
        info.put("start",(pageNo-1)*size);
        info.put("size",size);
        return goodsMapper.selectGoodsByPage(info);

    }

    public Goods searchGoodsById(int id) {
        return goodsMapper.selectGoodsById(id);
    }

}
