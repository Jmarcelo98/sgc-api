package com.jmsports.sgcapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmsports.sgcapi.model.entities.Sport;
import com.jmsports.sgcapi.services.SportService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/sports")
public class SportController {
	
	@Autowired
	private SportService sportService;
	
	@PostMapping
	private ResponseEntity<Sport> create(@RequestBody Sport sport) {
		return ResponseEntity.ok().body(sportService.create(sport));
	}
	
	@GetMapping
	public ResponseEntity<List<Sport>> getAll(){
		return ResponseEntity.ok(sportService.getAll());
	}

}
