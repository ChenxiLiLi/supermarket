package com.tengke.supermarket;

import com.tengke.supermarket.model.Admin;
import com.tengke.supermarket.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SupermarketApplicationTests {

    @Autowired
    private AdminService adminService;

    @Test
   public void testPurchaseMapper() {
        Admin admin = new Admin();
        admin.setAdminName("ceshi");
        admin.setAdminPassword("123456");
        adminService.login(admin);
   }
}
