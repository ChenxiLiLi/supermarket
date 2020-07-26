package com.tengke.supermarket.model;

import lombok.Data;

/**
 * @Author: Mr.Chen
 * @Description: 系统用户类
 * @Date:Created in 16:43 2020/7/24
 */
@Data
public class Admin {

    private Integer adminId;

    private String adminName;

    private String adminPassword;

}