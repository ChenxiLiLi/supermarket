package com.tengke.supermarket.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author : cgs
 * @Description ： 销售记录
 * @date 2020年7月26日20:41:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellRecord {
    /**
     *  销售编号
     */
    private Integer sellId;

    /**
     *  员工编号
     */
    @NonNull
    private Integer sfId;

    /**
     * 销售日期
     */
    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sellDate;


}
