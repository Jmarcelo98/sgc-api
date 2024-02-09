package com.jmsports.sgcapi.generics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class GenericDTO {

	private Integer id;

	private LocalDateTime dateCreated;

	private LocalDateTime dateUpdate;

	private Boolean isActive;
}
