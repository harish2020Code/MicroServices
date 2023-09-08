package com.project.department.service;

import com.project.department.service.entity.Department;
import com.project.department.service.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentID) {
        return departmentRepository.findByDepartmentId(departmentID);
    }
}
