package com.example.application.services;

import com.example.application.data.dto.EmployeeDto;
import com.example.application.data.dto.MessageCategoryDto;
import com.example.application.data.dto.MessageDto;
import com.example.application.data.dto.MessagePriorityDto;
import com.example.application.data.mappers.EmployeeMapper;
import com.example.application.data.mappers.MessageMapper;
import com.example.application.jpa.entity.Message;
import com.example.application.jpa.repository.MessageRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Service
public class MessageService {

    private final PrioritizationService prioritizationService;
    private final ClassificationService classificationService;
    private final MessageRepository repository;
    private final MessageMapper mapper;
    private final EmployeeMapper employeeMapper;
    private final EmployeeService employeeService;

    public MessageService(PrioritizationService prioritizationService,
                          ClassificationService classificationService,
                          MessageRepository repository,
                          MessageMapper mapper,
                          EmployeeMapper employeeMapper,
                          EmployeeService employeeService) {
        this.prioritizationService = prioritizationService;
        this.classificationService = classificationService;
        this.repository = repository;
        this.mapper = mapper;
        this.employeeMapper = employeeMapper;
        this.employeeService = employeeService;
    }

    @Transactional
    public MessageDto retrieveParamsAndSave(String messageText) {
        MessageDto messageDto = new MessageDto();
        messageDto.setMessageText(messageText);
        MessageCategoryDto category = classificationService.classification(messageText);
        MessagePriorityDto priority = prioritizationService.prioritization(messageText);
        messageDto.setCategory(category);
        messageDto.setPriority(priority);
        if (nonNull(category)){
            messageDto.setEmployee(employeeService.findEmployee(category));
        }
        repository.save(mapper.convert(messageDto));
        return messageDto;
    }

    public List<MessageDto> getAllByEmployee(EmployeeDto employeeDto) {
        List<Message> messageList = repository.getAllByEmployee(employeeMapper.convert(employeeDto));
        List<MessageDto> resultList = new ArrayList<>();
        if (!messageList.isEmpty()) {
            messageList.forEach(message -> {
                resultList.add(mapper.convert(message));
            });
        }
        return resultList;
    }

}
