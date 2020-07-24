package com.tengke.supermarket.service;

import com.tengke.supermarket.dto.ResultDTO;
import com.tengke.supermarket.mapper.UserMapper;
import com.tengke.supermarket.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author: Mr.Chen
 * @Description: 用户Service层
 * @Date:Created in 17:22 2020/7/24
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 加密编码器
     */
    static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    /**
     * 用户登录
     * @param user ""
     * @return ""
     */
    public ResultDTO login(User user) {
        //用户名是唯一的，所以通过用户名查找，可以锁定用户
        User dbUser = userMapper.selectUserByUsername(user.getUsername());
        //存在用户，进行密码验证
        if (dbUser != null) {
            if (bCryptPasswordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
                //登录成功，给前端提供用户名，用来展示
                return ResultDTO.success("登录成功", user.getUsername());
            }
        }
        return ResultDTO.error("用户名或密码错误,请输入重试");
    }

    /**
     * 添加用户
     * @param user "用户对象"
     * @return ""
     */
    public ResultDTO addUser(User user) {
        //用户是否存在
        User dbUser = userMapper.selectUserByUsername(user.getUsername());
        if (dbUser == null) {
            String dbPassword = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(dbPassword);
            userMapper.addUser(user);
            return ResultDTO.success("用户添加成功");
        }
        return ResultDTO.error("用户已存在");
    }

}
