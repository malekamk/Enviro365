package com.enviro.assessment.grad001.kganyamaleka.services;

import com.enviro.assessment.grad001.kganyamaleka.DTO.WasteCategoryDTO;
import com.enviro.assessment.grad001.kganyamaleka.entities.WasteCategory;
import com.enviro.assessment.grad001.kganyamaleka.repository.WasteCategoryRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing waste categories.
 * Provides business logic for interacting with the waste category repository.
 */
@Service
public class CategoryService {

    @Autowired
    private WasteCategoryRepo repository;

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
     * @return an Optional containing the waste category, or empty if not found.
     */
    public WasteCategoryDTO getById(Long id) {
        WasteCategory category = repository.findById(id)
                .orElse(null);  // Return null if not found
        if (category != null) {
            return new WasteCategoryDTO(category);  // Return DTO if found
        } else {
            return null;  // Return null if not found
        }
    }


    /**
     * Adds a new waste category.
     * @param category the waste category to be added.
     * @return the saved waste category.
     */
    @Transactional
    public WasteCategoryDTO addCategory(WasteCategory category) {
        WasteCategory savedCategory = repository.save(category);
        return new WasteCategoryDTO(savedCategory);  // Return DTO instead of entity
    }

    /**
     * Retrieves the total number of waste categories.
     * @return the count of all waste categories.
     */
    public Long numberOfCategories(){
        return repository.count();
    }

    /**
     * Deletes a waste category by its ID.
     * @param id the ID of the waste category to be deleted.
     */
    @Transactional
    public void deleteCategoryByID(Long id){
        repository.deleteById(id);
    }
}
