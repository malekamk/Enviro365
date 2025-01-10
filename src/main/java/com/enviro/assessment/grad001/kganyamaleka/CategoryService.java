package com.enviro.assessment.grad001.kganyamaleka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private WasteCategoryRepo repository;

    public List<WasteCategory> getAllCategories(){
        return repository.findAll();
    }

    public Optional<WasteCategory> getById(Long id){
        return repository.findById(id);
    }

    public WasteCategory addCategory(WasteCategory category){
        return repository.save(category);
    }

    public Long numberOfCategories(){
        return repository.count();
    }

    public void deleteCategoryByID(Long id){
        repository.deleteById(id);
    }
}
