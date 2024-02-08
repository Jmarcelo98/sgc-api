package com.jmsports.sgcapi.controllers;

import com.jmsports.sgcapi.model.dto.PromotionDTO;
import com.jmsports.sgcapi.model.entities.Promotion;
import com.jmsports.sgcapi.services.PromotionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/promotions")
@AllArgsConstructor
public class PromotionController {

    private PromotionService promotionService;

    @PostMapping
    private ResponseEntity<Promotion> create(@RequestBody PromotionDTO promotionDTO) {
        return ResponseEntity.ok(promotionService.create(promotionDTO));
    }

    @PutMapping("/{id}")
    private ResponseEntity<Promotion> update(@PathVariable Integer id, @RequestBody PromotionDTO promotionDTO) {
        return ResponseEntity.ok(promotionService.update(id, promotionDTO));
    }
    @GetMapping("/{id}")
    private ResponseEntity<Promotion> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(promotionService.getById(id));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Promotion> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(promotionService.delete(id));
    }

    @GetMapping
    private Page<Promotion> getAll(Pageable pageable) {
        return promotionService.getAll(pageable);
    }

    @GetMapping("/active/{isActive}")
    private Page<Promotion> getAllActive(@PathVariable Boolean isActive, Pageable pageable) {
        return promotionService.getAllActive(isActive, pageable);
    }

}
