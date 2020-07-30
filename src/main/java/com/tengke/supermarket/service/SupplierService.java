package com.tengke.supermarket.service;

import com.tengke.supermarket.dto.PageDTO;
import com.tengke.supermarket.dto.ResultDTO;
import com.tengke.supermarket.dto.SupplierDTO;
import com.tengke.supermarket.mapper.SupplierMapper;
import com.tengke.supermarket.model.Supplier;
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
    public ResultDTO searchAllSupplier(int pageNo, int size) {
        int count = supplierMapper.countSuppliers();
        PageDTO<Supplier> pageDTO = new PageDTO<>(size, count, pageNo);
        List<Supplier> suppliers = supplierMapper.selectAllSupplier(pageDTO.getStart(), pageDTO.getPageSize());
        pageDTO.setData(suppliers);
        return ResultDTO.success("",pageDTO);
    }

    public ResultDTO searchSupplierById(int id) {
        Supplier supplier = supplierMapper.selectSupplierId(id);
        if(supplier == null) {
            return ResultDTO.error("该供货商不存在");
        }
        return ResultDTO.success("",supplier);
    }
}
