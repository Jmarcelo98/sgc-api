package com.jmsports.sgcapi.services;

import com.jmsports.sgcapi.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AutenticationService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByNameIgnoreCase(username).orElseThrow(() -> new UsernameNotFoundException("Erro ao encontrar um Usuário com o login: [" + username + "] "));
    }
}
