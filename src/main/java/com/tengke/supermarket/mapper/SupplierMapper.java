package com.tengke.supermarket.mapper;

import com.tengke.supermarket.dto.SupplierDTO;
import com.tengke.supermarket.model.Supplier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Lenovo
 */
@Component
public interface SupplierMapper {
    /**
     * 根据供货商编号查找供货商
     *
     * @param supplierId 供货商编号
     * @return 供货商信息
     */
    Supplier selectSupplierId(int supplierId);

    /**
     * 查找供应商信息记录数
     * @return
     */
    int countSuppliers();

    /**
     * 分页查询所有供应商信息
     * @param start 偏移量
     * @param size 页面大小
     * @return 供应商列表
     */
    List<Supplier> selectAllSupplier(int start, int size);
}
