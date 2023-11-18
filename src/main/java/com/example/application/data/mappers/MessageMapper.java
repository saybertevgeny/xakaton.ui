package com.example.application.data.mappers;

import com.example.application.data.dto.EmployeeDto;
import com.example.application.data.dto.MessageDto;
import com.example.application.jpa.entity.Employee;
import com.example.application.jpa.entity.Message;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = {
                EmployeeMapper.class,
                MessagePriorityMapper.class,
                MessageCategoryMapper.class
        })
public interface MessageMapper {

        Message convert(MessageDto messageDto);

        MessageDto convert(Message message);
}
