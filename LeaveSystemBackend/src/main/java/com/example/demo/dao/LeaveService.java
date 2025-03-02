package com.example.demo.dao;

import com.example.demo.model.EmployeeModel;
import com.example.demo.model.LeaveModel;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.LeaveRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository;

//    public Boolean ApplyLeave(LeaveModel model) {
//        Boolean status = false;
//        try {
//        	if (model.getLeaveStatus() == null) {
//        	    model.setLeaveStatus("Pending");
//        	}
//        	System.out.println("debugggin"+model);
//            leaveRepository.save(model);
//            status = true;  
//        } catch (Exception e) {
//            e.printStackTrace(); 
//        }
//        return status;
//    }
    
    
    
    public Boolean ApplyLeave(LeaveModel model) {
        Boolean status = false;
        try {
            if (model.getLeaveStatus() == null) {
                model.setLeaveStatus("Pending");
            }
            
            // Ensure leaveSubmissionDate is set
            if (model.getLeaveDate() == null || model.getLeaveDate().isEmpty()) {
                model.setLeaveDate(java.time.LocalDate.now().toString()); // YYYY-MM-DD
            }
            
            // Ensure leaveTime is set and formatted correctly
            if (model.getLeaveTime() == null || model.getLeaveTime().isEmpty()) {
                model.setLeaveTime(java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm")));
            } else {
                try {
                    // Convert existing time to HH:mm format (if provided)
                    model.setLeaveTime(java.time.LocalTime.parse(model.getLeaveTime())
                            .format(java.time.format.DateTimeFormatter.ofPattern("HH:mm")));
                } catch (Exception e) {
                    System.out.println("Error parsing leaveTime: " + e.getMessage());
                    model.setLeaveTime(java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm")));
                }
            }

            System.out.println("Debugging Before Save: " + model);
            leaveRepository.save(model);
            status = true;  
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return status;
    }


    public List<LeaveModel> allLeaves(String employeeId) {
        try {
        	System.out.println(leaveRepository.findByLeaveEmployeeId(employeeId));
            return leaveRepository.findByLeaveEmployeeId(employeeId);
        } catch (Exception e) {
            e.printStackTrace(); 
            return null;
        }
    }
    public Boolean deleteLeave(String leaveId) {
        boolean status = false;
        try {
            long leaveIds = Long.parseLong(leaveId);
            leaveRepository.deleteById(leaveIds);
            status = true; 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    public List<LeaveModel> getLeavesByTeamLeaderId(String teamLeaderId) {
        // Define the statuses to exclude
        List<String> excludedStatuses = Arrays.asList("Rejected", "Approved");

        return leaveRepository.findByTeamLeaderIdAndLeaveStatusNotIn(teamLeaderId, excludedStatuses);
    }
    public boolean EsclateApplication(Long leaveId) {
    	boolean status=false;
        Optional<LeaveModel> leaveOpt = leaveRepository.findById(leaveId);

        if (leaveOpt.isPresent()) {
            LeaveModel leave = leaveOpt.get();
            leave.setLeaveStatus("Application Under Process");
            leaveRepository.save(leave);

            return status=true;
        } else {
            return status;
        }
    }
    public boolean RejectApplication(Long leaveId) {
    	boolean status=false;
        Optional<LeaveModel> leaveOpt = leaveRepository.findById(leaveId);

        if (leaveOpt.isPresent()) {
            LeaveModel leave = leaveOpt.get();
            leave.setLeaveStatus("Rejected");

            leaveRepository.save(leave);

            return status=true;
        } else {
            return status;
        }
    }
    public List<LeaveModel> getApprovedLeavesForDate(String date) {
        return leaveRepository.findApprovedLeavesForDate(date);
    }
    
    public List<LeaveModel> getLeavesByStatusOrTeamLeaderId() {
        List<LeaveModel> statusLeaves = leaveRepository.findByLeaveStatus("Application Under Process");
        List<LeaveModel> teamLeaderLeaves = leaveRepository.findByTeamLeaderIdAndLeaveStatus("0","pending");

        // Merge the two lists
        List<LeaveModel> combinedLeaves = new ArrayList<>();
        combinedLeaves.addAll(statusLeaves);
        combinedLeaves.addAll(teamLeaderLeaves);

        return combinedLeaves;
    }
    
    public boolean approveLeave(long EmployeeId,long LeaveId,int noofleaves) {
        // Find the leave request by leaveId
        Optional<LeaveModel> leaveOpt = leaveRepository.findById(LeaveId);

        if (leaveOpt.isPresent()) {
            LeaveModel leave = leaveOpt.get();

            // Approve the leave by updating the status
            leave.setLeaveStatus("Approved");
            leaveRepository.save(leave);

            // Find the employee by employeeId and update leave balance
            Optional<EmployeeModel> employeeOpt = employeeRepository.findById(EmployeeId);

            if (employeeOpt.isPresent()) {
                EmployeeModel employee = employeeOpt.get();

                // Deduct the leave days from the employee's balance
                int leavebalance = Integer.parseInt(employee.getEmployeeLeaveBalance()) - noofleaves;
                employee.setEmployeeLeaveBalance(String.valueOf(leavebalance));
                employeeRepository.save(employee);

                return true; // Successful operation
            } else {
                // Debugging statement if employee is not found
                System.out.println("Employee with ID " + EmployeeId + " not found.");
            }
        } else {
            // Debugging statement if leave request is not found
            System.out.println("Leave with ID " + LeaveId + " not found.");
        }

        return false; // Failure (either leave or employee not found)
    }

}

