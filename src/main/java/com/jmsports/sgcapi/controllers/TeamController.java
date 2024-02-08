package com.jmsports.sgcapi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jmsports.sgcapi.model.entities.Team;
import com.jmsports.sgcapi.model.dto.TeamDTO;
import com.jmsports.sgcapi.services.TeamService;

@RestController
@RequestMapping("/teams")
@AllArgsConstructor
public class TeamController {
	
	private TeamService teamService;

	@PostMapping
	public ResponseEntity<Team> create(@RequestBody TeamDTO teamDTO) {
		return ResponseEntity.ok().body(teamService.create(teamDTO));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Team> update(@PathVariable Integer id, @RequestBody TeamDTO teamDTO) {
		return ResponseEntity.ok(teamService.update(id, teamDTO));
	}
	
	@GetMapping("/{teamId}")
	public ResponseEntity<Team> getById(@PathVariable Integer teamId) {
		return ResponseEntity.ok(teamService.getById(teamId));
	}
	
	@GetMapping("/page/{id}")
	public ResponseEntity<Page<Team>> getAll(@PathVariable Integer id,  Pageable pageable) {
		return ResponseEntity.ok(teamService.getAll(id, pageable));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Team> delete(@PathVariable Integer id) {
		return ResponseEntity.ok(teamService.delete(id));
	}

	@GetMapping
	public Page<Team> getAll(Pageable pageable){
		return teamService.getAll(pageable);
	}
}
