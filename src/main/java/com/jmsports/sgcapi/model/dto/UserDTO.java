package com.jmsports.sgcapi.model.dto;

import com.jmsports.sgcapi.model.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String name;
    private String cpf;
    private Boolean isActive;
    private String password;
    private List<Role> roles;

}