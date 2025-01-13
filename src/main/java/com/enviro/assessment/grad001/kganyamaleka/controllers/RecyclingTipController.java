package com.enviro.assessment.grad001.kganyamaleka.controllers;

import com.enviro.assessment.grad001.kganyamaleka.DTO.RecyclingTipDTO;
import com.enviro.assessment.grad001.kganyamaleka.entities.RecyclingTip;
import com.enviro.assessment.grad001.kganyamaleka.services.RecyclingTipService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Get all recycling tips", description = "Retrieve a list of all recycling tips available in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of tips"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
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
    @Operation(summary = "Get tips by category ID", description = "Retrieve recycling tips associated with a specific waste category.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved tips for the category"),
            @ApiResponse(responseCode = "404", description = "Category not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
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
    @Operation(summary = "Add a new recycling tip", description = "Create a new recycling tip for a specific waste category.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Recycling tip to be added",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"tip\": \"Reuse glass jars as storage containers.\", \"categoryId\": 101}"),
                            schema = @Schema(implementation = RecyclingTip.class)
                    )
            ))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Recycling tip created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input or missing parameters"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<RecyclingTipDTO> addTip(@Valid @RequestBody RecyclingTip addedTip) {
        RecyclingTipDTO recyclingTipDTO = recyclingTipService.addTip(addedTip);
        return ResponseEntity.status(201).body(recyclingTipDTO);
    }
}
