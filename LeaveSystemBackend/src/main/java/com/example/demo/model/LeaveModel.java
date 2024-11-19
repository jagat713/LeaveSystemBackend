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

    @Column(name = "leave_type")
    private String leaveType;

    @Column(name = "leave_start")
    private String leaveStart;

    @Column(name = "leave_end")
    private String leaveEnd;
    
    @Column(name = "leave_reason", columnDefinition = "TEXT")
    private String leaveReason;
    
    @Column(name = "leave_employee_name")
    private String leaveEmployeeName;
    
    @Column(name = "leave_employee_id")
    private String leaveEmployeeId;

    @Column(name = "team_leader_id")
    private String teamLeaderId;
    
    @Column(name = "leave_status", nullable = false, columnDefinition = "VARCHAR(45) DEFAULT 'Pending'")
    private String leaveStatus;

    public LeaveModel() {
        super();
    }

	public LeaveModel(long leaveId, String leaveType, String leaveStart, String leaveEnd, String leaveReason,
			String leaveEmployeeName, String leaveEmployeeId, String teamLeaderId, String leaveStatus) {
		super();
		this.leaveId = leaveId;
		this.leaveType = leaveType;
		this.leaveStart = leaveStart;
		this.leaveEnd = leaveEnd;
		this.leaveReason = leaveReason;
		this.leaveEmployeeName = leaveEmployeeName;
		this.leaveEmployeeId = leaveEmployeeId;
		this.teamLeaderId = teamLeaderId;
		this.leaveStatus = leaveStatus;
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

	public String getLeaveEmployeeName() {
		return leaveEmployeeName;
	}

	public void setLeaveEmployeeName(String leaveEmployeeName) {
		this.leaveEmployeeName = leaveEmployeeName;
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

	public String getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	@Override
	public String toString() {
		return "LeaveModel [leaveId=" + leaveId + ", leaveType=" + leaveType + ", leaveStart=" + leaveStart
				+ ", leaveEnd=" + leaveEnd + ", leaveReason=" + leaveReason + ", leaveEmployeeName=" + leaveEmployeeName
				+ ", leaveEmployeeId=" + leaveEmployeeId + ", teamLeaderId=" + teamLeaderId + ", leaveStatus="
				+ leaveStatus + "]";
	}
    
    
    
}
