package com.tengke.supermarket.controller;

import com.tengke.supermarket.dto.SupplierDTO;
import com.tengke.supermarket.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cgs
 */
@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/getSupplierIdName")
    public List<SupplierDTO> getAllSupplierName() {
        List<SupplierDTO> strings = supplierService.getSupplierIdName();
        for (SupplierDTO s: strings
             ) {
            System.out.println(s);
        }
        return strings;
    }
}
