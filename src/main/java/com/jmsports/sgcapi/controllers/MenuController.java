package com.jmsports.sgcapi.controllers;

import com.jmsports.sgcapi.model.dto.MenuDTO;
import com.jmsports.sgcapi.model.record.FilterMenuRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.jmsports.sgcapi.services.MenuService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/menu")
@CrossOrigin("*")
public class MenuController {

	private MenuService menuService;

	@PostMapping("/filter")
	public Page<MenuDTO> getAllByFilter(@RequestBody FilterMenuRecord filterMenuRecord, Pageable pageable) {
		return menuService.getAllByFilter(filterMenuRecord, pageable);
	}

	@GetMapping("/{id}")
	public MenuDTO findById(@PathVariable("id") Integer id) {
		return menuService.findById(id);
	}



}
