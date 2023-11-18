package com.example.application.services;

import com.example.application.data.dto.MessageCategoryDto;
import com.example.application.data.mappers.MessageCategoryMapper;
import com.example.application.jpa.entity.MessageCategory;
import com.example.application.jpa.repository.MessageCategoryRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static java.util.Objects.isNull;


@Service
public class ClassificationService implements Classification{

    @Value("${external.category-url}")
    private String categoryUrl;

    private final MessageCategoryRepository repository;
    private final MessageCategoryMapper mapper;

    public ClassificationService(MessageCategoryRepository repository, MessageCategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public MessageCategoryDto classification(String message) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("message", message);
        HttpEntity<String> request = new HttpEntity<>(headers);
        String title = restTemplate.getForObject(categoryUrl, MessageCategoryDto.class, request).getTitle();
        MessageCategoryDto messageCategoryDto = mapper.convert(repository.findByTitle(title).orElse(new MessageCategory()));
        if (isNull(messageCategoryDto.getId())) {
            messageCategoryDto.setTitle(title);
            messageCategoryDto = mapper.convert(repository.save(mapper.convert(messageCategoryDto)));
        }
        return messageCategoryDto;
    }


}
