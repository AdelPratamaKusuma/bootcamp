package com.bootcamp.mvc.springmvc.repository;

import com.bootcamp.mvc.springmvc.entity.HpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HpRepo extends JpaRepository<HpEntity,Integer> {
}
