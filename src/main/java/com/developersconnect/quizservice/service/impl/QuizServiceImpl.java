package com.developersconnect.quizservice.service.impl;

import com.developersconnect.quizservice.model.Quiz;
import com.developersconnect.quizservice.repository.QuizRepository;
import com.developersconnect.quizservice.service.QuestionClient;
import com.developersconnect.quizservice.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuizServiceImpl implements QuizService {

    private QuizRepository repository;

    private QuestionClient questionClient;

    @Override
    public Quiz add(Quiz quiz) {
        return repository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes = repository.findAll();
        return quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionsFromQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
    }

    @Override
    public Quiz getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
    }
}
