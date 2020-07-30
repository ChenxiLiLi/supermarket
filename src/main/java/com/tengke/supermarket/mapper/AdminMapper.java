package com.tengke.supermarket.mapper;

import com.tengke.supermarket.model.Admin;
import org.springframework.stereotype.Component;

/**
 * @Author: Mr.Chen
 * @Description: 用户操作接口
 * @Date:Created in 17:32 2020/7/24
 */
@Component
public interface AdminMapper {

    /**
     * 根据用户名查找用户
     * @param name 用户名
     * @return Admin
     */
    Admin selectAdminByUsername(String name);

    /**
     * 添加新用户
     * @param admin 用户对象
     */
    void addUser(Admin admin);

    /**
     * 按token查找用户
     * @param token
     * @return
     */
    Admin selectAdminByToken(String token);

    int updateAdmin(Admin admin);
}
