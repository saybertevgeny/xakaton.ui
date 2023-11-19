package com.example.application.data.mappers;

import com.example.application.data.dto.EmployeeDto;
import com.example.application.jpa.entity.Employee;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Lazy;

@Mapper(
        componentModel = "spring",
        uses = {
//                MessageMapper.class,
                MessageCategoryMapper.class
        })
public interface EmployeeMapper {

    Employee convert(EmployeeDto employeeDto);

    EmployeeDto convert(Employee employee);
}
