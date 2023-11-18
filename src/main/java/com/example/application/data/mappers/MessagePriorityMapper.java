package com.example.application.data.mappers;

import com.example.application.data.dto.MessageCategoryDto;
import com.example.application.data.dto.MessagePriorityDto;
import com.example.application.jpa.entity.MessageCategory;
import com.example.application.jpa.entity.MessagePriority;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessagePriorityMapper {
    MessagePriority convert(MessagePriorityDto messagePriorityDto);

    MessagePriorityDto convert(MessagePriority messageCategory);
}
