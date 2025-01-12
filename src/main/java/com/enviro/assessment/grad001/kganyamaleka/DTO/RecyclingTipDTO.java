package com.enviro.assessment.grad001.kganyamaleka.DTO;

import com.enviro.assessment.grad001.kganyamaleka.entities.RecyclingTip;
import com.enviro.assessment.grad001.kganyamaleka.entities.WasteCategory;
import lombok.Data;

import java.util.List;

@Data
public class RecyclingTipDTO {
    private String recyclingTip;
    private WasteCategory category;

    // Constructor to map from entity
    public RecyclingTipDTO(RecyclingTip recyclingTip) {
        this.recyclingTip = recyclingTip.getTip();
        this.category = recyclingTip.getCategory() ;
    }

    @Override
    public String toString() {
        return "RecyclingTip{" +
                "tip='" + recyclingTip + '\'' +
                ", Category='" + category + '\'' +
                '}';
    }
}
