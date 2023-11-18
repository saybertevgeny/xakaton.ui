package com.example.application.services;

import com.example.application.data.dto.MessageCategoryDto;
import org.springframework.beans.factory.annotation.Value;

public interface Classification {



    /**
     * Метод который выдаст категорию по входящему сообщению
     * @param message
     * @return
     */
    public MessageCategoryDto classification(String message);
}
