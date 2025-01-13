package com.enviro.assessment.grad001.kganyamaleka.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


/**
 * Represents a recycling tip that provides guidance for proper waste disposal and recycling.
 * Each tip is associated with a specific waste category.
 */
@Entity
@Data
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * The content of the recycling tip.
     * Example: "Always rinse bottles before recycling."
     */
    @NotBlank(message = "Recycling tip can not be blank")
    @Size(max = 100, message = "Recycling  tip must not exceed 100 characters")
    private String RecyclingTip;
    /**
     * The waste category to which this tip belongs.
     * This creates a many-to-one relationship, meaning multiple tips can belong to one waste category.
     */
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference
    private WasteCategory category;

}
