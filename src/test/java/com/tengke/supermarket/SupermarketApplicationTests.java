package com.tengke.supermarket;

import com.tengke.supermarket.mapper.StaffMapper;
import com.tengke.supermarket.model.PurchaseRecord;
import com.tengke.supermarket.service.PurchaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class SupermarketApplicationTests {

    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private StaffMapper staffMapper;

    @Test
    public void testStaff(){
        PurchaseRecord purchaseRecord = new PurchaseRecord(1, 2, null, 1, (float) 13.5, 100);
        String res = purchaseService.purchase(purchaseRecord);
        System.out.println(res);
    }
}
