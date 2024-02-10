package com.jmsports.sgcapi.services;

import com.jmsports.sgcapi.handlers.ResourceNotFoundException;
import com.jmsports.sgcapi.model.dto.PromotionDTO;
import com.jmsports.sgcapi.model.entities.Promotion;
import com.jmsports.sgcapi.repositories.PromotionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class PromotionService {

    PromotionRepository promotionRepository;

    public Promotion create(PromotionDTO promotionDTO) {
        Promotion promotion = new Promotion();
        int durationPromotion = promotionDTO.getDurationPromotion();
        LocalDate endDate = LocalDate.now().plusDays(durationPromotion);

        promotion.setPercent(promotionDTO.getPercent());
        promotion.setDateCreated(LocalDateTime.now());
        promotion.setIsActive(promotionDTO.getIsActive());

        if (!promotionDTO.getIsActive()) {
            promotion.setEndDate(null);
        }else {
            promotion.setEndDate(endDate);
        }

        return promotionRepository.save(promotion);
    }

    public Promotion getById(Integer id) {
        Promotion promotion = findById(id);
        return promotion;

    }
    public Promotion update(Integer id, PromotionDTO promotionDTO) {
        Promotion promotion = findById(id);

        int durationPromotion = promotionDTO.getDurationPromotion();
        LocalDate endDate = LocalDate.now().plusDays(durationPromotion);

        promotion.setPercent(promotionDTO.getPercent());
        promotion.setDateUpdate(LocalDateTime.now());
        promotion.setIsActive(promotionDTO.getIsActive());
        if (!promotionDTO.getIsActive()) {
            promotion.setEndDate(null);
        } else {
            promotion.setEndDate(endDate);
        }
        return promotionRepository.save(promotion);
    }

    public Promotion delete(Integer id) {
        Promotion promotion = findById(id);
        promotionRepository.delete(promotion);
        return promotion;
    }

    public Page<Promotion> getAll(Pageable pageable) {
        return promotionRepository.findAll(pageable);
    }

    public Page<Promotion> getAllActive(Boolean isActive, Pageable pageable) {
        return promotionRepository.findAllByIsActive(isActive, pageable);
    }

    private Promotion findById(Integer id) {
        return promotionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Erro ao encontrar uma Promotion com o id: [" + id + "] "));
    }

}
