package com.jmsports.sgcapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmsports.sgcapi.model.entities.Menu;
import com.jmsports.sgcapi.repositories.MenuRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MenuService {

	@Autowired
	private MenuRepository menuRepository;

	public List<Menu> getAllActive(Boolean isActive) {
		return menuRepository.findAllByIsActive(isActive);
	}

}
