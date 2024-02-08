package com.jmsports.sgcapi.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jmsports.sgcapi.generics.GenericDTO;
import com.jmsports.sgcapi.model.entities.Menu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubMenuDTO extends GenericDTO {

	private String name;

	@JsonIgnore
	private MenuDTO menu;

}
