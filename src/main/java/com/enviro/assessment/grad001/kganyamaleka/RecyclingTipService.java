package com.enviro.assessment.grad001.kganyamaleka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTipService {

    @Autowired
    private WasteTipRepository wasteTipRepository;

    public List<RecyclingTip> getAllWasteTips() {
        return wasteTipRepository.findAll();
    }
    public RecyclingTip addRecyclingTip(RecyclingTip tip) {
        return wasteTipRepository.save(tip);
    }
    public void updateRecyclingTip(Long id){
        wasteTipRepository.deleteById(id);
    }
}
