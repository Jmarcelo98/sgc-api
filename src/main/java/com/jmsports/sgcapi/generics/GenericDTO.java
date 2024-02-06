package com.jmsports.sgcapi.generics;

import com.fasterxml.jackson.annotation.JsonFormat;
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

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateCreated;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateUpdate;

	private Boolean isActive;
}
