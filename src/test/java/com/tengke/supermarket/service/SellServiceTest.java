package com.tengke.supermarket.service;

import com.tengke.supermarket.dto.ResultDTO;
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
        ResultDTO resultDTO = service.showSellRecordList(3, 6);
        List data = (List) resultDTO.getData();
        System.out.println("购买前的销售记录:");
        for (Object oldRecord : data) {
            System.out.println(oldRecord);
        }

        //销售处理前的商品展示
        List<Goods> goods = mapper.selectAllGoods();
        System.out.println("销售处理前的商品展示");
        for (Goods good : goods) {
            System.out.println(good);
        }
        //新建销售项集合
        SellItem item1 = new SellItem(null, 14, 4f, 100);
        SellItem item2 = new SellItem(null, 15, 4f, 200);
        SellItem[] items = {item1,item2};

        //销售处理，打印销售信息
        ResultDTO msg = service.sell(items, 1);
        System.out.println(msg.getMsg());

        //销售处理后的商品展示
        goods = mapper.selectAllGoods();
        System.out.println("销售处理后的商品展示");
        for (Goods good : goods) {
            System.out.println(good);
        }

        //查看新的销售记录
        ResultDTO resultDTO1 = service.showSellRecordList(1, 10);
        List<SellRecord> data1 = (List<SellRecord>) resultDTO1.getData();
        System.out.println("查看新的销售记录：");
        for (SellRecord newRecord : data1) {
            System.out.println(newRecord);
        }


    }

    @Test
    void showSellRecordList() {

        ResultDTO resultDTO = service.showSellRecordList(1, 4);
        System.out.println(resultDTO);
    }
}