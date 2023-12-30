package com.jmsports.sgcapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmsports.sgcapi.model.entities.Menu;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    List<Menu> findAllByIsActive(Boolean isActive);

}
