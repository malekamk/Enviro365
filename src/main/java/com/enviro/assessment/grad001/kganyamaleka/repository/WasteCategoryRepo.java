package com.enviro.assessment.grad001.kganyamaleka.repository;

import com.enviro.assessment.grad001.kganyamaleka.entities.RecyclingTip;
import com.enviro.assessment.grad001.kganyamaleka.entities.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for managing RecyclingTip entities.
 * Provides methods for performing CRUD operations on RecyclingTip objects.
 */
public interface WasteCategoryRepo extends JpaRepository<WasteCategory,Long> {
    // JpaRepository already provides methods like save(), findById(), findAll(), deleteById() for CRUD operations.
}
