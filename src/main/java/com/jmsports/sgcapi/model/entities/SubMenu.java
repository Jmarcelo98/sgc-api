package com.jmsports.sgcapi.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Where;

import com.jmsports.sgcapi.generics.GenericEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = GenericEntity.ACTIVE)
public class SubMenu extends GenericEntity {

	@Column(nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "id_menu")
	private Menu menu;


}
