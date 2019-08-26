package com.learniteasy.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.learniteasy.model.Burger;

public interface BurgerRepository2 extends ReactiveCrudRepository<Burger, String> {

}
