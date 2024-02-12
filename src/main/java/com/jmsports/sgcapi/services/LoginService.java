package com.jmsports.sgcapi.services;

import com.jmsports.sgcapi.model.dto.LoginDTO;
import com.jmsports.sgcapi.model.entities.Login;
import com.jmsports.sgcapi.repositories.LoginRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;
    private final UserService userService;

    public Login create(LoginDTO loginDTO) {
        Login login = new Login();
        login.setEmail(loginDTO.getEmail());
        login.setPassword(loginDTO.getPassword());
        login.setUser(userService.getById(loginDTO.getUserId()));

        return loginRepository.save(login);
    }

    public Login getById(Integer id) {
        return loginRepository.findById(id).orElse(null);
    }
}
