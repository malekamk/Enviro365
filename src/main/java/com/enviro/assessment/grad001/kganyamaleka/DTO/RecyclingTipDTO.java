package com.enviro.assessment.grad001.kganyamaleka.DTO;

import com.enviro.assessment.grad001.kganyamaleka.entities.RecyclingTip;
import lombok.Data;


@Data
public class RecyclingTipDTO {

    private String recyclingTip;
    private String category;

    public RecyclingTipDTO(RecyclingTip recyclingTip) {
        this.recyclingTip = recyclingTip.getRecyclingTip();
        this.category = recyclingTip.getCategory()!= null? recyclingTip.getCategory().getName(): "";


    }
}
