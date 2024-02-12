package com.jmsports.sgcapi.repositories;

import com.jmsports.sgcapi.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
    @Query("SELECT u From User u Join Fetch u.roles WHERE u.name = :name")
    User findByNameFetchRoles(@Param("name") String name);

    Optional<User> findByNameIgnoreCase(String login);

    Boolean existsByNameIgnoreCase(String login);
}