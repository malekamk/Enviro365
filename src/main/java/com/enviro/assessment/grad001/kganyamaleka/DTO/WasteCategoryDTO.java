package com.enviro.assessment.grad001.kganyamaleka.DTO;

import com.enviro.assessment.grad001.kganyamaleka.entities.RecyclingTip;
import com.enviro.assessment.grad001.kganyamaleka.entities.WasteCategory;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class WasteCategoryDTO {
        private String name;
        private Long id;
        private String description;
        private LocalDateTime creationTime;
        private List<String> recyclingTips;

        // Constructor to map from entity
        public WasteCategoryDTO(WasteCategory category) {
            this.name = category.getName();
            this.id = category.getId();
            this.creationTime = category.getCreated();
            this.description = category != null ? category.getDescription() : null;
            this.recyclingTips = (category != null && category.getRecyclingTips() != null) ?
                    category.getRecyclingTips()
                            .stream()
                            .map(RecyclingTip::getRecyclingTip)
                            .collect(Collectors.toList()) : new ArrayList<>();
        }

    }


