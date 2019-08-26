package com.learniteasy.service;

import com.learniteasy.model.Burger;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
 
public interface BurgerService
{
	void create(Burger e) ;
     
    Mono<Burger> findById(Integer id);
 
    Flux<Burger> findByType(String type);
 
    Flux<Burger> findAll();
 
    Mono<Burger> update(Burger e);
 
    Mono<Void> delete(Integer id);
}