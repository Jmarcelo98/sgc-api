package com.jmsports.sgcapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmsports.sgcapi.model.entities.Menu;
import com.jmsports.sgcapi.repositories.MenuRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MenuService {

	@Autowired
	private MenuRepository menuRepository;

	public Page<Menu> getAllActive(Boolean isActive, Pageable pageable) {
		return menuRepository.findAllByIsActiveOrderBySort(isActive, pageable);
	}

}
