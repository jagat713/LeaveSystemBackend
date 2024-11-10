package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long EmployeeId;
    
    private String EmployeeName;
    private String EmployeeRole;
    private String EmployeeEmail;
    private String EmployeePassword;
    private String EmployeeLeaveBalance;
    
    private long TeamLeaderId;

    public EmployeeModel() {
        super();
    }

    public EmployeeModel(long employeeId, String employeeName, String employeeRole, String employeeEmail,
                         String employeePassword, String employeeLeaveBalance, long teamLeaderId) {
        super();
        EmployeeId = employeeId;
        EmployeeName = employeeName;
        EmployeeRole = employeeRole;
        EmployeeEmail = employeeEmail;
        EmployeePassword = employeePassword;
        EmployeeLeaveBalance = employeeLeaveBalance;
        TeamLeaderId = teamLeaderId;
    }

    public long getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(long employeeId) {
        EmployeeId = employeeId;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getEmployeeRole() {
        return EmployeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        EmployeeRole = employeeRole;
    }

    public String getEmployeeEmail() {
        return EmployeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        EmployeeEmail = employeeEmail;
    }

    public String getEmployeePassword() {
        return EmployeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        EmployeePassword = employeePassword;
    }

    public String getEmployeeLeaveBalance() {
        return EmployeeLeaveBalance;
    }

    public void setEmployeeLeaveBalance(String employeeLeaveBalance) {
        EmployeeLeaveBalance = employeeLeaveBalance;
    }

    // New getter and setter for TeamLeaderId
    public long getTeamLeaderId() {
        return TeamLeaderId;
    }

    public void setTeamLeaderId(long teamLeaderId) {
        TeamLeaderId = teamLeaderId;
    }

    @Override
    public String toString() {
        return "EmployeeModel [EmployeeId=" + EmployeeId + ", EmployeeName=" + EmployeeName + ", EmployeeRole="
                + EmployeeRole + ", EmployeeEmail=" + EmployeeEmail + ", EmployeePassword=" + EmployeePassword
                + ", EmployeeLeaveBalance=" + EmployeeLeaveBalance + ", TeamLeaderId=" + TeamLeaderId + "]";
    }
}
