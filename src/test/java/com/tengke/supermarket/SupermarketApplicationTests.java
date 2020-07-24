package com.tengke.supermarket;

import com.tengke.supermarket.dto.ResultDTO;
import com.tengke.supermarket.model.User;
import com.tengke.supermarket.service.UserService;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SupermarketApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("ceshi");
        user.setPassword("123456");
        ResultDTO resultDTO = userService.login(user);
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

    //自动加载加密类
    @Autowired
    StringEncryptor encryptor;
    @Test
    public void getEncryptor() {
        //对敏感信息进行加密
       /* String url = encryptor.encrypt("jdbc:mysql://39.107.236.198:3306/supermarket?useUnicode=true&characterEncoding=UTF-8");
        String name = encryptor.encrypt("chenxi");
        String password = encryptor.encrypt("chenxi");
        System.out.println(url);
        System.out.println(name);
        System.out.println(password);*/
    }
}
