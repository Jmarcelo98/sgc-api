package com.jmsports.sgcapi.services;

import com.jmsports.sgcapi.handlers.ResourceNotFoundException;
import com.jmsports.sgcapi.model.dto.ShirtDTO;
import com.jmsports.sgcapi.model.entities.Shirt;
import com.jmsports.sgcapi.repositories.ShirtRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ShirtService {

    private final ShirtRepository shirtRepository;
    private final PromotionService promotionService;
    private final TeamService teamService;

    public Shirt create(ShirtDTO shirtDTO) {

        Shirt shirt = new Shirt();
        Boolean hasPromotion = shirtDTO.getHasPromotion();
        shirt.setDescription(shirtDTO.getDescription());
        shirt.setDateCreated(LocalDateTime.now());
        shirt.setDateUpdate(null);
        shirt.setHasPromotion(hasPromotion);
        shirt.setTeam(teamService.getById(shirtDTO.getTeamId()));

        ifHasPromotionIsTrueApplyPromotion(shirtDTO, hasPromotion, shirt);

        return shirtRepository.save(shirt);
    }

    public Shirt getById(Integer id) {
        Shirt shirt = findById(id);
        return shirt;
    }

    public Shirt update(Integer id, ShirtDTO shirtDTO) {
        Shirt shirt = findById(id);
        Boolean hasPromotion = shirtDTO.getHasPromotion();
        shirt.setDescription(shirtDTO.getDescription());
        shirt.setDateUpdate(LocalDateTime.now());
        shirt.setTeam(teamService.getById(shirtDTO.getTeamId()));

        ifHasPromotionIsTrueApplyPromotion(shirtDTO, hasPromotion, shirt);

        return shirtRepository.save(shirt);
    }

    public Shirt delete(Integer id) {
        Shirt shirt = findById(id);
        shirtRepository.delete(shirt);
        return shirt;
    }

    public Page<Shirt> getAll(Pageable pageable) {
        return shirtRepository.findAll(pageable);
    }

    private void ifHasPromotionIsTrueApplyPromotion(ShirtDTO shirtDTO, Boolean hasPromotion, Shirt shirt) {
        if (hasPromotion) {
            Double promotion = promotionService.getById(shirtDTO.getPromotionId()).getPercent();
            shirt.setPromotion(promotionService.getById(shirtDTO.getPromotionId()));
            shirt.setPrice(shirtDTO.getPrice() - (shirtDTO.getPrice() * promotion / 100));
        } else {
            shirt.setPrice(shirtDTO.getPrice());
            shirt.setPromotion(null);
            shirt.setHasPromotion(false);
        }
    }

    private Shirt findById(Integer id) {
        return shirtRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Erro ao encontrar uma Shirt com o id: [" + id + "] "));
    }


}
