package com.jmsports.sgcapi.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jmsports.sgcapi.enums.EnumSize;
import com.jmsports.sgcapi.generics.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ShirtStockSize extends GenericEntity {

    private Integer stock;

    private Integer enumId;

    @JsonIgnore
    private Boolean isActive;

    @JsonIgnore
    private LocalDateTime dateCreated;

    @JsonIgnore
    private LocalDateTime dateUpdate;

}
