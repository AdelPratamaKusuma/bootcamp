package com.bootcamp.mvc.springmvc.service;

import com.bootcamp.mvc.springmvc.entity.HpEntity;
import com.bootcamp.mvc.springmvc.model.HpDto;

import java.util.List;

public interface HpService {
    List<HpEntity> getAll();
    HpEntity getByid(Integer id);
    HpEntity save(HpDto request);
    HpEntity update(Integer id, HpDto request);
    HpEntity delete(Integer id);
}
