package com.jmsports.sgcapi.config.security;

import com.jmsports.sgcapi.config.security.service.TokenService;
import com.jmsports.sgcapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Component
public class CustomBasicAutenticationFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION = "Authorization";
    private static final String BASIC = "Basic";

    private final UserRepository userRepository;
    private final TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token;

        var authorizationHeader = request.getHeader(AUTHORIZATION);

        if (authorizationHeader != null) {
            token = authorizationHeader.replace("Bearer ", "");
            var subject  = tokenService.getSubject(token);
            var user = userRepository.findByName(subject);

            var authentication = new UsernamePasswordAuthenticationToken(user, null, null);

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }
    
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        if (isBasicAuthentication(request)) {
//            String[] credentials = decodeBase64(getHeader(request).replace(BASIC, ""))
//                    .split(":");
//            String username = credentials[0];
//            String password = credentials[1];
//
//            User user = userRepository.findByName(username);
//
//            if (user == null ){
//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                response.getWriter().write("Usuário não encontrado");
//                return;
//            }
//
//            boolean valid = checkPassword(user.getPassword(), password);
//
//            if (!valid) {
//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                response.getWriter().write("Senha inválida");
//            }
//
//            setAuthentication(user);
//        }
//
//        filterChain.doFilter(request, response);
//    }

}
