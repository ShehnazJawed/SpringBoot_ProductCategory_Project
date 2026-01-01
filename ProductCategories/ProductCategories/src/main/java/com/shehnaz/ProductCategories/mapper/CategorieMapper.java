package com.shehnaz.ProductCategories.mapper;

import com.shehnaz.ProductCategories.dto.CategorieDTO;
import com.shehnaz.ProductCategories.entity.CategorieEntity;

public class CategorieMapper {

    public static CategorieEntity toCategoryEntity(CategorieDTO categorieDTO){

        CategorieEntity categorie=new CategorieEntity();
        categorie.setName(categorieDTO.getName());
        return categorie;
    }

    public static CategorieDTO toCategoryDTO(CategorieEntity categorieEntity){

        if(categorieEntity==null){
            return null;
        }
        CategorieDTO categorieDTO=new CategorieDTO();
        categorieDTO.setId(categorieEntity.getId());
        categorieDTO.setName(categorieEntity.getName());
        categorieDTO.setProducts(categorieEntity.getProducts().stream().map(ProductMapper::toproductDTO).toList());
        return categorieDTO;
    }
}
