package com.jmsports.sgcapi.services;

import com.jmsports.sgcapi.mappers.MenuMapper;
import com.jmsports.sgcapi.model.dto.MenuDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmsports.sgcapi.repositories.MenuRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MenuService {

	private MenuRepository menuRepository;

	public Page<MenuDTO> getAllActive(Boolean isActive, Pageable pageable) {
		return MenuMapper.INSTANCE.pageEntityToPageDTO(menuRepository.findAllByIsActiveOrderBySort(isActive, pageable));
	}

}
