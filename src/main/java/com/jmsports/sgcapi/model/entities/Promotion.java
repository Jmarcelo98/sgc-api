package com.jmsports.sgcapi.model.entities;

import java.time.LocalDate;

import javax.persistence.Entity;

import com.jmsports.sgcapi.generics.GenericEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Promotion extends GenericEntity {

    private Double percent;

    private LocalDate endDate;

}
