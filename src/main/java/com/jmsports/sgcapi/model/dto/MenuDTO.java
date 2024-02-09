package com.jmsports.sgcapi.model.dto;

import com.jmsports.sgcapi.generics.GenericDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO extends GenericDTO {

	private String name;

	private Integer sort;

	private List<SubMenuDTO> subMenus;

}
