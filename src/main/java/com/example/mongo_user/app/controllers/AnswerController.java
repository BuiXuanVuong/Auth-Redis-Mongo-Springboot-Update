package com.example.mongo_user.app.controllers;

import com.example.mongo_user.app.dtos.AnswerDTO;
import com.example.mongo_user.domain.services.impl.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {

  @Autowired
  private AnswerService answerService;

  @PostMapping("")
  public ResponseEntity<?> createAnswer(@RequestBody  AnswerDTO answerDTO) {
    answerService.createAnswer(answerDTO);
    return ResponseEntity.ok(answerDTO);
  }

  @DeleteMapping("/{idAnswer}")
  public ResponseEntity<?> deleteAnswer(@PathVariable int idAnswer) throws Exception {
    answerService.deleteAnswerById(idAnswer);
    return ResponseEntity.ok("Delete answer succes!");
  }

}
