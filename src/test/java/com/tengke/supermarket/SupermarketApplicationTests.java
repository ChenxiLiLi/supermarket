package com.tengke.supermarket;

import com.tengke.supermarket.dto.ResultDTO;
import com.tengke.supermarket.mapper.AdminMapper;
import com.tengke.supermarket.model.Admin;
import com.tengke.supermarket.service.UserService;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SupermarketApplicationTests {

    @Autowired
    private UserService userService;
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
        ResultDTO resultDTO = userService.login(admin);
        System.out.println(resultDTO.toString());
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

    //
    @Autowired
    StringEncryptor encryptor;
    @Test
    public void getEncryptor() {
        //
       /* String url = encryptor.encrypt("jdbc:mysql://39.107.236.198:3306/supermarket?useUnicode=true&characterEncoding=UTF-8");
        String name = encryptor.encrypt("chenxi");
        String password = encryptor.encrypt("chenxi");
        System.out.println(url);
        System.out.println(name);
        System.out.println(password);*/
    }
}
