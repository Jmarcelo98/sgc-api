package com.jmsports.sgcapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromotionDTO {

    private Double percent;

    private int durationPromotion;

    private Boolean isActive;

}
