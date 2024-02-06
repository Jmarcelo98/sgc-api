package com.jmsports.sgcapi.services;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.jmsports.sgcapi.model.entities.Menu;
import com.jmsports.sgcapi.repositories.MenuRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DbService {

    private MenuRepository menuRepository;

    public void add() {
        var menu = Menu.builder().name("Basquete").sort(0).isActive(true).dateCreated(LocalDate.now()).dateUpdate(null).build();
        var menu1 = Menu.builder().name("Futebol").sort(1).isActive(true).dateCreated(LocalDate.now()).dateUpdate(null).build();
        var menu2 = Menu.builder().name("NFL").sort(4).isActive(true).dateCreated(LocalDate.now()).dateUpdate(null).build();
        var menu3 = Menu.builder().name("Vôlei").sort(5).isActive(true).dateCreated(LocalDate.now()).dateUpdate(null).build();
        var menu4 = Menu.builder().name("Tênis").sort(2).isActive(true).dateCreated(LocalDate.now()).dateUpdate(null).build();
        var menu5 = Menu.builder().name("Counter Strike").sort(3).isActive(true).dateCreated(LocalDate.now()).dateUpdate(null).build();

        menuRepository.saveAll(Arrays.asList(menu, menu1, menu2, menu3, menu4, menu5));

    }

}
