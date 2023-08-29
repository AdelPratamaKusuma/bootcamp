package com.bootcamp.mvc.springmvc.repository;

import com.bootcamp.mvc.springmvc.entity.LaptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepo extends JpaRepository<LaptopEntity,Integer> {
}
