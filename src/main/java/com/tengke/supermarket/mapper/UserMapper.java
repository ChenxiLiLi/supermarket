package com.tengke.supermarket.mapper;

import com.tengke.supermarket.model.User;
import org.springframework.stereotype.Component;

/**
 * @Author: Mr.Chen
 * @Description: 用户操作接口
 * @Date:Created in 17:32 2020/7/24
 */
@Component
public interface UserMapper {

    /**
     * 根据用户名查找用户
     * @param username 用户名
     * @return User
     */
    User selectUserByUsername(String username);

    /**
     * 添加新用户
     * @param user 用户对象
     */
    void addUser(User user);
}
