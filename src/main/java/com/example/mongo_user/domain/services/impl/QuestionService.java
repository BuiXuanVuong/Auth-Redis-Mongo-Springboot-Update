package com.example.mongo_user.domain.services.impl;

import com.example.mongo_user.app.dtos.AnswerDTO;
import com.example.mongo_user.app.dtos.CodeDTO;
import com.example.mongo_user.app.dtos.QuestionDTO;
import com.example.mongo_user.domain.entities.Answer;
import com.example.mongo_user.domain.entities.Code;
import com.example.mongo_user.domain.entities.Question;
import com.example.mongo_user.domain.entities.User;
import com.example.mongo_user.domain.repositories.AnswerRepository;
import com.example.mongo_user.domain.repositories.CodeRepository;
import com.example.mongo_user.domain.repositories.QuestionRepository;
import com.example.mongo_user.domain.services.IQuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class QuestionService extends CommonService implements IQuestionService {

  @Autowired
  private QuestionRepository questionRepository;

  @Autowired
  private CodeRepository codeRepository;

  @Autowired
  private AnswerRepository answerRepository;

  @Override
  public Iterable<Question> findAll() {
    return questionRepository.findAll();
  }

  @Override
  public Optional<Question> findById(int id) {
    return questionRepository.findById(id);
  }

  @Override
  public Question save(Question question) {
    return questionRepository.save(question);
  }


  @Override
  public void remove(int id) {
    questionRepository.deleteById(id);
  }

  public void creatQuestion(QuestionDTO questionDTO) {
    Question question = new Question();
    question.setQuestId((int) generateSequence(Question.SEQUENCE_NAME));
    question.setName(questionDTO.getName());


    List<Answer> list = new ArrayList<>();
    for (int i = 0; i <questionDTO.getAnswerDTOS().size() ; i++) {
      AnswerDTO answerDTO = questionDTO.getAnswerDTOS().get(i);
      Answer answer = new Answer();
      answer.setStatus(answerDTO.getStatus());
      answer.setAnswId((int) generateSequence(Answer.SEQUENCE_NAME));
      answer.setAnswer(answerDTO.getAnswer());
      answerRepository.save(answer);
      list.add(answer);
    }
    question.setAnswers(list);
    List<Code> listCode = new ArrayList<>();
    List<CodeDTO> ListCodeDTOByUserCreate = questionDTO.getCodeDTOS();
    for (CodeDTO eachCodeDtoInListCodeDto: ListCodeDTOByUserCreate) {
      if (checkCodeInList(eachCodeDtoInListCodeDto.getCode())) {
        System.out.println("Code da duoc tao truoc do");
      } else {
        Code code = new Code();
        code.setCodeId((int) generateSequence(Code.SEQUENCE_NAME));
        code.setCode(eachCodeDtoInListCodeDto.getCode());
        code.setName(eachCodeDtoInListCodeDto.getName());
        codeRepository.save(code);
        listCode.add(code);
      }
    }
    question.setCodes(listCode);
    question.setTimeAnswer(questionDTO.getTimeAnswer());
    questionRepository.save(question);
  }

  public void updateQuestion(QuestionDTO questionDTO, int idQuestionEntity) {
    Question questionEntity = questionRepository.findByQuestId(idQuestionEntity);
    questionEntity.setQuestion(questionDTO.getQuestion());
    questionEntity.setName(questionDTO.getName());
    List<Code> listCode = questionEntity.getCodes();
    List<CodeDTO> ListCodeDTOByUserCreate = questionDTO.getCodeDTOS();
    listCode.clear();
    for (CodeDTO eachCodeDtoInListCodeDto: ListCodeDTOByUserCreate) {
      if (checkCodeInList(eachCodeDtoInListCodeDto.getCode())) {
        System.out.println("Code da duoc tao truoc do");
        Code code = new Code();
        code.setCodeId((int) generateSequence(Code.SEQUENCE_NAME));
        code.setCode(eachCodeDtoInListCodeDto.getCode());
        code.setName(eachCodeDtoInListCodeDto.getName());
        listCode.add(code);
      } else {
        Code code = new Code();
        code.setCodeId((int) generateSequence(Code.SEQUENCE_NAME));
        code.setCode(eachCodeDtoInListCodeDto.getCode());
        code.setName(eachCodeDtoInListCodeDto.getName());
        codeRepository.save(code);
        listCode.add(code);
      }
    }

    questionEntity.setCodes(listCode);

    List<Answer> listAnswer = questionEntity.getAnswers();
    listAnswer.clear();
    for (int i = 0; i <questionDTO.getAnswerDTOS().size() ; i++) {
      AnswerDTO answerDTO = questionDTO.getAnswerDTOS().get(i);
      Answer answer = new Answer();
      answer.setStatus(answerDTO.getStatus());
      answer.setAnswId((int) generateSequence(Answer.SEQUENCE_NAME));
      answer.setAnswer(answerDTO.getAnswer());
      answerRepository.save(answer);
      listAnswer.add(answer);
    }
    questionEntity.setAnswers(listAnswer);
    questionRepository.save(questionEntity);

  }

  @Override
  public List<Question> findAllByCodes_Name(String name) {
    return questionRepository.findAllByCodes_Name(name);
  }

  @Override
  public void deleteQuestion(int idQQuestion) {
    questionRepository.deleteByQuestId(idQQuestion);
  }

  boolean checkCodeInList(String code) {
    List<Code> checkListCode = codeRepository.findAll();
      for (Code eachCodeInList : checkListCode) {
        if (code.equals(eachCodeInList.getCode())) {
          return true;
        }
      }
      return false;
  }
}
