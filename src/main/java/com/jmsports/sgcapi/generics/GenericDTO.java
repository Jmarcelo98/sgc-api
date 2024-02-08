package com.jmsports.sgcapi.generics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class GenericDTO {

	private Integer id;

	private LocalDate dateCreated;

	private LocalDate dateUpdate;

	private Boolean isActive;
}
