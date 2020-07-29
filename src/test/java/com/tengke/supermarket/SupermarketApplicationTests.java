package com.tengke.supermarket;

import com.tengke.supermarket.dto.PageDTO;
import com.tengke.supermarket.mapper.GoodsMapper;
import com.tengke.supermarket.mapper.PurchaseMapper;
import com.tengke.supermarket.mapper.StaffMapper;
import com.tengke.supermarket.model.PurchaseRecord;
import com.tengke.supermarket.service.PurchaseService;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
class SupermarketApplicationTests {

    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private PurchaseMapper purchaseMapper;

    @Test
    public void testPurchaseMapper() {

    }
   /* @Test
    public void testGoodsMapper() {
        List<Integer> list = goodsMapper.selectIdByName();
        System.out.println(list);
        System.out.println(list.size());
    }*/

    @Test
    public void testStaff(){
        PurchaseRecord purchaseRecord = new PurchaseRecord(1, 2, null, 1, (float) 13.5, 100);
        String res = purchaseService.purchase(purchaseRecord);
        System.out.println(res);
    }


}
