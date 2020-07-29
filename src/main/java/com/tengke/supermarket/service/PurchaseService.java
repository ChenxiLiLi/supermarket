package com.tengke.supermarket.service;

import com.tengke.supermarket.dto.PageDTO;
import com.tengke.supermarket.dto.PurchaseDTO;
import com.tengke.supermarket.mapper.GoodsMapper;
import com.tengke.supermarket.mapper.PurchaseMapper;
import com.tengke.supermarket.mapper.StaffMapper;
import com.tengke.supermarket.mapper.SupplierMapper;
import com.tengke.supermarket.model.Goods;
import com.tengke.supermarket.model.PurchaseRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 彤老板
 */
@Service
public class PurchaseService {

    @Autowired
    private PurchaseMapper purchaseMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private SupplierMapper supplierMapper;


    /**
     * 进货处理，添加进货记录，修改商品库存
     * @param purchaseRecord 一条进货记录
     * @return 提示信息
     */
    public String purchase(PurchaseRecord purchaseRecord) {
        //不能提交空的进货项
        if(purchaseRecord == null) {
            return "请添加进货记录";
        }
        Goods goods = goodsMapper.selectGoodsById(purchaseRecord.getGoodsId());
        if (goods == null){
            return "该商品不存在，请先录入该商品。";
        }
        //前端传过来的supplierId, staffId, goodsId, goodsNum, goodsPrice
        purchaseRecord.setPurchaseDate(new Date());
        //新增一条进货记录
        int res = purchaseMapper.addPurRecord (purchaseRecord);
        System.out.println(res);
        //修改商品库存信息
        goods.setAmount(goods.getAmount()+purchaseRecord.getPAmount());
        //更新数据库记录
        int updated = goodsMapper.updateGoods(goods);
        if (updated == 1) {
            return "进货成功";
        }
        return "操作失败";
    }

    /**
     * 分页展示进货记录
     * @return 进货记录列表
     */
    public PageDTO<PurchaseDTO> showPurRecordByPage(int page, int size,String goodsName) {
        List<Integer> goodsIdList = goodsMapper.selectIdByName(goodsName);
        //如果不存在该名字的商品
        if(goodsIdList.size() == 0) {
            return null;
        }

        //获取进货总记录条数
        int total = purchaseMapper.getCount(goodsIdList);

        //根据page,size,total获取偏移量
        PageDTO<PurchaseDTO> pageDTO = new PageDTO<>(size, total, page);
        //获取记录集合，封装
        List<PurchaseRecord> allPurRecord = purchaseMapper.selectPurRecordByPage(pageDTO.getStart(), pageDTO.getPageSize(),goodsIdList);
        //将数据库进货记录映射到 前端展示的记录
        List<PurchaseDTO> data = new ArrayList<>(allPurRecord.size());
        for (PurchaseRecord record : allPurRecord) {
            data.add(new PurchaseDTO(record.getPurchaseId(),
                    goodsMapper.selectNameById(record.getGoodsId()),
                    record.getPurchasePrice(),
                    record.getPAmount(),
                    record.getPurchaseDate(),
                    supplierMapper.selectSupplierId(record.getSupplierId()).getSpName(),
                    record.getStaffId()
            ));
        }

        pageDTO.setData(data);
        return pageDTO;
    }



    /**根据进货编号查询进货记录
     * @param purchaseId 进货记录编号
     * @return 一条对应编号的进货记录，用List存储
     */
    public List<PurchaseRecord> showPurRecordById(int purchaseId) {
        return purchaseMapper.selectPurRecordById(purchaseId);
    }
}
