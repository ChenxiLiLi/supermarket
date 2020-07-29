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
    private Integer spID;
    private String spName;
    private String location;
    private String spTel;
    private String description;
}
