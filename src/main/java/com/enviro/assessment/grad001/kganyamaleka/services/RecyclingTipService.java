package com.enviro.assessment.grad001.kganyamaleka.services;

import com.enviro.assessment.grad001.kganyamaleka.DTO.RecyclingTipDTO;
import com.enviro.assessment.grad001.kganyamaleka.entities.RecyclingTip;
import com.enviro.assessment.grad001.kganyamaleka.repository.RecyclingTipRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing recycling tips.
 * Handles the business logic for retrieving, adding, and managing recycling tips.
 */
@Service
public class RecyclingTipService {

    private final RecyclingTipRepository repository;

    /**
     * Constructor for dependency injection.
     *
     * @param repository the RecyclingTipRepository for interacting with the database.
     */
    public RecyclingTipService(RecyclingTipRepository repository) {
        this.repository = repository;
    }

    /**
     * Retrieves a list of all recycling tips.
     *
     * @return a list of RecyclingTipDTO objects representing all recycling tips in the database.
     */
    public List<RecyclingTipDTO> getAllTips() {
        return repository.findAll().stream()
                .map(RecyclingTipDTO::new)  // Convert RecyclingTip entity to RecyclingTipDTO
                .collect(Collectors.toList());
    }

    /**
     * Adds a new recycling tip to the database.
     *
     * @param tip the RecyclingTip entity to be saved.
     * @return a RecyclingTipDTO representing the saved recycling tip.
     */
    @Transactional
    public RecyclingTipDTO addTip(RecyclingTip tip) {
        RecyclingTip savedTip = repository.save(tip);
        return new RecyclingTipDTO(savedTip);  // Convert the saved entity to DTO
    }

    /**
     * Retrieves recycling tips based on a specific waste category ID.
     *
     * @param id the ID of the waste category.
     * @return a list of RecyclingTipDTO objects associated with the given category ID.
     */
    public List<RecyclingTipDTO> getTipByCategoryId(Long id) {
        List<RecyclingTip> tips = repository.findByCategoryId(id);
        return tips.stream()
                .map(RecyclingTipDTO::new)  // Convert RecyclingTip entities to RecyclingTipDTOs
                .collect(Collectors.toList());
    }
}
