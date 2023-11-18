package com.example.application.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MessageDto {
    private Long id;

    private String messageText;

    private MessagePriorityDto priority;

    private MessageCategoryDto category;

    private EmployeeDto employee;
}
