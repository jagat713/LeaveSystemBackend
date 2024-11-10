package com.example.demo.dao;

import com.example.demo.model.LeaveModel;
import com.example.demo.repository.LeaveRepository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    public Boolean ApplyLeave(LeaveModel model) {
        Boolean status = false;
        try {
            // Save the leave request using the repository
        	if (model.getLeaveStatus() == null) {
        	    model.setLeaveStatus("Pending");
        	}
        	System.out.println("debugggin"+model);
            leaveRepository.save(model);
            status = true;  // Indicate that the leave was applied successfully
        } catch (Exception e) {
            e.printStackTrace();  // Handle the exception (you can also log this)
        }
        return status;
    }
    public List<LeaveModel> allLeaves(String employeeId) {
        try {
            // Fetch all leaves for the given employeeId
        	System.out.println(leaveRepository.findByLeaveEmployeeId(employeeId));
            return leaveRepository.findByLeaveEmployeeId(employeeId);
        } catch (Exception e) {
            e.printStackTrace();  // Handle exception
            return null;
        }
    }
    public Boolean deleteLeave(String leaveId) {
        boolean status = false;
        try {
            long leaveIds = Long.parseLong(leaveId);
            leaveRepository.deleteById(leaveIds);  // Delete the leave record
            status = true;  // Set status to true if deletion succeeds
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception
        }
        return status;  // Return the status
    }
}

