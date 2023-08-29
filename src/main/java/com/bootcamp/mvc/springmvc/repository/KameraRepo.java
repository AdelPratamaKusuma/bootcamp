package com.bootcamp.mvc.springmvc.repository;

import com.bootcamp.mvc.springmvc.entity.KameraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KameraRepo extends JpaRepository<KameraEntity,Integer> {
}
