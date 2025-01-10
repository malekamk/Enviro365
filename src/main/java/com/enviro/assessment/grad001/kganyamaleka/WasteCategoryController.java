package com.enviro.assessment.grad001.kganyamaleka;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waste/categories")
public class WasteCategoryController {

    @Autowired
    private CategoryService services;

    @GetMapping
    public List<WasteCategory> getCategories(){
        return services.getAllCategories();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        services.deleteCategoryByID(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<WasteCategory> saveCategory(@Valid @RequestBody WasteCategory category){
        return ResponseEntity.ok(services.addCategory(category));
    }

}
