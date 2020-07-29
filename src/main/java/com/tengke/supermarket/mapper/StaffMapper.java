package com.tengke.supermarket.mapper;

import com.tengke.supermarket.dto.StaffDTO;
import com.tengke.supermarket.model.Staff;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @Author: cgs
 * @Description： 员工操作接口
 * @Date:Created in 17:17 2020/7/26
 */
@Component
public interface StaffMapper {

    /**
     *  获取员工总数
     *  @return 记录数
     */
    int getCount(String search);

    /**
     * 根据页码信息分页获取员工
     * @param start 偏移量
     * @param pageSize 查询条数
     * @param search 查询的员工名
     * @return 员工集合
     */
    List<StaffDTO> getStaffsByPage(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("search") String search);

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
