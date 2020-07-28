package com.tengke.supermarket.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

/**
 * @author cgs
 * @Description： 员工类
 * @date 2020年7月26日20:41:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    /**
    *  员工编号
     */
    private Integer sfId;

    /**
     * 员工姓名
     */
    @NonNull
    private String sfName;

    /**
     * 身份证号
     */
    @NonNull
    private String indentity;

    /**
     * 联系方式
     */
    private String sfTel;

    /**
     * 性别
     */
    private String sex;

    /**
     * 密码
     */
    private String password;

    /**
     * 任职状态
     */
    private Character sfStatus;

}
