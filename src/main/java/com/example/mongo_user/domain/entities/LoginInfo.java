package com.example.mongo_user.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "LoginInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {

  private Integer id_login;
  private String token_login;

  private String name;

  @Field(name = "role_name")
  private String roleName;

  @Field(name = "expired_jwt")
  private Date expiredJwt;
  private Integer status;

}
