package com.jmsports.sgcapi.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jmsports.sgcapi.model.entities.Sport;
import com.jmsports.sgcapi.repositories.SportRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SportService {
	
	private SportRepository sportRepository;
	
	public Sport create(Sport sport) {
		
		sport.setDescription(sport.getDescription());
		sport.setDateCreated(LocalDate.now());
		sport.setDateUpdate(null);
		sport.setIsActive(sport.getIsActive());
		
		sportRepository.save(sport);
		
		return sport;
	}
	
	public List<Sport> getAll(){
		return sportRepository.findAll();
	}

}
