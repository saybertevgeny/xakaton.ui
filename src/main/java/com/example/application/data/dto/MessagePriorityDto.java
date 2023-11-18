package com.example.application.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MessagePriorityDto {
    private Long id;

    @JsonProperty("result")
    private String title;
}
