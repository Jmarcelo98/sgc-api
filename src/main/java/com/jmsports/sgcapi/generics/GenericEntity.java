package com.jmsports.sgcapi.generics;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class GenericEntity {

	public static final String ACTIVE = "IS_ACTIVE = true";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

//	private User userCreated;

	private LocalDate dateCreated;

	private LocalDate dateUpdate;

	private Boolean isActive;

}
