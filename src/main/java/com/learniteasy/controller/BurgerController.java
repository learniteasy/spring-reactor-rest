package com.learniteasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.learniteasy.model.Burger;
import com.learniteasy.service.BurgerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BurgerController {
	@Autowired
	private BurgerService burgerServiceImpl;

	@RequestMapping(value = { "/create", "/" }, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void create(@RequestBody Burger e) {
		burgerServiceImpl.create(e);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Mono<Burger>> findById(@PathVariable("id") Integer id) {
		Mono<Burger> e = burgerServiceImpl.findById(id);
		HttpStatus status = e != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Mono<Burger>>(e, status);
	}

	@RequestMapping(value = "/type/{type}", method = RequestMethod.GET)
	@ResponseBody
	public Flux<Burger> findByName(@PathVariable("type") String type) {
		return burgerServiceImpl.findByType(type);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@ResponseBody
	public Flux<Burger> findAll() {
		Flux<Burger> emps = burgerServiceImpl.findAll();
		return emps;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Mono<Burger> update(@RequestBody Burger e) {
		return burgerServiceImpl.update(e);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Integer id) {
		burgerServiceImpl.delete(id).subscribe();
	}

}
