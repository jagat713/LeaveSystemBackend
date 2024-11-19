package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.LeaveService;
import com.example.demo.dao.ManagerDao;
import com.example.demo.model.EmployeeModel;
import com.example.demo.model.LeaveModel;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ManagerController {
    @Autowired
    private LeaveService leaveService;
    
    @Autowired
    private ManagerDao manager;
    
    @GetMapping("/approved-leaves")
    public List<LeaveModel> getApprovedLeaves(@RequestParam String date) {
        List<LeaveModel> approvedLeaves = leaveService.getApprovedLeavesForDate(date);
        return approvedLeaves;
    }
    @GetMapping("/ManagerAllLeaves")
    public List<LeaveModel> getLeaves() {
        return leaveService.getLeavesByStatusOrTeamLeaderId();
    }
    @GetMapping("/ApproveLeave")
    public boolean ApproveLeave(@RequestParam long EmployeeId,long LeaveId,int noofleaves)
    {
    	boolean status=false;
    	status=leaveService.approveLeave(EmployeeId, LeaveId, noofleaves);
    	return status;
    }
    @PostMapping("/AddEmployee")
    public boolean AddEmployee(@RequestBody EmployeeModel model)
    {
    	boolean status=false;
    	status=manager.AddEmployee(model);
    	return status;
    }
    @DeleteMapping("/RemoveEmployee")
    public boolean RemoveEmployee(@RequestParam long employeeid)
    {
    	boolean status=false;
    	status=manager.removeEmployee(employeeid);
    	return status;
    }
}
