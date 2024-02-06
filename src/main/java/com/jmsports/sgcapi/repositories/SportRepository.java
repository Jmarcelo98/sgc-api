package com.jmsports.sgcapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmsports.sgcapi.model.entities.Sport;

public interface SportRepository extends JpaRepository<Sport, Integer> {

}
