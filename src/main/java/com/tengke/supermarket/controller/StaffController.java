package com.tengke.supermarket.controller;

import com.tengke.supermarket.dto.PageDTO;
import com.tengke.supermarket.dto.StaffDTO;
import com.tengke.supermarket.model.Staff;
import com.tengke.supermarket.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Mr.Chen
 * @Description:
 * @Date:Created in 6:09 2020/7/28
 */
@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/basicInfo")
    private PageDTO<StaffDTO> getAllEmployeeByPage(HttpServletRequest request) {
        Integer page = Integer.parseInt(request.getParameter("page"));
        Integer size = Integer.parseInt(request.getParameter("size"));
        String search = request.getParameter("search");
        return staffService.getAllStaffByPage(page, size, search);
    }
}
