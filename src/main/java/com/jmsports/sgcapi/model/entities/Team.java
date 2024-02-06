package com.jmsports.sgcapi.model.entities;

import javax.persistence.*;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jmsports.sgcapi.generics.GenericEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = GenericEntity.ACTIVE)
public class Team extends GenericEntity {
	
	@Column(nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "sport_id")
	private Sport sport;
}
