package com.example.mongo_user.domain.services.mapper;

import com.example.mongo_user.app.dtos.AnswerDTO;
import com.example.mongo_user.app.dtos.CodeDTO;
import com.example.mongo_user.app.dtos.QuestionDTO;
import com.example.mongo_user.domain.entities.Answer;
import com.example.mongo_user.domain.entities.Code;
import com.example.mongo_user.domain.entities.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionMapper {

  public QuestionDTO toDTO(Question entity) {
    QuestionDTO result = new QuestionDTO();
    result.setQuestId(entity.getQuestId());
    List<AnswerDTO> answerDTOList = new ArrayList<>();
    for (Answer answer: entity.getAnswers()) {
      AnswerDTO answerDTO = new AnswerDTO();
      answerDTO.setAnswer(answer.getAnswer());
      answerDTO.setAnswId(answer.getAnswId());
      answerDTO.setStatus(answer.getStatus());
      answerDTOList.add(answerDTO);
    }
    result.setAnswerDTOS(answerDTOList);
    result.setName(entity.getName());
    result.setQuestion(entity.getQuestion());
    List<CodeDTO> codeDTOList = new ArrayList<>();
    for (Code code: entity.getCodes()) {
      CodeDTO codeDTO = new CodeDTO();
      codeDTO.setCodeId(code.getCodeId());
      codeDTO.setCode(code.getCode());
      codeDTO.setName(code.getName());
      codeDTOList.add(codeDTO);
    }
    result.setCodeDTOS(codeDTOList);
    result.setTimeAnswer(entity.getTimeAnswer());
    return result;
  }

  public Question toEntity(QuestionDTO dto) {
    Question result = new Question();
    List<Answer> answers = new ArrayList<>();
    for (AnswerDTO answerDTO : dto.getAnswerDTOS()) {
      Answer answer = new Answer();
      answer.setAnswer(answerDTO.getAnswer());
      answer.setAnswId(answerDTO.getAnswId());
      answer.setStatus(answerDTO.getStatus());
      answers.add(answer);
    }
    result.setAnswers(answers);
    result.setName(dto.getName());
    result.setQuestId(dto.getQuestId());
    result.setQuestion(dto.getQuestion());
    List<Code> codes = new ArrayList<>();
    for (CodeDTO codeDTO: dto.getCodeDTOS()) {
      Code code = new Code();
      code.setCode(codeDTO.getCode());
      code.setName(codeDTO.getName());
      codes.add(code);
    }
    result.setCodes(codes);
    result.setTimeAnswer(dto.getTimeAnswer());
    return result;
  }

  public Question toEntity(Question result, QuestionDTO dto) {
    result.setTimeAnswer(dto.getTimeAnswer());
    List<Answer> answers = new ArrayList<>();
    for (AnswerDTO answerDTO : dto.getAnswerDTOS()) {
      Answer answer = new Answer();
      answer.setAnswer(answerDTO.getAnswer());
      answer.setAnswId(answerDTO.getAnswId());
      answer.setStatus(answerDTO.getStatus());
      answers.add(answer);
    }
    result.setAnswers(answers);
    result.setQuestion(dto.getQuestion());
    result.setName(dto.getName());
    List<Code> codes = new ArrayList<>();
    for (CodeDTO codeDTO: dto.getCodeDTOS()) {
      Code code = new Code();
      code.setCode(codeDTO.getCode());
      code.setName(codeDTO.getName());
      codes.add(code);
    }
    result.setCodes(codes);
    return result;
  }

}
