package com.example.application.jpa.repository;

import com.example.application.jpa.entity.Employee;
import com.example.application.jpa.entity.Message;
import com.example.application.jpa.entity.MessageCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> getAllByCategory (MessageCategory category);
}
