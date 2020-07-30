package com.tengke.supermarket.controller;

import com.tengke.supermarket.dto.ResultDTO;
import com.tengke.supermarket.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cgs
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/{pageNo}/{size}")
    public ResultDTO findGoodsLess(@PathVariable("pageNo") int pageNo, @PathVariable("size") int size) {
        return goodsService.showGoodsLess(pageNo,size);
    }

    @GetMapping("/search/{id}")
    public ResultDTO searchGoodsById(@PathVariable("id") int id) {
        return goodsService.searchGoodsById(id);
    }
}
