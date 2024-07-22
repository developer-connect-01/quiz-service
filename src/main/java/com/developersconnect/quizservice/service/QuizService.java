package com.developersconnect.quizservice.service;

import com.developersconnect.quizservice.model.Quiz;

import java.util.List;

public interface QuizService {

    Quiz add(Quiz quiz);
    List<Quiz> get();
    Quiz getById(Long id);
}
