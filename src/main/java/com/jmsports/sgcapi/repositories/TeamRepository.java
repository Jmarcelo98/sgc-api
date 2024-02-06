package com.jmsports.sgcapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jmsports.sgcapi.model.entities.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {
	
	Page<Team> findAllById(Integer id, Pageable pageable);

}
