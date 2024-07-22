package com.developersconnect.quizservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Question {
    private Long Id;
    private String title;

    private Long quizId;
}
