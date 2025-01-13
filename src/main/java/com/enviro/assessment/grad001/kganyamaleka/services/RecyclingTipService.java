package com.enviro.assessment.grad001.kganyamaleka.services;

import com.enviro.assessment.grad001.kganyamaleka.DTO.RecyclingTipDTO;
import com.enviro.assessment.grad001.kganyamaleka.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.kganyamaleka.entities.RecyclingTip;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing recycling tips.
 * Provides business logic for interacting with the recycling tip repository.
 */
@Service
public class RecyclingTipService {

    @Autowired
    private RecyclingTipRepository repository;

    /**
     * Retrieves a list of all recycling tips.
     * @return a list of all recycling tips.
     */
    public List<RecyclingTipDTO> getAllTips() {
        return repository.findAll().stream()
                .map(RecyclingTipDTO::new)  // Convert RecyclingTip to RecyclingTipDTO
                .collect(Collectors.toList());
    }

    /**
     * Adds a new recycling tip.
     * @param tip the recycling tip to be added.
     * @return the saved recycling tip.
     */
    @Transactional
    public RecyclingTipDTO addTip(RecyclingTip tip) {
        RecyclingTip savedTip = repository.save(tip);
        return new RecyclingTipDTO(savedTip);  // Return DTO instead of entity
    }

    /**
     * Retrieves recycling tips based on the category ID.
     * @param id the ID of the category.
     * @return a list of recycling tips for the given category.
     */
    public List<RecyclingTipDTO> getTipByCategoryId(Long id) {
        List<RecyclingTip> tips = repository.findByCategoryId(id);
        return tips.stream()
                .map(RecyclingTipDTO::new)  // Convert RecyclingTip to RecyclingTipDTO
                .collect(Collectors.toList());
    }

}
