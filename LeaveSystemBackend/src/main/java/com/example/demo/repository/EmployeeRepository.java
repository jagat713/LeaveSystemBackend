package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.EmployeeModel;

public interface EmployeeRepository extends CrudRepository<EmployeeModel,Long> {
}
