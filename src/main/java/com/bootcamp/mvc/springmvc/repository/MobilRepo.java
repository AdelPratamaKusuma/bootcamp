package com.bootcamp.mvc.springmvc.repository;

import com.bootcamp.mvc.springmvc.entity.MobilEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobilRepo extends JpaRepository<MobilEntity, Integer> {
}
