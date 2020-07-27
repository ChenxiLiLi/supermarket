package com.tengke.supermarket.mapper;

import com.tengke.supermarket.model.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @Author: cgs
 * @Description： 员工操作接口
 * @Date:Created in 17:17 2020/7/26
 */
@Repository
public interface StaffMapper {
    /**
     * 查找所有员工信息
     * @return 员工信息列表
     */
    List<Staff> selectAllStaff();

    /**
     * 根据员工编号查找员工
     * @param sfId 员工编号
     * @return 员工信息
     */
    Staff selectStaffById(int sfId);

    /**
     * 增加员工信息
     * @param staff 新增的员工信息
     * @return 行数
     */
    int addStaff(Staff staff);

    /**
     * 修改员工信息
     * @param staff 要修改的信息
     * @return 行数
     */
    int updateStaff(Staff staff);

    /**
     * 删除员工信息
     * @param sfId 员工编号
     * @return 行数
     */
    int deleteStaff(int sfId);



}
