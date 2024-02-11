package com.jmsports.sgcapi.controllers;

import com.jmsports.sgcapi.model.dto.ShirtDTO;
import com.jmsports.sgcapi.model.entities.Shirt;
import com.jmsports.sgcapi.services.ShirtService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shirts")
@AllArgsConstructor
public class ShirtController {

    private final ShirtService shirtService;

    @PostMapping
    public ResponseEntity<Shirt> create(@RequestBody ShirtDTO shirtDTO) {
        return ResponseEntity.ok(shirtService.create(shirtDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shirt> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(shirtService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shirt> update(@PathVariable Integer id, @RequestBody ShirtDTO shirtDTO) {
        return ResponseEntity.ok(shirtService.update(id, shirtDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Shirt> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(shirtService.delete(id));
    }
    @GetMapping
    public Page<Shirt> getAll(Pageable pageable) {
        return shirtService.getAll(pageable);
    }
}
