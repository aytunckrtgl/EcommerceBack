package com.example.demo.model.repository;

import com.example.demo.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select s from Product s where s.category.categoryId = :departmentId")
    Iterable<Product> findProductsOfDepartment(@Param("departmentId") double departmentId);

}
