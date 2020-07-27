package com.tengke.supermarket.service;

import com.tengke.supermarket.mapper.GoodsMapper;
import com.tengke.supermarket.mapper.SellItemMapper;
import com.tengke.supermarket.mapper.SellRecordMapper;
import com.tengke.supermarket.mapper.StaffMapper;
import com.tengke.supermarket.model.Goods;
import com.tengke.supermarket.model.SellItem;
import com.tengke.supermarket.model.SellRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cgs
 */
@Service
public class SellService {
    @Autowired
    private SellItemMapper sellItemMapper;
    @Autowired
    private SellRecordMapper sellRecordMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private StaffMapper staffMapper;
    /**
     * 查看商品编号是否有对应商品存在，且商品库存是否充足
     * @param id 商品编号
     * @param amount 库存
     * @return 如果商品存在，则返回商品，否则返回null
     */
    public Goods existAndEnough(int id, int amount) {
        Goods goods = goodsMapper.selectGoodsById(id);
        if(goods!=null) {
            if(amount <= goods.getAmount()) {
                return goods;
            }
        }
        return null;
    }

    /**
     * 销售处理，需要添加销售记录，添加销售项，修改商品库存
     * @param items 销售项集合
     * @param sfId 员工编号
     * @return 提示信息
     */
    public String sell(SellItem[] items, int sfId) {
        //不能提交空的销售项
        if(items.length == 0) {
            return "请添加销售项";
        }
        if(staffMapper.selectStaffById(sfId) == null) {
            return "该员工不存在！";
        }

        //新增当前时间点的销售记录
        sellRecordMapper.addSellRecord(new SellRecord(null, sfId, new Date()));
        //获得当前销售记录的销售编号，为每个销售项注入
        Integer sellId = sellRecordMapper.selectLastRecord().getSellId();

        Goods goods = null;
        for (SellItem item : items) {
            //判断商品是否存在且库存充足
            if ((goods = existAndEnough(item.getGdsId(), item.getAmount())) != null) {
                goods.setAmount(goods.getAmount() - item.getAmount());
                //修改商品库存信息
                goodsMapper.updateGoods(goods);
                //为销售项注入销售编号
                item.setSellId(sellId);
            } else {
                return "商品不存在或者库存不足";
            }
        }
        //批量添加销售项的条数
        int row = sellItemMapper.addItems(items);
        if(row == items.length) {
            return "添加" + row + "条记录成功！";
        } else {
            return "添加失败！";
        }
    }

    /**
     * 分页查询销售记录
     * @param pageNo 页码
     * @param size 页大小
     * @return 销售记录列表
     */
    public List<SellRecord> showSellRecordList(int pageNo, int size) {
        Map<String,Integer> info = new HashMap<>(2);
        /*
            start：数据库表记录的开始下标，从0开始。
            对应公式：start = (pageNo-1)*size
            比如一页4条记录，当前页码为1，则开始记录下标为(1-1)*4=0，对应记录0 1 2 3
        */
        info.put("start",(pageNo-1)*size);
        info.put("size",size);
        return sellRecordMapper.selectRecordsByPages(info);
    }

    /**
     * 根据销售编号查找销售项
     * @param sellId 销售编号
     * @return 销售项列表
     */
    public List<SellItem> showSellItem(int sellId) {
        return sellItemMapper.selectAllItemsById(sellId);
    }
}
