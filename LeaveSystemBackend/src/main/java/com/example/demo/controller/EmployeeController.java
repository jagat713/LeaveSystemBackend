package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.dao.LeaveService;
import com.example.demo.model.EmployeeModel;
import com.example.demo.model.LeaveModel;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao; // Inject EmployeeDao using @Autowired
    @Autowired
    private LeaveService leaveService;

    @PostMapping("/login")
    public EmployeeModel EmployeeData(@RequestBody EmployeeModel employee) 
    {
        long employeeId = employee.getEmployeeId(); // Assuming EmployeeId is an long
        EmployeeModel employeeData = employeeDao.EmployeeDataFunc(employeeId); // Get employee data

        if (employeeData != null) 
        {
            return employeeData; // Return employee data
        } else 
        {
            // Return an empty response or handle the case where the employee ID is not found
            return null;
        }
    }
    @PostMapping("/apply-leave")
    public Boolean ApplyLeave(@RequestBody LeaveModel model) {
    	System.out.println(model.toString());
        return leaveService.ApplyLeave(model); // Call the method on the injected service
    }
    @PostMapping("/all-leave")
    public List<LeaveModel> getAllLeaves(@RequestBody EmployeeModel employee) {
        // Call the service method to fetch leaves for the given employeeId
    	String employeeId =String.valueOf(employee.getEmployeeId());
    	System.out.println();
        return leaveService.allLeaves(employeeId);
    }
}
