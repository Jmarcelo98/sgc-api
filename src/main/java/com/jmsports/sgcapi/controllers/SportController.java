package com.jmsports.sgcapi.controllers;

import lombok.AllArgsConstructor;
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
import com.jmsports.sgcapi.model.dto.SportDTO;
import com.jmsports.sgcapi.services.SportService;

@RestController
@RequestMapping("/sports")
@AllArgsConstructor
public class SportController {
	
	private SportService sportService;
	
	@PostMapping
	public ResponseEntity<Sport> create(@RequestBody SportDTO sport) {
		return ResponseEntity.ok().body(sportService.create(sport));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Sport> getById(@PathVariable Integer id) {

		return ResponseEntity.ok(sportService.getById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Sport> update(@PathVariable Integer id,@RequestBody SportDTO sportDTO) {
		return ResponseEntity.ok(sportService.update(id, sportDTO));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		sportService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<Page<Sport>> getAll(Pageable pageable){
		return ResponseEntity.ok(sportService.getAll(pageable));
	}

}
