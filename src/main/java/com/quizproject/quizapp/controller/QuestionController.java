package com.quizproject.quizapp.controller;

import com.quizproject.quizapp.models.Question;
import com.quizproject.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("allquestion")
    public ResponseEntity <List <Question>> getAllQuestion(){
        return questionService.getAllQuestions() ;
    }
    @GetMapping("category/{category}")
    public ResponseEntity< List<Question>> getQuestionByCategory(@PathVariable String category){
        return  questionService.getQuestionByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity <String> addQuestion(@RequestBody Question question){
       return questionService.addQuestion(question);
    }
}
