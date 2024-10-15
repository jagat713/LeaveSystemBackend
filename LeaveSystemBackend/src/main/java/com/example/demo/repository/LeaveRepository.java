package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LeaveModel;

@Repository
public interface LeaveRepository extends CrudRepository<LeaveModel, Long> {

	List<LeaveModel> findByLeaveEmployeeId(String leaveEmployeeId);

}
