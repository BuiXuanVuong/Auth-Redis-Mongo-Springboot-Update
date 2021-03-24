package com.example.mongo_user.domain.services;


import com.example.mongo_user.app.dtos.QuestionDTO;
import com.example.mongo_user.domain.entities.Answer;
import com.example.mongo_user.domain.entities.Code;
import com.example.mongo_user.domain.entities.Question;

import java.util.List;

public interface IQuestionService extends GenaralService<Question>{

  public void creatQuestion(QuestionDTO questionDTO);

  public void updateQuestion(QuestionDTO questionDTO, int idQuestionEntity);

  public List<Question> findAllByCodes_Name(String code);

  public void deleteQuestion(int idQQuestion);

}
