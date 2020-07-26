package com.tengke.supermarket.service;

import com.tengke.supermarket.dto.LoginDTO;
import com.tengke.supermarket.dto.ResultDTO;
import com.tengke.supermarket.mapper.AdminMapper;
import com.tengke.supermarket.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Author: Mr.Chen
 * @Description: 用户Service层
 * @Date:Created in 17:22 2020/7/24
 */
@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;
    /**
     * 加密编码器
     */
    static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    /**
     * 用户登录
     * @param admin ""
     * @return ""
     */
    public ResultDTO login(Admin admin) {
        //用户名是唯一的，所以通过用户名查找，可以锁定用户
        Admin dbAdmin = adminMapper.selectAdminByUsername(admin.getAdminName());
        //存在用户，进行密码验证
        if (dbAdmin != null) {
            if (bCryptPasswordEncoder.matches(admin.getAdminPassword(), dbAdmin.getAdminPassword())) {
                //登录成功，给前端提供数据，用来展示
                //设置token
                LoginDTO loginDTO = new LoginDTO();
                loginDTO.setToken(UUID.randomUUID().toString());
                loginDTO.setUsername(admin.getAdminName());
                return ResultDTO.success("登录成功", loginDTO);
            }
        }
        return ResultDTO.error("用户名或密码错误,请输入重试");
    }

    /**
     * 添加用户
     * @param admin "用户对象"
     * @return ""
     */
    public ResultDTO addUser(Admin admin) {
        //用户是否存在
        Admin dbAdmin = adminMapper.selectAdminByUsername(admin.getAdminName());
        if (dbAdmin == null) {
            String dbPassword = bCryptPasswordEncoder.encode(admin.getAdminPassword());
            admin.setAdminPassword(dbPassword);
            adminMapper.addUser(admin);
            return ResultDTO.success("用户添加成功");
        }
        return ResultDTO.error("用户已存在");
    }

}
