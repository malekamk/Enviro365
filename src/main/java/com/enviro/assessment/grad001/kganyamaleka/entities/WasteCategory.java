package com.enviro.assessment.grad001.kganyamaleka.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data  // Lombok annotation to generate getters, setters, toString, equals, and hashCode
public class WasteCategory {

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime created;


    @NotBlank(message = "name can not be blank")
    private String name;

    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecyclingTip> recyclingTips = new ArrayList<>();

    /**
     * The unique identifier for the waste category.
     * It is auto-generated by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Sets the list of recycling tips associated with this waste category.
     * Ensures bidirectional consistency by setting the category reference
     * in each recycling tip.
     *
     * @param recyclingTips the list of recycling tips to associate with this category.
     *                      Can be null, in which case no tips are associated.
     */
    public void setRecyclingTips(List<RecyclingTip> recyclingTips) {
        this.recyclingTips = recyclingTips;
        // Ensure bidirectional relationship consistency
        if (recyclingTips != null) {
            for (RecyclingTip tip : recyclingTips) {
                tip.setCategory(this); // Set the category reference for each tip
            }
        }
    }

}
