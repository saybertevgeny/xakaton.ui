package com.example.application.services;

import com.example.application.data.dto.EmployeeDto;
import com.example.application.data.dto.MessageCategoryDto;
import com.example.application.data.dto.MessageDto;
import com.example.application.data.mappers.EmployeeMapper;
import com.example.application.data.mappers.MessageCategoryMapper;
import com.example.application.jpa.entity.Employee;
import com.example.application.jpa.repository.EmployeeRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;
    private final MessageService messageService;
    private final MessageCategoryMapper messageCategoryMapper;

    public EmployeeService(EmployeeRepository repository,
                           EmployeeMapper mapper,
                           @Lazy MessageService messageService,
                           MessageCategoryMapper messageCategoryMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.messageService = messageService;
        this.messageCategoryMapper = messageCategoryMapper;
    }

    /**
     * Вернет сотрудника по классификации и приоритезации
     *
     * @param classification
     * @param priority
     * @return
     */
    public EmployeeDto findEmployee(MessageCategoryDto classification) {
        List<EmployeeDto> employees = getAllByCategory(classification);
        Map<Integer,EmployeeDto> employeeWeights = new HashMap<>();
        if (!employees.isEmpty()){
            employees.forEach(employeeDto -> {
                employeeWeights.put(calculateCurrentWeight(employeeDto), employeeDto);
            });
        }
        Optional<Integer> minKey = employeeWeights.keySet().stream().min(Integer::compareTo);
        return minKey.map(employeeWeights::get).orElse(null);
    }

    public Integer calculateCurrentWeight(EmployeeDto employeeDto) {
        List<MessageDto> messageDtos = messageService.getAllByEmployee(employeeDto);
        Integer weight = 0;
        if (messageDtos.isEmpty()) {
            for (MessageDto messageDto : messageDtos) {
                weight += messageDto.getPriority().getId().intValue();
            }
        }
        return weight;
    }

    public List<EmployeeDto> getAllByCategory(MessageCategoryDto messageCategoryDto) {
        List<Employee> employees = repository.getAllByCategory(messageCategoryMapper.convert(messageCategoryDto));
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        if (!employees.isEmpty()) {
            employees.forEach(employee -> {
                employeeDtos.add(mapper.convert(employee));
            });
        }
        return employeeDtos;
    }
}
