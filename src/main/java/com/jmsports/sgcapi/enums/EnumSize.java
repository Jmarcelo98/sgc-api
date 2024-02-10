package com.jmsports.sgcapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
public enum EnumSize {

	p( 1),
	m( 2),
	g( 3),
	gg(4);

	private Integer id;

	EnumSize(Integer id) {
		this.id = id;
	}
}
