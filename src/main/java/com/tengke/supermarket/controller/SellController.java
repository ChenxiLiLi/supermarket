package com.tengke.supermarket.controller;

import com.tengke.supermarket.model.SellItem;
import com.tengke.supermarket.model.SellRecord;
import com.tengke.supermarket.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author cgs
 */
@RestController
@RequestMapping("/sell")
public class SellController {
    @Autowired
    private SellService sellService;

    @GetMapping("/")

    @PostMapping("/addOrder/{id}/{sellItem}")
    public String addOrder(@PathVariable("sellItem") SellItem[] items, @PathVariable("id") int id) {
        return sellService.sell(items, id);
    }

    @GetMapping("/record/{pageNo}/{size}")
    public List<SellRecord> getSellRecords(@PathVariable("pageNo") int pageNo, @PathVariable("size") int size) {
        return sellService.showSellRecordList(pageNo, size);
    }

    @GetMapping("/recordItem/{id}")
    public List<SellItem> getRecordItem(@PathVariable("id") int sellId) {
        return sellService.showSellItem(sellId);
    }
}
