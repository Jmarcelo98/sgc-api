package com.jmsports.sgcapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmsports.sgcapi.model.entities.Sport;
import com.jmsports.sgcapi.model.entities.dto.SportDTO;
import com.jmsports.sgcapi.services.SportService;

@RestController
@RequestMapping("/sports")
public class SportController {
	
	@Autowired
	private SportService sportService;
	
	@PostMapping
	private ResponseEntity<Sport> create(@RequestBody SportDTO sport) {
		return ResponseEntity.ok().body(sportService.create(sport));
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<Sport> update(@PathVariable Integer id,@RequestBody SportDTO sportDTO) {
		return ResponseEntity.ok(sportService.update(id, sportDTO));
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<Void> delete(@PathVariable Integer id) {
		sportService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<Page<Sport>> getAll(Pageable pageable){
		return ResponseEntity.ok(sportService.getAll(pageable));
	}

}
