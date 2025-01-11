package com.enviro.assessment.grad001.kganyamaleka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing recycling tips.
 * Provides business logic for interacting with the recycling tip repository.
 */
@Service
public class RecyclingTipService {

    @Autowired
    private WasteTipRepository wasteTipRepository;

    /**
     * Retrieves a list of all recycling tips.
     * @return a list of all recycling tips.
     */
    public List<RecyclingTip> getAllWasteTips() {
        return wasteTipRepository.findAll();
    }

    /**
     * Adds a new recycling tip.
     * @param tip the recycling tip to be added.
     * @return the saved recycling tip.
     */
    public RecyclingTip addRecyclingTip(RecyclingTip tip) {
        return wasteTipRepository.save(tip);
    }

    /**
     * Deletes a recycling tip by its ID.
     * @param id the ID of the recycling tip to be deleted.
     */
    public void updateRecyclingTip(Long id){
        wasteTipRepository.deleteById(id);
    }
}
