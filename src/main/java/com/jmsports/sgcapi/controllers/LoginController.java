package com.jmsports.sgcapi.controllers;

import com.jmsports.sgcapi.model.dto.LoginDTO;
import com.jmsports.sgcapi.model.entities.Login;
import com.jmsports.sgcapi.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/logins")
@RestController
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<Login> create(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(loginService.create(loginDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Login> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(loginService.getById(id));
    }


}
