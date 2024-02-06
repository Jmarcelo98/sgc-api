package com.jmsports.sgcapi.services;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmsports.sgcapi.config.exceptions.BadRequestException;
import com.jmsports.sgcapi.config.exceptions.SportNotFoundException;
import com.jmsports.sgcapi.model.entities.Sport;
import com.jmsports.sgcapi.model.entities.dto.SportDTO;
import com.jmsports.sgcapi.repositories.SportRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SportService {

	private SportRepository sportRepository;

	public Sport create(SportDTO sportDTO) {
		Sport sport = new Sport();
		sport.setDateCreated(LocalDate.now());
		sport.setDateUpdate(LocalDate.now());
		sport.setIsActive(true);
		sport.setDescription(sportDTO.getDescription());

		sportRepository.save(sport);

		return sport;
	}

	public Sport update(Integer id, SportDTO sportDTO) {
		Sport sport = new Sport();

		sport = sportRepository.findById(id)
				.orElseThrow(() -> new SportNotFoundException("Erro ao encontrar um Sport com o id: [" + id + "] "));

		if (!sport.getDescription().toLowerCase().equalsIgnoreCase(sportDTO.getDescription())) {
			sport.setDescription(sportDTO.getDescription());
			sport.setDateUpdate(LocalDate.now());
		} else {
			throw new BadRequestException("JA EXISTE UM SPORT COM ESSE NOME [ " + sportDTO.getDescription() + "] " );
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
			throw new BadRequestException("Sport com Id: [" + id + "], não encontrando para deleção. " + e);
		}
	}

}
