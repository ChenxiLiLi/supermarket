package com.tengke.supermarket.controller;

import com.tengke.supermarket.dto.ResultDTO;
import com.tengke.supermarket.model.Goods;
import com.tengke.supermarket.model.SellItem;
import com.tengke.supermarket.model.SellRecord;
import com.tengke.supermarket.service.GoodsService;
import com.tengke.supermarket.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @author cgs
 * @date 2020年7月27日11:34:08
 * 销售处理模块
 */
@RestController
@RequestMapping("/sell")
public class SellController {
    @Autowired
    private SellService sellService;
    @Autowired
    private GoodsService goodsService;

    /**
     * 分页展示商品，供员工选取销售项
     * @param pageNo 页码
     * @param size 页面大小
     * @return 商品信息
     */
    @GetMapping("/goods/{pageNo}/{size}")
    public ResultDTO showGoods(@PathVariable("pageNo") int pageNo, @PathVariable("size") int size) {
        return goodsService.showGoodsList(pageNo,size);
    }

    /**
     * 按商品编号搜索商品
     * @param gdsId 商品编号
     * @return 商品信息
     */
    @GetMapping("/goods/search/{id}")
    public ResultDTO searchGoods(@PathVariable("id") int gdsId) {
        return goodsService.searchGoodsById(gdsId);
    }

    /**
     * 提交订单（销售记录）
     * @param sellItem 销售项集合
     * @param sfId 员工编号
     * @return 提示消息
     */
    @PostMapping(value = "/addOrder/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO addOrder(@RequestBody SellItem[] sellItem, @PathVariable("id") int sfId) {
        return sellService.sell(sellItem, sfId);
    }

    /**
     * 分页查询销售记录
     * @param pageNo 页码
     * @param size 页面大小
     * @return 销售记录列表
     */
    @GetMapping("/record/{pageNo}/{size}")
    public ResultDTO getSellRecords(@PathVariable("pageNo") int pageNo, @PathVariable("size") int size) {
        return sellService.showSellRecordList(pageNo, size);
    }

    /**
     * 按照销售编号查询销售项
     * @param sellId 销售编号
     * @return 销售项列表
     */
    @GetMapping("/recordItem/{id}")
    public ResultDTO getRecordItem(@PathVariable("id") int sellId) {
        return sellService.showSellItem(sellId);
    }
}
