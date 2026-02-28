package com.shehnaz.ProductCategories.controller;


import com.shehnaz.ProductCategories.dto.CategorieDTO;
import com.shehnaz.ProductCategories.dto.ProductDTO;
import com.shehnaz.ProductCategories.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("")
    public List<ProductDTO> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("{id}")
    public ProductDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PreAuthorize("hasAuthority(ROLE_SELLER)")
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){

        ProductDTO createdProduct=productService.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);

    }

    @PreAuthorize("hasAuthority(ROLE_SELLER)")
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        return productService.updateProduct(id,productDTO);

    }

    @PreAuthorize("hasAuthority(ROLE_SELLER)")
    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id){
        return productService.deleteProduct(id);
    }
}
