package com.tengke.supermarket.service;

import com.tengke.supermarket.dto.SupplierDTO;
import com.tengke.supermarket.mapper.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Mr.Chen
 * @Description:
 * @Date:Created in 0:03 2020/7/30
 */
@Service
public class SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    /**
     * 获取所有供应商的id和名称
     * @return 名称集合
     */
    public List<SupplierDTO> getSupplierIdName() {
        return supplierMapper.getSupplierIdName();
    }
}
