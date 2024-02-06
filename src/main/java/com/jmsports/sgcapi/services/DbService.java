package com.jmsports.sgcapi.services;

import java.time.LocalDate;

import com.jmsports.sgcapi.model.entities.Sport;
import com.jmsports.sgcapi.repositories.SportRepository;
import org.springframework.stereotype.Service;

import com.jmsports.sgcapi.model.entities.Menu;
import com.jmsports.sgcapi.repositories.MenuRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DbService {

    private MenuRepository menuRepository;
    private SportRepository sportRepository;

    public void add() {
        var menu = Menu.builder().name("Teste").sort(1).isActive(true).dateCreated(LocalDate.now()).dateUpdate(null).build();
        menuRepository.save(menu);

        var sport = Sport.builder().description("Futebol").isActive(true).dateCreated(LocalDate.now()).dateUpdate(null).build();
        sportRepository.save(sport);

    }

}
