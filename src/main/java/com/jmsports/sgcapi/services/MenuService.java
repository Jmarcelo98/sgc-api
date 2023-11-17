package com.jmsports.sgcapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jmsports.sgcapi.model.entities.Menu;
import com.jmsports.sgcapi.repositories.MenuRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MenuService {

	private MenuRepository menuRepository;

	public List<Menu> getAllActive() {

		return menuRepository.findAll();

	}

}
