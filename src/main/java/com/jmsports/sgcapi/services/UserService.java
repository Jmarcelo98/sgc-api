package com.jmsports.sgcapi.services;

import com.jmsports.sgcapi.handlers.ResourceNotFoundException;
import com.jmsports.sgcapi.model.dto.UserDTO;
import com.jmsports.sgcapi.model.entities.User;
import com.jmsports.sgcapi.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User create(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setCpf(userDTO.getCpf());
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
}
