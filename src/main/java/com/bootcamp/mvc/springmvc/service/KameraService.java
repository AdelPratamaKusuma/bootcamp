package com.bootcamp.mvc.springmvc.service;

import com.bootcamp.mvc.springmvc.entity.KameraEntity;
import com.bootcamp.mvc.springmvc.model.KameraDtp;

import java.util.List;

public interface KameraService {
    List<KameraEntity> getAll();

    KameraEntity getById(Integer id);

    KameraEntity save(KameraDtp request);

    KameraEntity update(Integer id,KameraDtp request);

    KameraEntity delete(Integer id);
}
