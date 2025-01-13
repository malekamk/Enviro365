package com.enviro.assessment.grad001.kganyamaleka.services;

import com.enviro.assessment.grad001.kganyamaleka.DTO.WasteCategoryDTO;
import com.enviro.assessment.grad001.kganyamaleka.entities.WasteCategory;
import com.enviro.assessment.grad001.kganyamaleka.exceptions.ResourceNotFoundException;
import com.enviro.assessment.grad001.kganyamaleka.repository.WasteCategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing waste categories.
 * Provides business logic for interacting with the waste category repository.
 */
@Service
@Transactional
public class WasteCategoryService {

    private final WasteCategoryRepository repository;

    // Constructor injection for better testability
    public WasteCategoryService(WasteCategoryRepository repository) {
        this.repository = repository;
    }

    /**
     * Retrieves all waste categories.
     * @return a list of all waste categories.
     */
    public List<WasteCategoryDTO> getAllCategories() {
        return repository.findAll().stream()
                .map(WasteCategoryDTO::new)  // Convert WasteCategory to WasteCategoryDTO
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a waste category by its ID.
     * @param id the ID of the waste category.
     * @return the WasteCategoryDTO.
     * @throws ResourceNotFoundException if the category is not found.
     */
    public WasteCategoryDTO getById(Long id) {
        WasteCategory category = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste category with ID " + id + " not found."));
        return new WasteCategoryDTO(category);  // Return DTO
    }

    /**
     * Adds a new waste category.
     * @param category the waste category to be added.
     * @return the saved WasteCategoryDTO.
     */
    public WasteCategoryDTO addCategory(WasteCategory category) {
        WasteCategory savedCategory = repository.save(category);
        return new WasteCategoryDTO(savedCategory);  // Return DTO instead of entity
    }

    /**
     * Retrieves the total number of waste categories.
     * @return the count of all waste categories.
     */
    public Long numberOfCategories() {
        return repository.count();
    }

    /**
     * Deletes a waste category by its ID.
     * @param id the ID of the waste category to be deleted.
     * @throws ResourceNotFoundException if the category is not found.
     */
    public void deleteCategoryByID(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Cannot delete. Waste category with ID " + id + " not found.");
        }
        repository.deleteById(id);
    }
}
