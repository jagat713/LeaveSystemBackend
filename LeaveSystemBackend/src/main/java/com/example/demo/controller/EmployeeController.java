package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.dao.LeaveService;
import com.example.demo.model.EmployeeModel;
import com.example.demo.model.LeaveModel;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private LeaveService leaveService;

    @PostMapping("/login")
    public EmployeeModel EmployeeData(@RequestBody EmployeeModel employee) {
        long employeeId = employee.getEmployeeId();
        EmployeeModel employeeData = employeeDao.EmployeeDataFunc(employeeId);

        if (employeeData != null) {
            return employeeData;
        } else {
            return null;
        }
    }

    @PostMapping("/apply-leave")
    public Boolean ApplyLeave(@RequestBody LeaveModel model) {
        System.out.println(model.toString());
        return leaveService.ApplyLeave(model);
    }

    @PostMapping("/all-leave")
    public List<LeaveModel> getAllLeaves(@RequestBody EmployeeModel employee) {
        String employeeId = String.valueOf(employee.getEmployeeId());
        System.out.println();
        return leaveService.allLeaves(employeeId);
    }

    @DeleteMapping("/delete-leave")
    public boolean deleteLeave(@RequestParam Long leaveId) {
        try {
            String leaveIds = String.valueOf(leaveId);
            leaveService.deleteLeave(leaveIds);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    } 
}
