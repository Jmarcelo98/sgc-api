package com.jmsports.sgcapi.config.security;

import com.jmsports.sgcapi.model.entities.User;
import com.jmsports.sgcapi.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@AllArgsConstructor
public class AppContextHolder {

    private final UserService userService;

    public User getUser() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            return null;
        }
        Optional<User> login = (Optional<User>) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.getUserLogged(login.get().getName());
    }
}
