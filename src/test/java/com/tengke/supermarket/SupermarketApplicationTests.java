package com.tengke.supermarket;

import com.tengke.supermarket.dto.SupplierDTO;
import com.tengke.supermarket.mapper.SupplierMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SupermarketApplicationTests {

    @Autowired
    private SupplierMapper supplierMapper;

    @Test
    public void testPurchaseMapper() {
        List<SupplierDTO> supplierDTO = supplierMapper.getSupplierIdName();
        for (SupplierDTO s: supplierDTO
        ) {
            System.out.println(s);
        }
    }

}
