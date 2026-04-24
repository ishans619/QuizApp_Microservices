package com.telusko.quizapp.service;

import com.telusko.quizapp.dao.QuestionDao;
import com.telusko.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao dao;

    public List<Question> getAllQuestions() {
        return dao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return dao.findByCategory(category);
    }

    public String addQuestion(Question question){
        dao.save(question);
        return "success";
    }
}
