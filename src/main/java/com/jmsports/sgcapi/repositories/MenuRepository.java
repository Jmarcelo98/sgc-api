package com.jmsports.sgcapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jmsports.sgcapi.model.entities.Menu;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    Page<Menu> findAllByIsActiveOrderBySort(Boolean isActive, Pageable page);

}
