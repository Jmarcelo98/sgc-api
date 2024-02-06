package com.jmsports.sgcapi.model.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Where;

import com.jmsports.sgcapi.generics.GenericEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = GenericEntity.ACTIVE)
public class Sport extends GenericEntity {
	
	@Column(nullable = false)
	private String description;

	@OneToMany(mappedBy = "sport")
	@JsonIgnore
	private List<Team> teams;
}
