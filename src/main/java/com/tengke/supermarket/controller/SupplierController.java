package com.tengke.supermarket.controller;

import com.tengke.supermarket.dto.ResultDTO;
import com.tengke.supermarket.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author cgs
 */
@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;


    @GetMapping("/search/{id}")
    public ResultDTO searchSupplierById(@PathVariable("id") int id) {
        return supplierService.searchSupplierById(id);
    }

    @GetMapping("/{pageNo}/{size}")
    public ResultDTO searchAllSupplier(@PathVariable("pageNo") int pageNo, @PathVariable("size") int size) {
        return supplierService.searchAllSupplier(pageNo, size);
    }
}
