package com.enviro.assessment.grad001.kganyamaleka.services;

import com.enviro.assessment.grad001.kganyamaleka.DTO.WasteCategoryDTO;
import com.enviro.assessment.grad001.kganyamaleka.entities.WasteCategory;
import com.enviro.assessment.grad001.kganyamaleka.exceptions.ResourceNotFoundException;
import com.enviro.assessment.grad001.kganyamaleka.repository.WasteCategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

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
//        return repository.findAll().stream()
//                .map(WasteCategoryDTO::new)  // Convert WasteCategory to WasteCategoryDTO
//                .collect(Collectors.toList());
        List<WasteCategory> categories =  repository.findAll();

        List<WasteCategoryDTO> wasteCategoryDTOS = new ArrayList<>();
        for(WasteCategory category: categories){
            wasteCategoryDTOS.add(new WasteCategoryDTO(category));

        }
        return wasteCategoryDTOS;
    }

    /**
     * Retrieves a waste category by its ID.
     * @param id the ID of the waste category.
     * @return the WasteCategoryDTO.
     * @throws ResourceNotFoundException if the category is not found.
     */
    public WasteCategoryDTO getById(Long id) throws Exception {
        WasteCategory category = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste category with ID " + id + " not found."));
        return new WasteCategoryDTO(category);  // Return DTO
    }

    /**
     * Updates a waste category with new values.
     *
     * @param id       the ID of the waste category to update.
     * @param category the WasteCategory object containing updated fields.
     * @return the updated WasteCategoryDTO.
     * @throws ResourceNotFoundException if the category is not found.
     */
    public WasteCategoryDTO updateCategory(Long id, WasteCategory category) {

        WasteCategory updatedCategory = null;
        try{
        WasteCategory existingCategory = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste category with ID " + id + " not found."));

        if (category.getName() != null) {
            existingCategory.setName(category.getName());
        }
        existingCategory.setDescription(category.getDescription());

        // Update other fields if necessary

        updatedCategory = repository.save(existingCategory);}
        catch (ResourceNotFoundException e){

        }
        return new WasteCategoryDTO(updatedCategory);
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
            try {
                throw new ResourceNotFoundException("Cannot delete. Waste category with ID " + id + " not found.");
            } catch (ResourceNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        repository.deleteById(id);
    }
}
