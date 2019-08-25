package com.learniteasy.dao;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.learniteasy.model.Burger;

import reactor.core.publisher.Flux;
 
public interface BurgerRepository extends ReactiveMongoRepository<Burger, Integer> {
	
    @Query("{ 'type': ?0 }")
    Flux<Burger> findByType(final String type);
}