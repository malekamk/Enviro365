package com.enviro.assessment.grad001.kganyamaleka.services;

import com.enviro.assessment.grad001.kganyamaleka.entities.WasteCategory;
import com.enviro.assessment.grad001.kganyamaleka.repository.WasteCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<WasteCategory> getAllCategories(){
        return repository.findAll();
    }

    /**
     * Retrieves a waste category by its ID.
     * @param id the ID of the waste category.
     * @return an Optional containing the waste category, or empty if not found.
     */
    public Optional<WasteCategory> getById(Long id){
        return repository.findById(id);
    }

    /**
     * Adds a new waste category.
     * @param category the waste category to be added.
     * @return the saved waste category.
     */
    public WasteCategory addCategory(WasteCategory category){
        return repository.save(category);
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
    public void deleteCategoryByID(Long id){
        repository.deleteById(id);
    }
}
