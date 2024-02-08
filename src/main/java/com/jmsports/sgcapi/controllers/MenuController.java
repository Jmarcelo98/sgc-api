package com.jmsports.sgcapi.controllers;

import com.jmsports.sgcapi.model.dto.MenuDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import com.jmsports.sgcapi.services.MenuService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/menu")
@CrossOrigin("*")
public class MenuController {

	private MenuService menuService;

	@GetMapping("/active/{active}")
	public Page<MenuDTO> getAllActive(@PathVariable("active") Boolean isActive, Pageable pageable) {
		return menuService.getAllActive(isActive, pageable);
	}

	@GetMapping("/{id}")
	public MenuDTO findById(@PathVariable("id") Integer id) {
		return menuService.findById(id);
	}

}
