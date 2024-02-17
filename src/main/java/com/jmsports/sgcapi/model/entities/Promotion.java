package com.jmsports.sgcapi.model.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private int durationPromotion;

    @OneToMany(mappedBy = "promotion")
    @JsonIgnore
    private List<Shirt> shirts;

}
