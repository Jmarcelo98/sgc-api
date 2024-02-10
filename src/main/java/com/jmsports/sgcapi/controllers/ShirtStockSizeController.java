package com.jmsports.sgcapi.controllers;

import com.jmsports.sgcapi.enums.EnumSize;
import com.jmsports.sgcapi.model.dto.ShirtStockSizeDTO;
import com.jmsports.sgcapi.model.entities.ShirtStockSize;
import com.jmsports.sgcapi.services.ShirtStockSizeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sizes")
@AllArgsConstructor
public class ShirtStockSizeController {

    private ShirtStockSizeService shirtStockSizeService;

    @PostMapping
    private ResponseEntity<ShirtStockSize> create(@RequestBody ShirtStockSizeDTO shirtStockSizeDTO) {
        return ResponseEntity.ok(shirtStockSizeService.createShirtStockSize(shirtStockSizeDTO));
    }

    @GetMapping("/{id}")
    private ResponseEntity<ShirtStockSize> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(shirtStockSizeService.getById(id));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ShirtStockSize> delete(@PathVariable Integer id) {
        shirtStockSizeService.deleteShirtStockSize(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    private ResponseEntity<ShirtStockSize> update(@PathVariable Integer id, @RequestBody ShirtStockSizeDTO shirtStockSizeDTO) {
        return ResponseEntity.ok(shirtStockSizeService.updateShirtStockSize(id, shirtStockSizeDTO));
    }
}
