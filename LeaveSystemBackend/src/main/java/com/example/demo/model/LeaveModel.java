package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class LeaveModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long leaveId;

    @Column(name = "leave_type") // Maps to the 'leave_type' column
    private String leaveType;

    @Column(name = "leave_start") // Maps to the 'leave_start' column
    private String leaveStart;

    @Column(name = "leave_end") // Maps to the 'leave_end' column
    private String leaveEnd;

    @Column(name = "leave_reason") // Maps to the 'leave_reason' column
    private String leaveReason;

    @Column(name = "leave_employee_id") // Maps to the 'leave_employee_id' column
    private String leaveEmployeeId;

    @Column(name = "team_leader_id") // Maps to the 'team_leader_id' column
    private String teamLeaderId;

    public LeaveModel() {
        super();
    }

    public LeaveModel(long leaveId, String leaveType, String leaveStart, String leaveEnd, String leaveReason,
                      String leaveEmployeeId, String teamLeaderId) {
        super();
        this.leaveId = leaveId;
        this.leaveType = leaveType;
        this.leaveStart = leaveStart;
        this.leaveEnd = leaveEnd;
        this.leaveReason = leaveReason;
        this.leaveEmployeeId = leaveEmployeeId;
        this.teamLeaderId = teamLeaderId;
    }

    public long getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(long leaveId) {
        this.leaveId = leaveId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getLeaveStart() {
        return leaveStart;
    }

    public void setLeaveStart(String leaveStart) {
        this.leaveStart = leaveStart;
    }

    public String getLeaveEnd() {
        return leaveEnd;
    }

    public void setLeaveEnd(String leaveEnd) {
        this.leaveEnd = leaveEnd;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getLeaveEmployeeId() {
        return leaveEmployeeId;
    }

    public void setLeaveEmployeeId(String leaveEmployeeId) {
        this.leaveEmployeeId = leaveEmployeeId;
    }

    public String getTeamLeaderId() {
        return teamLeaderId;
    }

    public void setTeamLeaderId(String teamLeaderId) {
        this.teamLeaderId = teamLeaderId;
    }

    @Override
    public String toString() {
        return "LeaveModel [leaveId=" + leaveId + ", leaveType=" + leaveType + ", leaveStart=" + leaveStart
                + ", leaveEnd=" + leaveEnd + ", leaveReason=" + leaveReason + ", leaveEmployeeId=" + leaveEmployeeId
                + ", teamLeaderId=" + teamLeaderId + "]";
    }
}
