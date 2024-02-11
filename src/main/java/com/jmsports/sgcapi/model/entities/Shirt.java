package com.jmsports.sgcapi.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jmsports.sgcapi.generics.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Shirt extends GenericEntity {

    private String description;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;
    private Boolean hasPromotion;


    @JsonIgnore
    private Boolean isActive;
}
