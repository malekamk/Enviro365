package com.enviro.assessment.grad001.kganyamaleka;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    private CategoryService services;

    /**
     * Retrieves a list of all waste categories.
     * @return a list of all waste categories.
     */
    @GetMapping
    public List<WasteCategory> getCategories(){
        return services.getAllCategories();
    }

    /**
     * Deletes a waste category by its ID.
     * @param id the ID of the waste category to be deleted.
     * @return a ResponseEntity with no content (HTTP 204) indicating successful deletion.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        services.deleteCategoryByID(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Adds a new waste category.
     * @param category the waste category to be added.
     * @return a ResponseEntity containing the saved waste category.
     */
    @PostMapping
    public ResponseEntity<WasteCategory> saveCategory(@Valid @RequestBody WasteCategory category){
        return ResponseEntity.ok(services.addCategory(category));
    }

}
