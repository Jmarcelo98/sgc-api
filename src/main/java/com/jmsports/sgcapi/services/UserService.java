package com.jmsports.sgcapi.services;

import com.jmsports.sgcapi.handlers.BusinessException;
import com.jmsports.sgcapi.handlers.ResourceNotFoundException;
import com.jmsports.sgcapi.mappers.UserMapper;
import com.jmsports.sgcapi.model.dto.UserDTO;
import com.jmsports.sgcapi.model.entities.User;
import com.jmsports.sgcapi.model.record.LoginRecord;
import com.jmsports.sgcapi.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    public User getUserLogged(String login) {
        return userRepository.findByEmailIgnoreCase(login).orElseThrow(() -> new ResourceNotFoundException("Erro ao encontrar um Usuário com o login: [" + login + "] "));
    }

    public UserDTO create(LoginRecord loginRecord) {
        var user = new User();

        if (existsByEmail(loginRecord.email())) {
            throw new BusinessException("Usuário já cadastrado com o email: [" + loginRecord.email() + "] ");
        }

        user.setPassword(passwordEncoder().encode(loginRecord.password()));
        user.setEmail(loginRecord.email());
        user.setDateCreated(LocalDateTime.now());
        user.setIsActive(true);
        userRepository.save(user);

        return UserMapper.INSTANCE.entityToDTO(user);
    }

    public Page<UserDTO> getAll(Pageable pageable) {
        return UserMapper.INSTANCE.pageEntityToPageDTO(userRepository.findAll(pageable));
    }

    public UserDTO getById(Integer id) {
        return UserMapper.INSTANCE.entityToDTO(findById(id));
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Erro ao encontrar um Usuário com o id: [" + id + "] "));
    }

    private Boolean existsByEmail(String email) {
        return userRepository.existsByEmailIgnoreCase(email);
    }
}
