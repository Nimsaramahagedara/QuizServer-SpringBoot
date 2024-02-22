package com.quizproject.quizapp.controller;

import com.quizproject.quizapp.models.Question;
import com.quizproject.quizapp.models.QuestionWrappper;
import com.quizproject.quizapp.models.Response;
import com.quizproject.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity <String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("getquiz/{id}")
    public ResponseEntity<List<QuestionWrappper>> getQuizById(@PathVariable int id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public  ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Response> responses ){
        return  quizService.calculateResult(id,responses);
    }
}
