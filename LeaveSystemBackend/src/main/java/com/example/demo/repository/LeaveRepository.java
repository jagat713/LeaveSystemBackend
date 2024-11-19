package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LeaveModel;

@Repository
public interface LeaveRepository extends CrudRepository<LeaveModel, Long> {

	List<LeaveModel> findByLeaveEmployeeId(String leaveEmployeeId);
	List<LeaveModel> findByTeamLeaderIdAndLeaveStatusNotIn(String teamLeaderId, List<String> statuses);
    @Query("SELECT l FROM LeaveModel l WHERE l.leaveStatus = 'Approved' AND " +
            "( :date BETWEEN l.leaveStart AND l.leaveEnd )")
    List<LeaveModel> findApprovedLeavesForDate(String date);
    List<LeaveModel> findByLeaveStatus(String leaveStatus);
    List<LeaveModel> findByTeamLeaderIdAndLeaveStatus(String teamLeaderId, String leaveStatus);

}
