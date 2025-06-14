package com.enviro.assessment.grad001.kganyamaleka.controllers;

import com.enviro.assessment.grad001.kganyamaleka.DTO.WasteCategoryDTO;
import com.enviro.assessment.grad001.kganyamaleka.entities.WasteCategory;
import com.enviro.assessment.grad001.kganyamaleka.exceptions.DuplicateEntryException;
import com.enviro.assessment.grad001.kganyamaleka.exceptions.InvalidDataException;
import com.enviro.assessment.grad001.kganyamaleka.exceptions.ResourceNotFoundException;
import com.enviro.assessment.grad001.kganyamaleka.services.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing waste categories in the application.
 * Provides endpoints to retrieve, add, and delete waste categories.
 */
@RestController
@RequestMapping("/api/waste/categories")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService services;

    /**
     * Retrieves a list of all waste categories.
     * @return a list of all waste categories.
     */
    @GetMapping
    public ResponseEntity<List<WasteCategoryDTO>> getCategories() {
        try {
            return ResponseEntity.ok(services.getAllCategories());
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve categories");
        }
    }


    /**
     * Deletes a waste category by its ID.
     * @param id the ID of the waste category to be deleted.
     * @return a ResponseEntity with no content (HTTP 204) indicating successful deletion.
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        try {
            WasteCategoryDTO category = services.getById(id);
            if (category != null) {
                services.deleteCategoryByID(id);
                return ResponseEntity.noContent().build();
            } else {
                throw new ResourceNotFoundException("Category with ID " + id + " not found.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete category");
        }
    }


    /**
     * Endpoint to update a waste category.
     *
     * @param id       the ID of the waste category to update.
     * @param category the updated waste category data.
     * @return the updated WasteCategoryDTO.
     */

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategoryDTO> updateCategory( @PathVariable Long id, @RequestBody WasteCategory category) throws ResourceNotFoundException {
        try {
            WasteCategoryDTO updatedCategory = services.updateCategory(id, category);
            return ResponseEntity.ok(updatedCategory);
        } catch (InvalidDataException e) {
            throw new InvalidDataException("Invalid data provided for category update.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to update category");
        }
    }


    /**
     * Adds a new waste category.
     * @param category the waste category to be added.
     * @return a ResponseEntity containing the saved wiaste category.
     */

    @PostMapping
    public ResponseEntity<WasteCategoryDTO> saveCategory(@Valid @RequestBody WasteCategory category) {
        try {
            WasteCategoryDTO savedCategoryDTO = services.addCategory(category);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCategoryDTO);
        } catch (DuplicateEntryException e) {
            throw new InvalidDataException("Category already exists.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to save category");
        }
    }



}
