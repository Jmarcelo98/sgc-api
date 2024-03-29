package com.jmsports.sgcapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jmsports.sgcapi.model.entities.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

	@Query(value = "SELECT m FROM Menu m " + "WHERE (:name IS NULL OR UPPER(m.name) LIKE CONCAT('%',:name,'%') ) "
			+ "AND (:isActive IS NULL OR m.isActive = :isActive)")
	Page<Menu> getAllFilter(@Param(value = "name") String name, @Param("isActive") boolean isActive, Pageable pageable);

	Page<Menu> findAllByIsActiveOrderBySort(Boolean isActive, Pageable page);

	Boolean existsByNameIgnoreCase(String name);

}
