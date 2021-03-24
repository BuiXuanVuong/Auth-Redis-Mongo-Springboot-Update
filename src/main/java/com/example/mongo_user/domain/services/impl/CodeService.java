package com.example.mongo_user.domain.services.impl;

import com.example.mongo_user.app.dtos.CodeDTO;
import com.example.mongo_user.domain.entities.Answer;
import com.example.mongo_user.domain.entities.Code;
import com.example.mongo_user.domain.repositories.CodeRepository;
import com.example.mongo_user.domain.services.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CodeService extends CommonService implements ICodeService {

  @Autowired
  private CodeRepository codeRepository;

  @Override
  public Iterable<Code> findAll() {
    return codeRepository.findAll();
  }

  @Override
  public Optional<Code> findById(int id) {
    return codeRepository.findById(id);
  }

  @Override
  public Code save(Code code) {
    return codeRepository.save(code);
  }

  @Override
  public void remove(int id) {
    codeRepository.deleteById(id);
  }

  @Override
  public void createCode(CodeDTO codeDTO) {
   Code code = new Code();
   code.setCodeId((int) generateSequence(Answer.SEQUENCE_NAME));
   code.setCode(codeDTO.getCode());
   code.setName(codeDTO.getName());
   codeRepository.save(code);
  }
}
