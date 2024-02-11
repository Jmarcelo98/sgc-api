package com.jmsports.sgcapi.model.dto;

import com.jmsports.sgcapi.enums.EnumSize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShirtStockSizeDTO {

    private Integer stock;
    private EnumSize enumId;
    private Integer shirtId;


}
