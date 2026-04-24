package com.telusko.quizapp.controller;

import com.telusko.quizapp.model.ApiResponse;
import com.telusko.quizapp.model.Question;
import com.telusko.quizapp.service.JokeService;
import com.telusko.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/question")
public class questionController {

    @Autowired
    QuestionService service;

    @Autowired
    JokeService jokeService;

    @GetMapping("/test")
    public Map<String, Object> test(){
        Map<String, Object> response = new HashMap<>();

        response.put("message", "Quiz API working");
        response.put("joke", jokeService.getJoke());

        return response;
    }

    @GetMapping("/allQuestions")
    public ApiResponse<List<Question>> getAllQuestions(){
        List<Question> allQuestions = service.getAllQuestions();
        return new ApiResponse<>(allQuestions, jokeService.getJoke());
    }

    @GetMapping("/category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
        return service.getQuestionsByCategory(category);
    }

    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question){
        return service.addQuestion(question);
    }
}
