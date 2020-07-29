package com.tengke.supermarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author xixi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Supplier {
    private Integer supplierId;
    private String supplierName;
    private String supLocation;
    private String supTel;
    private String supDecription;
}
