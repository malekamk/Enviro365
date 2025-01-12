package com.enviro.assessment.grad001.kganyamaleka.repository;

import com.enviro.assessment.grad001.kganyamaleka.entities.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for managing RecyclingTip entities.
 * Provides methods for performing CRUD operations on RecyclingTip objects.
 */
public interface WasteTipRepository extends JpaRepository<RecyclingTip, Long> {
    // JpaRepository already provides methods like save(), findById(), findAll(), deleteById() for CRUD operations.
    /**
     * Finds recycling tips by the category ID.
     * @param categoryID the ID of the category.
     * @return a list of recycling tips for the specified category.
     */
    List<RecyclingTip> findByCategoryId(Long categoryID);

}

