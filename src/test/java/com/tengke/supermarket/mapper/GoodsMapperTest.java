package com.tengke.supermarket.mapper;

import com.tengke.supermarket.model.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GoodsMapperTest {

    @Autowired
    private GoodsMapper mapper;
    @Test
    void selectGoodsByPage() {
        HashMap<String, Integer> info = new HashMap<>(2);
        info.put("start",0);
        info.put("size",10);
        List<Goods> goods = mapper.selectGoodsByPage(info);
        System.out.println(goods);
    }
}