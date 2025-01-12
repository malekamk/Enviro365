package com.enviro.assessment.grad001.kganyamaleka.repository;

import com.enviro.assessment.grad001.kganyamaleka.entities.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing RecyclingTip entities.
 * Provides methods for performing CRUD operations on RecyclingTip objects.
 */
public interface WasteTipRepository extends JpaRepository<RecyclingTip, Long> {
    // JpaRepository already provides methods like save(), findById(), findAll(), deleteById() for CRUD operations.
}
