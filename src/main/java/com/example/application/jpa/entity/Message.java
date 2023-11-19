package com.example.application.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message_text")
    private String messageText;

    @ManyToOne
    private MessagePriority priority;

    @ManyToOne
    private MessageCategory category;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Employee employee;

}
