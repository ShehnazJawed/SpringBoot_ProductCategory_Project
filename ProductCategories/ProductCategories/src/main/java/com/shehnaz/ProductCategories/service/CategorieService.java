package com.shehnaz.ProductCategories.service;

import com.shehnaz.ProductCategories.Exception.CategoryAlreadyExistException;
import com.shehnaz.ProductCategories.dto.CategorieDTO;
import com.shehnaz.ProductCategories.entity.CategorieEntity;
import com.shehnaz.ProductCategories.mapper.CategorieMapper;
import com.shehnaz.ProductCategories.repository.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategorieService {

    private CategorieRepository categorieRepository;
    public CategorieDTO createCategory(CategorieDTO categorieDTO){
        Optional<CategorieEntity> optionalCategorie=categorieRepository.findByName(categorieDTO.getName());
        if(optionalCategorie.isPresent()){
            throw new CategoryAlreadyExistException("Category "+categorieDTO.getName()+" already exist");
        }
        CategorieEntity categorie=CategorieMapper.toCategoryEntity(categorieDTO);
        categorie=categorieRepository.save(categorie);
        return CategorieMapper.toCategoryDTO(categorie);
    }

    public List<CategorieDTO> getAllCateqorie(){
        return categorieRepository.findAll().stream().map(CategorieMapper::toCategoryDTO).toList();
    }
    public CategorieDTO getCategoryById(Long id){
           CategorieEntity categorie=categorieRepository.findById(id).orElseThrow(()-> new RuntimeException("Category Not Found"));
           return CategorieMapper.toCategoryDTO(categorie);
    }

    public String deleteCategory(Long id){
        categorieRepository.deleteById(id);
        return "Category Successfully Deleted";
    }

}
