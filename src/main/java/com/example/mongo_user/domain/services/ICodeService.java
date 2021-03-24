package com.example.mongo_user.domain.services;

import com.example.mongo_user.app.dtos.CodeDTO;
import com.example.mongo_user.domain.entities.Code;

public interface ICodeService extends GenaralService<Code> {
    public void createCode(CodeDTO codeDTO);
}
