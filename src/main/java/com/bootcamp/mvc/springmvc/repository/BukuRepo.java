package com.bootcamp.mvc.springmvc.repository;

import com.bootcamp.mvc.springmvc.entity.BukuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BukuRepo extends JpaRepository<BukuEntity,Integer> {
}
