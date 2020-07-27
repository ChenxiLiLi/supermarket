package com.tengke.supermarket.mapper;

import com.tengke.supermarket.model.SellRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SellRecordMapperTest {

    @Autowired
    private SellRecordMapper mapper;

    @Test
    void selectRecordsByPage() {
        Map<String,Integer> info = new HashMap<>();
        info.put("start",0);
        info.put("size",2);
        List<SellRecord> records = mapper.selectRecordsByPages(info);
        System.out.println(records);
    }

    @Test
    void addSellRecord() {
        SellRecord sellRecord = new SellRecord(null,1,new Date());
        mapper.addSellRecord(sellRecord);
    }
    @Test
    void selectLastRecord() {
        SellRecord sellRecord = mapper.selectLastRecord();
        System.out.println(sellRecord);
    }
}