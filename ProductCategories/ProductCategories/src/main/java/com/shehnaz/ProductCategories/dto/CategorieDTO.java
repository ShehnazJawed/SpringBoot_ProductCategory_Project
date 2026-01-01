package com.shehnaz.ProductCategories.dto;

import com.shehnaz.ProductCategories.entity.ProductEntity;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategorieDTO {

    private Long Id;
    private String name;
    private List<ProductDTO> products;


}
