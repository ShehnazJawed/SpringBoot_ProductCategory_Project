package com.shehnaz.ProductCategories.service;


import com.shehnaz.ProductCategories.Exception.CategoryNotFoundException;
import com.shehnaz.ProductCategories.dto.ProductDTO;
import com.shehnaz.ProductCategories.entity.CategorieEntity;
import com.shehnaz.ProductCategories.entity.ProductEntity;
import com.shehnaz.ProductCategories.mapper.ProductMapper;
import com.shehnaz.ProductCategories.repository.CategorieRepository;
import com.shehnaz.ProductCategories.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {



    private ProductRepository productRepository;
    private CategorieRepository categorieRepository;

    public List<ProductDTO> getAllProduct(){
        return productRepository.findAll().stream().map(ProductMapper::toproductDTO).toList();
    }

    public ProductDTO getProductById(Long id){
        ProductEntity productEntity= productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product Not Found"));
        return ProductMapper.toproductDTO(productEntity);
    }
    public ProductDTO createProduct(ProductDTO productDTO){
       CategorieEntity categorie= categorieRepository.findById(productDTO.getCategoryId()).orElseThrow(()-> new CategoryNotFoundException("Category id"+productDTO.getCategoryId()+"not Found"));
        ProductEntity productEntity=ProductMapper.toProductEntity(productDTO,categorie);
        productEntity=productRepository.save(productEntity);
        // Return Entity to DTO
        return ProductMapper.toproductDTO(productEntity);
    }

    public ProductDTO updateProduct(Long id,ProductDTO productDTO){
        ProductEntity productEntity= productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product Not Found"));
        CategorieEntity categorieEntity=categorieRepository.findById(productDTO.getCategoryId()).orElseThrow(()-> new RuntimeException("Category Not Found"));
        productEntity.setName(productDTO.getName());
        productEntity.setDescription(productDTO.getDescription());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setCategory(categorieEntity);
        productRepository.save(productEntity);
        return ProductMapper.toproductDTO(productEntity);
    }

    public  String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "Product Successfully Deleted";
    }
}
