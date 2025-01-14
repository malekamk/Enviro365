package com.enviro.assessment.grad001.kganyamaleka.controllers;

import com.enviro.assessment.grad001.kganyamaleka.DTO.WasteCategoryDTO;
import com.enviro.assessment.grad001.kganyamaleka.entities.WasteCategory;
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
    public List<WasteCategoryDTO> getCategories(){
        return services.getAllCategories();
    }

    /**
     * Deletes a waste category by its ID.
     * @param id the ID of the waste category to be deleted.
     * @return a ResponseEntity with no content (HTTP 204) indicating successful deletion.
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        WasteCategoryDTO category = services.getById(id);
        if (category != null) {
            services.deleteCategoryByID(id);
            return ResponseEntity.noContent().build();  // Successfully deleted
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // Resource not found
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
    public WasteCategoryDTO updateCategory(@PathVariable Long id, @RequestBody WasteCategory category) {
        return services.updateCategory(id, category);
    }

    /**
     * Adds a new waste category.
     * @param category the waste category to be added.
     * @return a ResponseEntity containing the saved waste category.
     */

    @PostMapping
    public ResponseEntity<WasteCategoryDTO> saveCategory(@Valid @RequestBody WasteCategory category) {
        WasteCategoryDTO savedCategoryDTO = services.addCategory(category);  // Get the DTO from the service
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategoryDTO);  // Return DTO with 201 status
    }


}
