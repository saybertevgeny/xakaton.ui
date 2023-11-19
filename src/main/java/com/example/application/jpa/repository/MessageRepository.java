package com.example.application.jpa.repository;

import com.example.application.jpa.entity.Employee;
import com.example.application.jpa.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    Integer countByEmployee(Employee employee);

    List<Message> getAllByEmployee (Employee employee);
}
