package com.jmsports.sgcapi.generics;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
