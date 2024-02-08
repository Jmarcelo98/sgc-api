package com.jmsports.sgcapi.repositories;

import com.jmsports.sgcapi.model.entities.Promotion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

    Page<Promotion> findAllByIsActive(Boolean isActive, Pageable pageable);
}
