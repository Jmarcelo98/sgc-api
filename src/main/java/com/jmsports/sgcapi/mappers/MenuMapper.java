package com.jmsports.sgcapi.mappers;

import com.jmsports.sgcapi.generics.GenericMapper;
import com.jmsports.sgcapi.model.entities.Menu;
import com.jmsports.sgcapi.model.dto.MenuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MenuMapper extends GenericMapper<Menu, MenuDTO> {

    MenuMapper INSTANCE = Mappers.getMapper(MenuMapper.class);

}
