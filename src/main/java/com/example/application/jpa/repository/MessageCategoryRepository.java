package com.example.application.jpa.repository;

import com.example.application.data.dto.MessageCategoryDto;
import com.example.application.jpa.entity.MessageCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageCategoryRepository extends JpaRepository<MessageCategory, Long> {

    Optional<MessageCategory> findByTitle (String title);
}
