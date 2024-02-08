package com.jmsports.sgcapi.mappers;

import com.jmsports.sgcapi.generics.GenericMapper;
import com.jmsports.sgcapi.model.dto.SubMenuDTO;
import com.jmsports.sgcapi.model.entities.SubMenu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubMenuMapper extends GenericMapper<SubMenu, SubMenuDTO> {

    SubMenuMapper INSTANCE = Mappers.getMapper(SubMenuMapper.class);

}
