package com.tengke.supermarket;

import com.tengke.supermarket.dto.ResultDTO;
import com.tengke.supermarket.mapper.AdminMapper;
import com.tengke.supermarket.model.Admin;
import com.tengke.supermarket.service.AdminService;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SupermarketApplicationTests {

    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void testFindAdmin() {
        Admin ceshi = adminMapper.selectAdminByUsername("ceshi");
        System.out.println(ceshi);
    }
    @Test
    void contextLoads() {
        Admin admin = new Admin();
        admin.setAdminName("ceshi");
        admin.setAdminPassword("123456");
        ResultDTO resultDTO1 = adminService.login(admin);
        System.out.println(resultDTO1.toString());
    }

    @Test
    void testBcrypt() {
        String str = "admin";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pass = bCryptPasswordEncoder.encode(str);
        System.out.println(pass);
        boolean res = bCryptPasswordEncoder.matches("admin", pass);
        System.out.println(res);
    }

}
