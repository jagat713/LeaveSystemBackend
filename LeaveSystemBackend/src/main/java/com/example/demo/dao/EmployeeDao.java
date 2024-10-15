package com.example.demo.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.EmployeeRepository;

@Repository
public class EmployeeDao {

    @Autowired
    private EmployeeRepository employeeRepo; // Inject EmployeeRepo bean

    public EmployeeModel EmployeeDataFunc(long employeeId) {
        Optional<EmployeeModel> findData = employeeRepo.findById(employeeId); // Correct variable name and repo usage
        EmployeeModel employee = null;

        if (findData.isPresent()) {
            employee = findData.get(); // Fetch data if present
            System.out.println(employee);
        } else {
            System.out.println("ID not Found");
        }

        return employee; // Return the found employee or null
    }
}