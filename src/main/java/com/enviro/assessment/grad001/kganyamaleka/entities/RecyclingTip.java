package com.enviro.assessment.grad001.kganyamaleka.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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
    private String tip;
    /**
     * The waste category to which this tip belongs.
     * This creates a many-to-one relationship, meaning multiple tips can belong to one waste category.
     */
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference
    private WasteCategory category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public WasteCategory getCategory() {
        return category;
    }

    public void setCategory(WasteCategory wasteCategory) {
        this.category = wasteCategory;
    }
}
