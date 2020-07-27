package com.tengke.supermarket.mapper;

import com.tengke.supermarket.model.SellItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SellItemMapperTest {
    @Autowired
    private SellItemMapper mapper;

    @Test
    void addItems() {
        SellItem item1 = new SellItem(1,1,20.3f,3);
        SellItem item2 = new SellItem(1,3,50.0f,1);
        SellItem item3 = new SellItem(1,4,100.4f,1);
        SellItem[] items = {item1,item2,item3};
        int row = mapper.addItems(items);
        System.out.println(row);

    }

    @Test
    void selectAllItemsById() {
        List<SellItem> items = mapper.selectAllItemsById(1);
        System.out.println(items);
    }

}