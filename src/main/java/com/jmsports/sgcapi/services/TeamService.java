package com.jmsports.sgcapi.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmsports.sgcapi.config.exceptions.NotFoundException;
import com.jmsports.sgcapi.model.entities.Team;
import com.jmsports.sgcapi.model.entities.dto.TeamDTO;
import com.jmsports.sgcapi.repositories.TeamRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;

	public Team create(TeamDTO teamDTO) {
		Team team = new Team();
		team.setDateCreated(LocalDate.now());
		team.setDateUpdate(LocalDate.now());
		team.setName(teamDTO.getName());

		teamRepository.save(team);

		return team;
	}
	
	public Team getById(Integer id) {
        return teamRepository.findById(id).orElseThrow(() -> new NotFoundException("Erro ao encontrar um Team com o id: [" + id + "]"));
	}
	
	public Page<Team> getAll(Integer id, Pageable pageable) {
		try {

			return teamRepository.findAllById(id, pageable);

		} catch (NotFoundException e) {
			throw new NotFoundException("Nenhum Conteudo encontrado. " + e);
		}
	}
}
