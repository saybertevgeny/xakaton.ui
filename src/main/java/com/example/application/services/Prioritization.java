package com.example.application.services;

import com.example.application.data.dto.MessagePriorityDto;

public interface Prioritization {

    /**
     * Метод который выдаст приоритезацию по входящему сообщению
     * @param message
     * @return
     */
    public MessagePriorityDto prioritization(String message);
}
