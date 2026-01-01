package com.shehnaz.ProductCategories.repository;

import com.shehnaz.ProductCategories.entity.CategorieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<CategorieEntity,Long> {
}
