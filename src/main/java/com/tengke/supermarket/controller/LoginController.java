package com.tengke.supermarket.controller;

import com.tengke.supermarket.dto.ResultDTO;
import com.tengke.supermarket.model.Admin;
import com.tengke.supermarket.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Mr.Chen
 * @Description:
 * @Date:Created in 17:17 2020/7/24
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResultDTO login(@RequestBody Admin admin) {
        System.out.println(admin.toString());
        return adminService.login(admin);
    }
}
