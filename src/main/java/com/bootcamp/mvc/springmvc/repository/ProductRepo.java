package com.bootcamp.mvc.springmvc.repository;

import com.bootcamp.mvc.springmvc.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
}
