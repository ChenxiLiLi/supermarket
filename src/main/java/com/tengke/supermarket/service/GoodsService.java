package com.tengke.supermarket.service;

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
        if(pageNo <= 0 || size <= 0) {
            return ResultDTO.success("请输入合法的页码以及页面大小");
        }
        Map<String, Integer> info = new HashMap<>(2);
        /*
            start：数据库表记录的开始下标，从0开始。
            对应公式：start = (pageNo-1)*size
            比如一页4条记录，当前页码为1，则开始记录下标为(1-1)*4=0，对应记录0 1 2 3
        */
        info.put("start",(pageNo-1)*size);
        info.put("size",size);
        return ResultDTO.success("查询成功",goodsMapper.selectGoodsByPage(info));

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
