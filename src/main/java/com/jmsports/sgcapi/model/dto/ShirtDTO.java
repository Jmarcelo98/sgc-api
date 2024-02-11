package com.jmsports.sgcapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShirtDTO {

    private String description;
    private Double price;
    private Boolean hasPromotion;
    private Integer promotionId;
}
