package com.jmsports.sgcapi.repositories;

import com.jmsports.sgcapi.model.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {
}
