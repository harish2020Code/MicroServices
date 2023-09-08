package com.project.department.service.controller;

import com.project.department.service.entity.Department;
import com.project.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        log.info("Inside saveDepartment");
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/{id}")
    public Department findDepartmentByID(@PathVariable("id") Long departmentID){
        log.info("Inside findDepartmentByID");
        return departmentService.findDepartmentById(departmentID);
    }
}
