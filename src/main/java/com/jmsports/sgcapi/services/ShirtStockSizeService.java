package com.jmsports.sgcapi.services;

import com.jmsports.sgcapi.enums.EnumSize;
import com.jmsports.sgcapi.handlers.ResourceNotFoundException;
import com.jmsports.sgcapi.model.dto.ShirtStockSizeDTO;
import com.jmsports.sgcapi.model.entities.ShirtStockSize;
import com.jmsports.sgcapi.repositories.ShirtStockSizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class ShirtStockSizeService {

    private final ShirtStockSizeRepository shirtStockSizeRepository;
    private final ShirtService shirtService;

    public ShirtStockSize createShirtStockSize(ShirtStockSizeDTO shirtStockSizeDTO) {
        ShirtStockSize shirtStockSize = new ShirtStockSize();
        EnumSize enumSize = shirtStockSizeDTO.getEnumId();
        shirtStockSize.setStock(shirtStockSizeDTO.getStock());
        shirtStockSize.setShirt(shirtService.getById(shirtStockSizeDTO.getShirtId()));

        if (enumSize != null) {
            shirtStockSize.setEnumId(enumSize.getId());
        } else {
            shirtStockSize.setEnumId(null);
        }

        return shirtStockSizeRepository.save(shirtStockSize);
    }

    public void deleteShirtStockSize(Integer id) {
        ShirtStockSize shirtStockSize = findById(id);
        shirtStockSizeRepository.delete(shirtStockSize);
    }

    public ShirtStockSize getById(Integer id) {
        ShirtStockSize shirtStockSize = findById(id);
        return shirtStockSize;
    }

    public ShirtStockSize updateShirtStockSize(Integer id, ShirtStockSizeDTO shirtStockSizeDTO) {
        ShirtStockSize shirtStockSize = findById(id);
        EnumSize enumSize = shirtStockSizeDTO.getEnumId();
        shirtStockSize.setStock(shirtStockSizeDTO.getStock());

        if (enumSize != null) {
            shirtStockSize.setEnumId(enumSize.getId());
        } else {
            shirtStockSize.setEnumId(null);
        }

        return shirtStockSizeRepository.save(shirtStockSize);
    }
    private ShirtStockSize findById(Integer id) {
        return shirtStockSizeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Erro ao encontrar uma ShirtStockSize com o id: [" + id + "] "));
    }
}
