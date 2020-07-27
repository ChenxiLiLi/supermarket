package com.tengke.supermarket.service;

import com.tengke.supermarket.mapper.GoodsMapper;
import com.tengke.supermarket.model.Goods;
import com.tengke.supermarket.model.SellItem;
import com.tengke.supermarket.model.SellRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SellServiceTest {

    @Autowired
    private SellService service;
    @Autowired
    private GoodsMapper mapper;

    @Test
    void sell() {

        //展示购买前的销售记录
        List<SellRecord> oldRecords = service.showSellRecordList(1, 10);
        System.out.println("购买前的销售记录:");
        for (SellRecord oldRecord : oldRecords) {
            System.out.println(oldRecord);
        }

        //销售处理前的商品展示
        List<Goods> goods = mapper.selectAllGoods();
        System.out.println("销售处理前的商品展示");
        for (Goods good : goods) {
            System.out.println(good);
        }
        //新建销售项集合
        SellItem item1 = new SellItem(null, 2, 15.5f, 998);
        SellItem item2 = new SellItem(null, 3, 50.0f, 888);
        SellItem[] items = {item1,item2};

        //销售处理，打印销售信息
        String message = service.sell(items, 1);
        System.out.println(message);

        //销售处理后的商品展示
        goods = mapper.selectAllGoods();
        System.out.println("销售处理后的商品展示");
        for (Goods good : goods) {
            System.out.println(good);
        }

        //查看新的销售记录
        List<SellRecord> newRecords = service.showSellRecordList(1, 10);
        System.out.println("查看新的销售记录：");
        for (SellRecord newRecord : newRecords) {
            System.out.println(newRecord);
        }


    }

    @Test
    void showSellRecordList() {

        List<SellRecord> records = service.showSellRecordList(1, 4);
        System.out.println(records);
    }
}