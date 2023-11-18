package com.example.application.services;

import com.example.application.data.dto.MessagePriorityDto;
import com.example.application.data.mappers.MessagePriorityMapper;
import com.example.application.jpa.entity.MessageCategory;
import com.example.application.jpa.entity.MessagePriority;
import com.example.application.jpa.repository.MessagePriorityRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static java.util.Objects.isNull;

@Service
public class PrioritizationService implements Prioritization{

    private final MessagePriorityMapper mapper;
    private final MessagePriorityRepository repository;

    @Value("${external.priority-url}")
    public String priorityUrl;

    public PrioritizationService(MessagePriorityMapper mapper, MessagePriorityRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public MessagePriorityDto prioritization(String message) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("message", message);
        HttpEntity<String> request = new HttpEntity<>(headers);
        String title = restTemplate.getForObject(priorityUrl, MessagePriority.class, request).getTitle();
        MessagePriorityDto messagePriorityDto = mapper.convert(repository.findByTitle(title).orElse(new MessagePriority()));
        if (isNull(messagePriorityDto.getId())) {
            messagePriorityDto.setTitle(title);
            messagePriorityDto = mapper.convert(repository.save(mapper.convert(messagePriorityDto)));
        }
        return messagePriorityDto;
    }
}
