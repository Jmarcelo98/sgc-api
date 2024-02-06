package com.jmsports.sgcapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum EnumSize {

	P("p", 1),
	M("m", 2),
	G("g", 3),
	GG("gg", 4);

	private String size;
	private int id;

}
