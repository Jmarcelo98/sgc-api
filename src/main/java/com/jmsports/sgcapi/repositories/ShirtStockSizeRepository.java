package com.jmsports.sgcapi.repositories;

import com.jmsports.sgcapi.model.entities.ShirtStockSize;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShirtStockSizeRepository extends JpaRepository<ShirtStockSize, Integer> {

    Integer countByEnumId(Integer enumId);
}
