package com.enviro.assessment.grad001.kganyamaleka.DTO;

import com.enviro.assessment.grad001.kganyamaleka.entities.RecyclingTip;
import lombok.Data;

/**
 * {@code RecyclingTipDTO} is a Data Transfer Object (DTO) that represents a simplified
 * view of the {@link RecyclingTip} entity for transferring data between the server
 * and client or across application layers.
 * <p>
 * This class contains only the fields required for the client or external systems
 * and avoids exposing the full entity structure.
 */

// The @Data annotation from Lombok automatically generates boilerplate code such as
// getters, setters, equals, hashCode, and toString methods for this class. This significantly
// reduces development time and improves code readability by eliminating repetitive code.

@Data
public class RecyclingTipDTO {

    /**
     * A tip or suggestion related to recycling practices.
     */
    private String recyclingTip;

    /**
     * The category to which the recycling tip belongs (e.g., Plastic, Glass).
     */
    private String category;

    /**
     * Constructs a {@code RecyclingTipDTO} from a {@link RecyclingTip} entity.
     * <p>
     * This constructor maps the fields of the entity to the DTO.
     *
     * @param recyclingTip the {@link RecyclingTip} entity to be transformed into a DTO
     */
    public RecyclingTipDTO(RecyclingTip recyclingTip) {
        this.recyclingTip = recyclingTip.getRecyclingTip();
        // Extract category name if the category is not null; otherwise, use an empty string.
        this.category = recyclingTip.getCategory() != null ? recyclingTip.getCategory().getName() : "";
    }
}
