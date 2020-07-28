package com.tengke.supermarket;

import com.tengke.supermarket.dto.PageDTO;
import com.tengke.supermarket.dto.StaffDTO;
import com.tengke.supermarket.mapper.StaffMapper;
import com.tengke.supermarket.service.StaffService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SupermarketApplicationTests {
/*@Autowired
    private StaffService staffService;
    @Autowired
    private StaffMapper staffMapper;

    @Test
    public void testStaff(){
        PageDTO<StaffDTO> list = staffService.getAllStaffByPage(2, 3, "");
        for (StaffDTO staffDTO:
             list.getData()) {
            System.out.println(staffDTO.toString());
        }
    }*/



    /*@Autowired
    private AdminService adminService;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private StaffMapper staffMapper;

    @Test
    public void testGoodsMapper() {
        Goods dianwenpai = new Goods();
        dianwenpai.setGdsId(1);
        dianwenpai.setGdsName("电蚊拍");
        dianwenpai.setAmount(500);
        dianwenpai.setPrice(10.9f);
        int row = goodsMapper.addGoods(dianwenpai);
        System.out.println(row + "行受影响");   //测增加

        dianwenpai.setUnit("只");
        goodsMapper.updateGoods(dianwenpai);    //测修改

        List<Goods> goods = goodsMapper.selectAllGoods();
        System.out.println(goods);              //测查询

        int row1 = goodsMapper.deleteGoods(1);
        System.out.println(row1 + "行受影响");  //测删除

    }

    @Test
    public void testStaffMapper() {
        Staff cgs = new Staff();
        cgs.setSfId(666);
        cgs.setSfName("cgs");
        cgs.setIndentity("44170xxxxx");

        int row = staffMapper.addStaff(cgs);
        System.out.println("新增数据:" + row + "行受影响");

        cgs.setSfStatus('1');
        staffMapper.updateStaff(cgs);

        List<Staff> staff = staffMapper.selectAllStaff();
        System.out.println(staff);

        int row1 = staffMapper.deleteStaff(666);
        System.out.println("删除数据：" + row1 + "行受影响");


    }

    @Test
    public void testFindAdmin() {
        Admin ceshi = adminMapper.selectAdminByUsername("ceshi");
        System.out.println(ceshi);
    }
    @Test
    void contextLoads() {
        Admin admin = new Admin();
        admin.setAdminName("ceshi");
        admin.setAdminPassword("123456");
        ResultDTO resultDTO1 = adminService.login(admin);
        System.out.println(resultDTO1.toString());
    }

    @Test
    void testBcrypt() {
        String str = "admin";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pass = bCryptPasswordEncoder.encode(str);
        System.out.println(pass);
        boolean res = bCryptPasswordEncoder.matches("admin", pass);
        System.out.println(res);
    }
*/
}
