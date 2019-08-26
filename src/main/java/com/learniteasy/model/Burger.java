package com.learniteasy.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.rest.core.annotation.RestResource;

import lombok.Data;
 
@Data
@RestResource(rel = "burger", path = "burger")
@Document
public class Burger {

  @Id
  private String id;
  
  @NotNull
  @Size(min = 5, message = "Name must be at least 5 characters long")
  private String type;
  
  private Date createdAt = new Date();
  
  @NotNull
  private float price;

}
