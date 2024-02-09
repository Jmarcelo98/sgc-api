package com.jmsports.sgcapi.services;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jmsports.sgcapi.handlers.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jmsports.sgcapi.model.entities.Team;
import com.jmsports.sgcapi.model.dto.TeamDTO;
import com.jmsports.sgcapi.repositories.TeamRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeamService {

	private TeamRepository teamRepository;
	private SportService sportService;


	public Team create(TeamDTO teamDTO) {
		Team team = new Team();
		team.setDateCreated(LocalDateTime.now());
		team.setDateUpdate(LocalDateTime.now());
		team.setName(teamDTO.getName());
		team.setIsActive(teamDTO.getIsActive());
		team.setSport(sportService.getById(teamDTO.getSportId()));

		teamRepository.save(team);

		return team;
	}
	
	public Team getById(Integer id) {
        return teamRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Erro ao encontrar um Team com o id: [" + id + "]"));
	}

	public Team update(Integer id, TeamDTO teamDTO) {
		Team team = new Team();

		team = teamRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Erro ao encontrar um Team com o id: [" + id + "]"));

		if (!team.getName().toLowerCase().equalsIgnoreCase(teamDTO.getName())) {
			team.setName(teamDTO.getName());
			team.setDateUpdate(LocalDateTime.now());
		} else {
			throw new ResourceNotFoundException("JA EXISTE UM TEAM COM ESSE NOME [ " + teamDTO.getName() + "] ");
		}
		teamRepository.save(team);

		return team;
	}

	public Team delete(Integer id) {
		Team team = teamRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Erro ao encontrar um Team com o id: [" + id + "]"));
		teamRepository.delete(team);
		return team;
	}
	
	public Page<Team> getAll(Integer id, Pageable pageable) {
		try {

			return teamRepository.findAllById(id, pageable);

		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("Nenhum Conteudo encontrado. " + e);
		}
	}

	public Page<Team> getAll(Pageable pageable) {
		try {

			return teamRepository.findAll(pageable);

		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("Nenhum Conteudo encontrado. " + e);
		}
	}
}
