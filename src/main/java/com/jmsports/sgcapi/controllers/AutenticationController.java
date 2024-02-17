package com.jmsports.sgcapi.controllers;

import com.jmsports.sgcapi.config.security.service.TokenService;
import com.jmsports.sgcapi.model.dto.UserDTO;
import com.jmsports.sgcapi.model.entities.User;
import com.jmsports.sgcapi.model.record.LoginRecord;
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
    public String login(@RequestBody LoginRecord loginRecord) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRecord.email(), loginRecord.password());

        Authentication auth = this.authenticationManager.authenticate(authenticationToken);

        var user = (User) auth.getPrincipal();

        return tokenService.generateToken(user);
    }
}
