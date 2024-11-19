package com.example.demo.dao;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.EmployeeRepository;

@Service
public class ManagerDao {
    @Autowired
    private EmployeeRepository employeeRepository;
    public boolean AddEmployee(EmployeeModel model)
    {
        boolean status = false;
        EmployeeModel savedModel = employeeRepository.save(model);
        if (savedModel != null) {
            status = true;
            System.out.println(savedModel);
        }
        return status;
    }
    public boolean removeEmployee(long employeeId) {
        boolean status = false;

        if (employeeRepository.existsById(employeeId)) 
        {
            employeeRepository.deleteById(employeeId);
            status = !employeeRepository.existsById(employeeId);
        }

        return status;
    }

}
