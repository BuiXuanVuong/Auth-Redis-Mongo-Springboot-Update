package com.example.mongo_user.app.controllers;

import com.example.mongo_user.app.dtos.AnswerDTO;
import com.example.mongo_user.app.dtos.CodeDTO;
import com.example.mongo_user.domain.services.impl.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class CodeController {
    @Autowired
    private CodeService codeService;

    @PostMapping("/code")
    public ResponseEntity<?> createCode(@RequestBody CodeDTO codeDTO) {
        codeService.createCode(codeDTO);
        return ResponseEntity.ok(codeDTO);
    }



}
