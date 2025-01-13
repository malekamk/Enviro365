package com.enviro.assessment.grad001.kganyamaleka.DTO;

import com.enviro.assessment.grad001.kganyamaleka.entities.RecyclingTip;
import lombok.Data;


@Data
public class RecyclingTipDTO {

    private String recyclingTip;

    public RecyclingTipDTO(RecyclingTip recyclingTip) {
        this.recyclingTip = recyclingTip.getTip();

    }
}
