package com.learniteasy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learniteasy.dao.BurgerRepository;
import com.learniteasy.model.Burger;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
 
@Service
public class BurgerServiceImpl implements BurgerService {
     
    @Autowired
    BurgerRepository pizzaRepo;
 
    public void create(Burger e) {
        pizzaRepo.save(e).subscribe();
    }
 
    public Mono<Burger> findById(Integer id) {
        return pizzaRepo.findById(id);
    }
 
    public Flux<Burger> findByType(String type) {
        return pizzaRepo.findByType(type);
    }
 
    public Flux<Burger> findAll() {
        return pizzaRepo.findAll();
    }
 
    public Mono<Burger> update(Burger e) {
        return pizzaRepo.save(e);
    }
 
    public Mono<Void> delete(Integer id) {
        return pizzaRepo.deleteById(id);
    }
 
}