package com.learniteasy.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
 
@Data
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Document
public class Burger {
 
    @Id
    int id;
    
    String type;
    long price;

 
    @Override
    public String toString() {
        return "Employee [id=" + id + ", type=" + type + ", price=" + price + "]";
    }    
}
