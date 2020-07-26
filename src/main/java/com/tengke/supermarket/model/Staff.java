package com.tengke.supermarket.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {               // 员工信息
    @NonNull
    private Integer sfId;          // 员工编号
    @NonNull
    private String sfName;         // 员工姓名
    @NonNull
    private String indentity;      // 身份证号
    private String sfTel;          // 联系方式
    private String sex;            // 性别
    private String password;       // 密码
    private Character sfStatus;    // 状态

}
