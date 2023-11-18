package com.example.application.data.dto;

import com.example.application.jpa.entity.Message;
import com.example.application.jpa.entity.MessageCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class EmployeeDto {

    private Long id;

    private String name;

    private List<MessageCategoryDto> category;

    private List<MessageDto> messages;
}
