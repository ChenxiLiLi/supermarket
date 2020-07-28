package com.tengke.supermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Mr.Chen
 * @Description:
 * @Date:Created in 6:14 2020/7/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDTO {

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 员工性别
     */
    private String gender;

    /**
     * 员工身份证
     */
    private String idCard;

    /**
     * 员工电话号码
     */
    private String phone;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 任职状态
     */
    private String workState;
}
