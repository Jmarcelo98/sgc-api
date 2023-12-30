package com.jmsports.sgcapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jmsports.sgcapi.model.entities.Menu;
import com.jmsports.sgcapi.services.MenuService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/menu")
@CrossOrigin("*")
public class MenuController {

	private MenuService menuService;

	@GetMapping("/{active}")
	public ResponseEntity<List<Menu>> getAllActive(@PathVariable("active") Boolean isActive) {
		return ResponseEntity.ok(menuService.getAllActive(isActive));
	}

}
