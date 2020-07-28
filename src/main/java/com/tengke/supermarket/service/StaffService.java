package com.tengke.supermarket.service;

import com.tengke.supermarket.dto.PageDTO;
import com.tengke.supermarket.dto.StaffDTO;
import com.tengke.supermarket.mapper.StaffMapper;
import com.tengke.supermarket.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Mr.Chen
 * @Description:
 * @Date:Created in 6:13 2020/7/28
 */
@Service
public class StaffService {

    @Autowired
    private StaffMapper staffMapper;

    public PageDTO<StaffDTO> getAllStaffByPage(Integer page, Integer size, String search) {
        //第一步: 获取总员工数，然后获取分页的条数
        int total = staffMapper.getCount();
        //计算偏移量和总页数
        PageDTO<StaffDTO> pageDTO = new PageDTO<>(size, total, page);
        //封装员工对象到pageDTO.data
        List<StaffDTO> staffList = staffMapper.getStaffsByPage(pageDTO.getStart(), pageDTO.getPageSize(), search);
        pageDTO.setData(staffList);
        return pageDTO;
    }
}
