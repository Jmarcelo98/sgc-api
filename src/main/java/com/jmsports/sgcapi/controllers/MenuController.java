package com.jmsports.sgcapi.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

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
	public Page<Menu> getAllActive(@PathVariable("active") Boolean isActive, Pageable pageable) {
		return menuService.getAllActive(isActive, pageable);
	}

}
