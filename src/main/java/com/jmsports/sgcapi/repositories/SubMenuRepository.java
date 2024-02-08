package com.jmsports.sgcapi.repositories;

import com.jmsports.sgcapi.model.entities.SubMenu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubMenuRepository extends JpaRepository<SubMenu, Integer> {

    Page<SubMenu> findAllByIsActiveOrderByNameAsc(Boolean isActive, Pageable page);

}
