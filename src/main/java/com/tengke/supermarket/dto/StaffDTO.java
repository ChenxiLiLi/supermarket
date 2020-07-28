package com.tengke.supermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

/**
 * @Author: Mr.Chen
 * @Description:
 * @Date:Created in 6:14 2020/7/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDTO {

    // 员工姓名
    private String name;

    // 性别
    private String gender;

    //身份证号
    @NonNull
    private String idCard;

    // 电话号码
    private String phone;

    // 电子邮箱
    private String email;

    // 联系地址
    private String address;

    // 任职状态
    private String workState;
}
