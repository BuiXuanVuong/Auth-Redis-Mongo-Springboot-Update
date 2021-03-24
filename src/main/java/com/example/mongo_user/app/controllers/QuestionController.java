package com.example.mongo_user.app.controllers;

import com.example.mongo_user.app.dtos.QuestionDTO;
import com.example.mongo_user.domain.entities.Code;
import com.example.mongo_user.domain.entities.Question;
import com.example.mongo_user.domain.services.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionController {

  @Autowired
  private IQuestionService questionService;

  @PostMapping("/question")
  public ResponseEntity<?> createQuestion(@RequestBody QuestionDTO questionDTO) {
    questionService.creatQuestion(questionDTO);
    return ResponseEntity.ok(questionDTO);
  }

  @GetMapping("/questionsbycodes")
  public ResponseEntity<?> getQuestions(@RequestBody Code code) {
    return ResponseEntity.ok(questionService.findAllByCodes_Name(code.getCode()));
  }

  @PutMapping("/question/{idQuestion}")
  public ResponseEntity<?> updateQuestion(@RequestBody QuestionDTO questionDTO, @PathVariable String idQuestion) {
    questionService.updateQuestion(questionDTO,Integer.parseInt(idQuestion));
    return ResponseEntity.ok(new String("Update success!"));
  }

  @DeleteMapping("/question/{idQuestion}")
  public ResponseEntity<?> deleteQuestion(@PathVariable String idQuestion) {
    questionService.deleteQuestion(Integer.parseInt(idQuestion));
    return ResponseEntity.ok(new String("Delete success"));
  }

}
