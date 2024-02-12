package com.jmsports.sgcapi.repositories;

import com.jmsports.sgcapi.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
