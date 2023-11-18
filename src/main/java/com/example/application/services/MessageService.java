package com.example.application.services;

import com.example.application.data.dto.MessageDto;
import com.example.application.data.mappers.MessageMapper;
import com.example.application.jpa.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final PrioritizationService prioritizationService;
    private final ClassificationService classificationService;
    private final MessageRepository repository;
    private final MessageMapper mapper;

    public MessageService(PrioritizationService prioritizationService,
                          ClassificationService classificationService,
                          MessageRepository repository,
                          MessageMapper mapper) {
        this.prioritizationService = prioritizationService;
        this.classificationService = classificationService;
        this.repository = repository;
        this.mapper = mapper;
    }

    public MessageDto retrieveParamsAndSave(String messageText) {
        MessageDto messageDto = new MessageDto();
        messageDto.setMessageText(messageText);
        messageDto.setCategory(classificationService.classification(messageText));
        messageDto.setPriority(prioritizationService.prioritization(messageText));
        //TODO: messageDto.setEmployee();
        repository.save(mapper.convert(messageDto));
        return messageDto;
    }

}
