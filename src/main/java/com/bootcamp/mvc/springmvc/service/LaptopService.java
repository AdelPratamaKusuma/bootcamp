package com.bootcamp.mvc.springmvc.service;

import com.bootcamp.mvc.springmvc.entity.LaptopEntity;
import com.bootcamp.mvc.springmvc.model.LaptopDto;

import java.util.List;

public interface LaptopService {
    List<LaptopEntity> getAll();

    LaptopEntity getById(Integer id);

    LaptopEntity save(LaptopDto request);

    LaptopEntity update(Integer id,LaptopDto request);

    LaptopEntity delete(Integer id);
}
