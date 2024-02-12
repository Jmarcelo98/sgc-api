package com.jmsports.sgcapi.controllers;

import com.jmsports.sgcapi.config.security.service.TokenService;
import com.jmsports.sgcapi.model.dto.UserDTO;
import com.jmsports.sgcapi.model.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class AutenticationController {

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    @PostMapping
    public String login(@RequestBody UserDTO userDTO) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDTO.getName(), userDTO.getPassword());

        Authentication auth = authenticationManager.authenticate(authenticationToken);

        var user = (User) auth.getPrincipal();

        return tokenService.generateToken(user);
    }
}
