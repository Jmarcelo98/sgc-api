package com.jmsports.sgcapi.repositories;

import com.jmsports.sgcapi.model.entities.Shirt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShirtRepository extends JpaRepository<Shirt, Integer>{
}
