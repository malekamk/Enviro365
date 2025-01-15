package com.enviro.assessment.grad001.kganyamaleka.DTO;

import com.enviro.assessment.grad001.kganyamaleka.entities.RecyclingTip;
import com.enviro.assessment.grad001.kganyamaleka.entities.WasteCategory;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * {@code WasteCategoryDTO} is a Data Transfer Object (DTO) representing a waste category
 * and its associated data. This class is used to transfer data between the application layers
 * and avoids exposing the full entity structure.
 *
 * <p>It includes basic details about the waste category such as its name, description,
 * creation time, and associated recycling tips.</p>
 */

// The @Data annotation from Lombok automatically generates boilerplate code such as
// getters, setters, equals, hashCode, and toString methods for this class. This significantly
// reduces development time and improves code readability by eliminating repetitive code.
@Data
public class WasteCategoryDTO {

    /**
     * The name of the waste category (e.g., Plastic, Glass).
     */
    private String name;

    /**
     * The unique identifier of the waste category.
     */
    private Long id;

    /**
     * A brief description of the waste category.
     */
    private String description;

    /**
     * The timestamp indicating when the waste category was created.
     */
    private LocalDateTime creationTime;

    /**
     * A list of recycling tips associated with the waste category.
     */
    private List<String> recyclingTips;

    /**
     * Constructs a {@code WasteCategoryDTO} from a {@link WasteCategory} entity.
     *
     * <p>This constructor maps the fields of the entity to the DTO. If the entity or its fields
     * are null, default values (e.g., empty strings or lists) are used to prevent null pointer exceptions.</p>
     *
     * @param category the {@link WasteCategory} entity to be transformed into a DTO
     */
    public WasteCategoryDTO(WasteCategory category) {
        this.name = category.getName();
        this.id = category.getId();
        this.creationTime = category.getCreated();
        // Handle potential null values for description
        this.description = category != null ? category.getDescription() : null;
        // Extract recycling tips or initialize with an empty list if null
        this.recyclingTips = (category != null && category.getRecyclingTips() != null) ?
                category.getRecyclingTips()
                        .stream()
                        .map(RecyclingTip::getRecyclingTip)
                        .collect(Collectors.toList()) : new ArrayList<>();
    }
}
