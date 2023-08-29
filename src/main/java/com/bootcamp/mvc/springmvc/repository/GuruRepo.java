package com.bootcamp.mvc.springmvc.repository;

import com.bootcamp.mvc.springmvc.entity.GuruEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuruRepo extends JpaRepository<GuruEntity,Integer> {
}
