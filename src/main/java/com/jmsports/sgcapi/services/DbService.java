package com.jmsports.sgcapi.services;

import java.time.LocalDate;
import java.util.Arrays;

import com.jmsports.sgcapi.model.entities.Sport;
import com.jmsports.sgcapi.model.entities.SubMenu;
import com.jmsports.sgcapi.repositories.SportRepository;
import com.jmsports.sgcapi.repositories.SubMenuRepository;
import org.springframework.stereotype.Service;

import com.jmsports.sgcapi.model.entities.Menu;
import com.jmsports.sgcapi.repositories.MenuRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DbService {

    private MenuRepository menuRepository;
    private SportRepository sportRepository;
    private SubMenuRepository subMenuRepository;

    public void add() {
        var menu = Menu.builder().name("Basquete").sort(0).isActive(true).dateCreated(LocalDate.now()).dateUpdate(null).build();
        var menu1 = Menu.builder().name("Futebol").sort(1).isActive(true).dateCreated(LocalDate.now()).dateUpdate(null).build();
        var menu2 = Menu.builder().name("NFL").sort(4).isActive(true).dateCreated(LocalDate.now()).dateUpdate(null).build();
        var menu3 = Menu.builder().name("Vôlei").sort(5).isActive(true).dateCreated(LocalDate.now()).dateUpdate(null).build();
        var menu4 = Menu.builder().name("Tênis").sort(2).isActive(true).dateCreated(LocalDate.now()).dateUpdate(null).build();
        var menu5 = Menu.builder().name("Counter Strike").sort(3).isActive(true).dateCreated(LocalDate.now()).dateUpdate(null).build();

        menuRepository.saveAll(Arrays.asList(menu, menu1, menu2, menu3, menu4, menu5));

        var sport = Sport.builder().description("Futebol").isActive(true).dateCreated(LocalDate.now()).dateUpdate(null).build();
        sportRepository.save(sport);

        var subMenu = SubMenu.builder().id(null).name("Denver Nuggets").menu(menu).isActive(true).dateCreated(LocalDate.now()).dateUpdate(null).build();
        var subMenu1 = SubMenu.builder().id(null).name("Boston Celtics").menu(menu).isActive(true).dateCreated(LocalDate.now()).dateUpdate(null).build();
        var subMenu2 = SubMenu.builder().id(null).name("Cruzeiro").menu(menu1).isActive(true).dateCreated(LocalDate.now()).dateUpdate(null).build();
        var subMenu3 = SubMenu.builder().id(null).name("São Paulo").menu(menu1).isActive(true).dateCreated(LocalDate.now()).dateUpdate(null).build();
        var subMenu4 = SubMenu.builder().id(null).name("MIBR").menu(menu5).isActive(true).dateCreated(LocalDate.now()).dateUpdate(null).build();

        subMenuRepository.saveAll(Arrays.asList(subMenu, subMenu1, subMenu2, subMenu3, subMenu4));

    }

}
