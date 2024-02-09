package com.jmsports.sgcapi.services;

import com.jmsports.sgcapi.handlers.BusinessException;
import com.jmsports.sgcapi.handlers.ResourceNotFoundException;
import com.jmsports.sgcapi.mappers.MenuMapper;
import com.jmsports.sgcapi.model.dto.MenuDTO;
import com.jmsports.sgcapi.model.entities.Menu;
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

		list.forEach(obj -> {
			obj.setSubMenus(null);
		});

		return MenuMapper.INSTANCE.pageEntityToPageDTO(list);
	}

	public MenuDTO getById(Integer id) {
		return MenuMapper.INSTANCE.entityToDTO(menuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Menu não encontrado através do ID: " + id)));
	}

	public void update(MenuDTO menuDTO) {

		var menu = findById(menuDTO.getId());

		if (existsByName(menuDTO.getName())) {
			throw new BusinessException("Nome do Menu já existe");
		}

		menu.setName(menuDTO.getName());
		menu.setDateUpdate(menuDTO.getDateUpdate());
		menu.setIsActive(menuDTO.getIsActive());

		menuRepository.save(menu);

	}

	public Menu findById(Integer id) {
		return menuRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Menu não encontrado através do ID: " + id) );
	}

//	privates

	private Boolean existsByName(String name) {
		return menuRepository.existsByNameIgnoreCase(name);
	}
}
