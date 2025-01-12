package com.enviro.assessment.grad001.kganyamaleka.controllers;

import com.enviro.assessment.grad001.kganyamaleka.DTO.RecyclingTipDTO;
import com.enviro.assessment.grad001.kganyamaleka.services.RecyclingTipService;
import com.enviro.assessment.grad001.kganyamaleka.entities.RecyclingTip;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing recycling tips in the application.
 * Provides endpoints to retrieve and add recycling tips.
 */
@RestController
@RequestMapping("/api/tips")
public class RecyclingTipController {

    @Autowired
    private RecyclingTipService recyclingTipService;

    /**
     * Retrieves a list of all recycling tips.
     * @return a list of all recycling tips.
     */
    @GetMapping
    public List<RecyclingTipDTO> getAllTips(){
        return recyclingTipService.getAllTips();
    }

    @GetMapping("category/{id}")
    public List<RecyclingTipDTO> getByCategoryId(@PathVariable Long id){
        return recyclingTipService.getTipByCategoryId(id);
    }

    /**
     * Adds a new recycling tip.
     * @param addedTip the recycling tip to be added.
     * @return a ResponseEntity containing the saved recycling tip.
     */
    @PostMapping
    public ResponseEntity<RecyclingTipDTO>  addTip(@Valid @RequestBody RecyclingTip addedTip){
        RecyclingTipDTO recyclingTipDTO = recyclingTipService.addTip(addedTip);
        return ResponseEntity.status(HttpStatus.CREATED).body(recyclingTipDTO);
    }
}
