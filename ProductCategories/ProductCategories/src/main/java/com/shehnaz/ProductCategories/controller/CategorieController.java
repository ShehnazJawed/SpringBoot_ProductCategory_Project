package com.shehnaz.ProductCategories.controller;

import com.shehnaz.ProductCategories.Exception.CategoryAlreadyExistException;
import com.shehnaz.ProductCategories.dto.CategorieDTO;
import com.shehnaz.ProductCategories.service.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping
    public List<CategorieDTO> getAllCateqories(){
             return categorieService.getAllCateqorie();
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategorieDTO categorieDTO){
            CategorieDTO saveCategory=categorieService.createCategory(categorieDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(saveCategory);
    }

    @GetMapping("/{id}")
    public CategorieDTO getCategorieById(@PathVariable Long id){
        return categorieService.getCategoryById(id);
    }
    @DeleteMapping("{id}")
    public String deleteCategory(@PathVariable Long id){
        return categorieService.deleteCategory(id);
    }
}
