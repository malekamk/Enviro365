package com.enviro.assessment.grad001.kganyamaleka.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


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
    private String tip;
    /**
     * The waste category to which this tip belongs.
     * This creates a many-to-one relationship, meaning multiple tips can belong to one waste category.
     */
    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference
    private WasteCategory category;

}
