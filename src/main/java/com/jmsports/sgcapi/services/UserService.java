package com.jmsports.sgcapi.services;

import com.jmsports.sgcapi.handlers.BusinessException;
import com.jmsports.sgcapi.handlers.ResourceNotFoundException;
import com.jmsports.sgcapi.model.dto.UserDTO;
import com.jmsports.sgcapi.model.entities.User;
import com.jmsports.sgcapi.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    public User getUserLogged(String login) {
        return userRepository.findByNameIgnoreCase(login).orElseThrow(() -> new ResourceNotFoundException("Erro ao encontrar um Usuário com o login: [" + login + "] "));
    }

    public User create(UserDTO userDTO) {
        User user = new User();

        if (existsByLogin(userDTO.getName()) != null) {
            throw new BusinessException("Usuário já cadastrado com o nome: [" + userDTO.getName() + "] ");
        }

        user.setName(userDTO.getName());
        user.setCpf(userDTO.getCpf());
        user.setPassword(passwordEncoder().encode(userDTO.getPassword()));
        user.setIsActive(userDTO.getIsActive());
        user.setDateCreated(LocalDateTime.now());
        return userRepository.save(user);
    }

    public User getById(Integer id) {
        return findById(id);
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Erro ao encontrar um Usuário com o id: [" + id + "] "));
    }

    private Boolean existsByLogin(String login) {
        return userRepository.existsByNameIgnoreCase(login);
    }
}
