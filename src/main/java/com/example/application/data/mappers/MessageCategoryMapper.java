package com.example.application.data.mappers;

import com.example.application.data.dto.MessageCategoryDto;
import com.example.application.jpa.entity.MessageCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageCategoryMapper {
    MessageCategory convert(MessageCategoryDto messageCategoryDto);

    MessageCategoryDto convert(MessageCategory messageCategory);
}
