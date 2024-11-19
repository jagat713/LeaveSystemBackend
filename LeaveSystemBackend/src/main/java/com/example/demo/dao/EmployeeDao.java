package com.example.demo.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	@Autowired
    private EmployeeRepository employeeRepo;

    public EmployeeModel EmployeeDataFunc(long employeeId) {
        Optional<EmployeeModel> findData = employeeRepo.findById(employeeId);
        EmployeeModel employee = null;

        if (findData.isPresent()) {
            employee = findData.get();
            System.out.println(employee);
        } else {
            System.out.println("ID not Found");
        }

        return employee;
    }
}