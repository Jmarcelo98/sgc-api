package com.jmsports.sgcapi.services;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jmsports.sgcapi.handlers.BusinessException;
import com.jmsports.sgcapi.handlers.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmsports.sgcapi.model.entities.Sport;
import com.jmsports.sgcapi.model.dto.SportDTO;
import com.jmsports.sgcapi.repositories.SportRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SportService {

	private SportRepository sportRepository;

	public Sport create(SportDTO sportDTO) {
		Sport sport = new Sport();
		sport.setDateCreated(LocalDateTime.now());
		sport.setDateUpdate(LocalDateTime.now());
		sport.setIsActive(sportDTO.getIsActive());
		sport.setDescription(sportDTO.getDescription());

		sportRepository.save(sport);

		return sport;
	}

	public Sport getById(Integer id) {
		return sportRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Erro ao encontrar um Sport com o id: [" + id + "] "));
	}

	public Sport update(Integer id, SportDTO sportDTO) {
		Sport sport = new Sport();

		sport = sportRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Erro ao encontrar um Sport com o id: [" + id + "] "));

		if (!sport.getDescription().toLowerCase().equalsIgnoreCase(sportDTO.getDescription())) {
			sport.setDescription(sportDTO.getDescription());
			sport.setDateUpdate(LocalDateTime.now());
		} else {
			throw new BusinessException("JA EXISTE UM SPORT COM ESSE NOME [ " + sportDTO.getDescription() + "] " );
		}
		sportRepository.save(sport);

		return sport;
	}

	public Page<Sport> getAll(Pageable pageable) {
	    return sportRepository.findAll(pageable);
	}
	
	public void delete(Integer id) {
		try {
			sportRepository.deleteById(id);
		} catch (Exception e) {
			throw new BusinessException("Sport com Id: [" + id + "], não encontrando para deleção. " + e);
		}
	}

}
