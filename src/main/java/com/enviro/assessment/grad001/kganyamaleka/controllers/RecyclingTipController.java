package com.enviro.assessment.grad001.kganyamaleka.controllers;

import com.enviro.assessment.grad001.kganyamaleka.DTO.RecyclingTipDTO;
import com.enviro.assessment.grad001.kganyamaleka.entities.RecyclingTip;
import com.enviro.assessment.grad001.kganyamaleka.services.RecyclingTipService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing recycling tips in the application.
 * Provides endpoints to retrieve and add recycling tips.
 */
@RestController
@RequestMapping("/api/tips")
@Validated
public class RecyclingTipController {

    private final RecyclingTipService recyclingTipService;

    // Constructor-based injection
    public RecyclingTipController(RecyclingTipService recyclingTipService) {
        this.recyclingTipService = recyclingTipService;
    }

    /**
     * Retrieves a list of all recycling tips.
     *
     * @return ResponseEntity containing a list of all recycling tips.
     */

    @GetMapping
    public ResponseEntity<List<RecyclingTipDTO>> getAllTips() {
        List<RecyclingTipDTO> tips = recyclingTipService.getAllTips();
        return ResponseEntity.ok(tips);
    }

    /**
     * Retrieves recycling tips by category ID.
     *
     * @param id the ID of the category.
     * @return ResponseEntity containing a list of recycling tips for the specified category.
     */

    @GetMapping("/category/{id}")
    public ResponseEntity<List<RecyclingTipDTO>> getByCategoryId(@PathVariable Long id) {
        List<RecyclingTipDTO> tips = recyclingTipService.getTipByCategoryId(id);
        if (tips.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tips);
    }

    /**
     * Adds a new recycling tip.
     *
     * @param addedTip the recycling tip to be added.
     * @return ResponseEntity containing the saved recycling tip.
     */
    @PostMapping
    public ResponseEntity<RecyclingTipDTO> addTip(@Valid @RequestBody RecyclingTip addedTip) {
        RecyclingTipDTO recyclingTipDTO = recyclingTipService.addTip(addedTip);
        return ResponseEntity.status(201).body(recyclingTipDTO);
    }
}
