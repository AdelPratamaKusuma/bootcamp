package com.bootcamp.mvc.springmvc.service;

import com.bootcamp.mvc.springmvc.entity.MuridBaruEntity;
import com.bootcamp.mvc.springmvc.model.MuridBaruDto;
import com.bootcamp.mvc.springmvc.repository.MuridBaruRepo;

import java.util.List;

public interface MuridBaruService {
    List<MuridBaruEntity> getAll();

    MuridBaruEntity getById(Integer id);

    MuridBaruEntity save(MuridBaruDto request);

    MuridBaruEntity update(Integer id, MuridBaruDto request);

    MuridBaruEntity delete(Integer id);
}
