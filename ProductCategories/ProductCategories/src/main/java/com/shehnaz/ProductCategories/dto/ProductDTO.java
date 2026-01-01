package com.shehnaz.ProductCategories.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long Id;
    private String name;
    private String description;
    private Double price;
    private Long categoryId;

}
