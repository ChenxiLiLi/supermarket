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
     * 获取供应商集合,用于展示可选择的供应商列表
     * @return
     */
    List<Supplier> getAllSupplierId();

    /**
     * 获取所有的供应商名称
     * @return
     */
    List<SupplierDTO> getSupplierIdName();
}
