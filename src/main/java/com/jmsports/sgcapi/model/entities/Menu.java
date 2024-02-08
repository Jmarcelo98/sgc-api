package com.jmsports.sgcapi.model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Where;

import com.jmsports.sgcapi.generics.GenericEntity;

@Entity
@Getter
@Setter
//@Builder
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = GenericEntity.ACTIVE)
public class Menu extends GenericEntity {

	@Column(nullable = false)
	private String name;

	private Integer sort;

	@OneToMany(mappedBy = "menu")
	@JsonIgnore
	private List<SubMenu> subMenus;

}
