package com.jmsports.sgcapi.generics;

import org.springframework.data.domain.Page;

import java.util.List;

public interface GenericMapper<E, DTO> {

    DTO entityToDTO(E entity);

    E DTOToEntity(DTO dto);

    List<DTO> listaEntityToListaDTO(List<E> lista);

    default Page<DTO> pageEntityToPageDTO(Page<E> pageEntity) {
        return pageEntity.map(this::entityToDTO);
    }

}