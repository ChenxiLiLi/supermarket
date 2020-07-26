package com.tengke.supermarket.mapper;

import com.tengke.supermarket.model.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffMapper {
    /**
     * 查找所有员工信息
     * @return 员工信息列表
     */
    List<Staff> selectAllStaff();

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
