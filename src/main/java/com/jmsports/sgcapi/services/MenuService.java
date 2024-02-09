package com.jmsports.sgcapi.services;

import com.jmsports.sgcapi.handlers.ResourceNotFoundException;
import com.jmsports.sgcapi.mappers.MenuMapper;
import com.jmsports.sgcapi.model.dto.MenuDTO;
import com.jmsports.sgcapi.model.record.FilterMenuRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmsports.sgcapi.repositories.MenuRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MenuService {

	private MenuRepository menuRepository;

	public Page<MenuDTO> getAllByFilter(FilterMenuRecord filterMenuRecord, Pageable pageable) {

		var list = menuRepository.getAllFilter(
				filterMenuRecord.name() != null ? filterMenuRecord.name().toUpperCase() : null,
				filterMenuRecord.isActive(), pageable);

		return MenuMapper.INSTANCE.pageEntityToPageDTO(list);
	}

	public MenuDTO findById(Integer id) {
		return MenuMapper.INSTANCE.entityToDTO(menuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Menu não encontrado através do ID: " + id)));
	}

}
