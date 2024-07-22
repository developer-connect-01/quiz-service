package com.developersconnect.quizservice.controller;

import com.developersconnect.quizservice.model.Quiz;
import com.developersconnect.quizservice.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    private QuizService service;

    public QuizController(QuizService service){
        this.service = service;
    }


    @PostMapping
    public Quiz create(@RequestBody Quiz quiz){
        return service.add(quiz);
    }

    @GetMapping
    public List<Quiz> get(){
        return service.get();
    }

    @GetMapping("/{id}")
    public Quiz getById(@PathVariable Long id){
        return service.getById(id);
    }


}
