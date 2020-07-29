package com.tengke.supermarket.mapper;

import com.tengke.supermarket.model.PurchaseRecord;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 彤老板
 */

@Component
public interface PurchaseMapper {

    int addPurRecord(PurchaseRecord purchaseRecord);

    List<PurchaseRecord> selectAllPurRecord();

    List<PurchaseRecord> selectPurRecordById(int purchaseId);

    int getCount();

    List<PurchaseRecord> selectPurRecordByPage(Integer start, Integer pageSize);
}
