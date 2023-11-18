package com.example.application.jpa.repository;

import com.example.application.jpa.entity.MessagePriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessagePriorityRepository extends JpaRepository<MessagePriority, Long> {

    Optional<MessagePriority> findByTitle (String title);
}
