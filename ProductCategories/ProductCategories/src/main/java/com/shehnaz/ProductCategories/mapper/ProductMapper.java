package com.shehnaz.ProductCategories.mapper;

import com.shehnaz.ProductCategories.dto.ProductDTO;
import com.shehnaz.ProductCategories.entity.CategorieEntity;
import com.shehnaz.ProductCategories.entity.ProductEntity;

public class ProductMapper {

    public static ProductDTO toproductDTO(ProductEntity productEntity){

        return new ProductDTO(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice(),
                productEntity.getCategory().getId()
        );
    }
    public static ProductEntity toProductEntity(ProductDTO productDTO, CategorieEntity categorieEntity){

        ProductEntity productEntity=new ProductEntity();
        productEntity.setName(productDTO.getName());
        productEntity.setDescription(productDTO.getDescription());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setCategory(categorieEntity);
        return productEntity;
    }
}
