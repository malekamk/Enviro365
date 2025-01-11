package com.enviro.assessment.grad001.kganyamaleka;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tips")
public class RecyclingTipController {

    @Autowired
    private RecyclingTipService recyclingTipService;

    @GetMapping
    public List<RecyclingTip> getAllTips(){
        return recyclingTipService.getAllWasteTips();
    }

    @PostMapping
    public ResponseEntity<RecyclingTip>  addTip(@Valid @RequestBody RecyclingTip addedTip){
        return ResponseEntity.ok(recyclingTipService.addRecyclingTip(addedTip));

    }
}
