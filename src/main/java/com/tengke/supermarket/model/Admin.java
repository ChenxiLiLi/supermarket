package com.tengke.supermarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** @Author: Mr.Chen
 * @Description: 系统用户类
 * @Date:Created in 16:43 2020/7/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    private Integer adminId;

    private String adminName;

    private String adminPassword;

    private String token;

    private Long createTime;
}