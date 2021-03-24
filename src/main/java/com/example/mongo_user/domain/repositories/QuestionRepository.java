package com.example.mongo_user.domain.repositories;

import com.example.mongo_user.domain.entities.Answer;
import com.example.mongo_user.domain.entities.Code;
import com.example.mongo_user.domain.entities.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends MongoRepository<Question, Integer> {

//    List<Answer> findAllByCodes(List<Code> codes);
    List<Question> findAllByCodes_Name(String name);
    Question findByQuestId(int idQuestionEntity);
    void deleteByQuestId(int idQuestion);


}
