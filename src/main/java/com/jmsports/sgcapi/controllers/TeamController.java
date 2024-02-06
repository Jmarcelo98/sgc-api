package com.jmsports.sgcapi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmsports.sgcapi.model.entities.Team;
import com.jmsports.sgcapi.model.entities.dto.TeamDTO;
import com.jmsports.sgcapi.services.TeamService;

@RestController
@RequestMapping("/teams")
@AllArgsConstructor
public class TeamController {
	
	private TeamService teamService;

	@PostMapping
	private ResponseEntity<Team> create(@RequestBody TeamDTO teamDTO) {
		return ResponseEntity.ok().body(teamService.create(teamDTO));
	}
	
	@GetMapping("/{teamId}")
	private ResponseEntity<Team> getById(@PathVariable Integer teamId) {
		return ResponseEntity.ok(teamService.getById(teamId));
	}
	
	@GetMapping("/page/{id}")
	private ResponseEntity<Page<Team>> getAll(@PathVariable Integer id,  Pageable pageable) {
		return ResponseEntity.ok(teamService.getAll(id, pageable));
	}
}
