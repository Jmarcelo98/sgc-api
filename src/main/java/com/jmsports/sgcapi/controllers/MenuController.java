package com.jmsports.sgcapi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmsports.sgcapi.model.entities.Menu;
import com.jmsports.sgcapi.services.MenuService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/menu")
public class MenuController {

	private MenuService menuService;

	@GetMapping
	public ResponseEntity<List<Menu>> getAllActive() {
		return ResponseEntity.ok(menuService.getAllActive());
	}

}
