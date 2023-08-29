package com.bootcamp.mvc.springmvc.service.ServiceImpl;

import com.bootcamp.mvc.springmvc.entity.MotorEntity;
import com.bootcamp.mvc.springmvc.model.MotorDto;
import com.bootcamp.mvc.springmvc.repository.MotorRepo;
import com.bootcamp.mvc.springmvc.service.MotorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class MotorServiceImpl implements MotorService {
    private MotorRepo motorRepo;

    public MotorServiceImpl(MotorRepo motorRepo) {
        this.motorRepo = motorRepo;
    }

    @Override
    public List<MotorEntity> getAll() {
        return motorRepo.findAll();
    }

    @Override
    public MotorEntity getById(Integer id) {
        return motorRepo.findById(id).orElse(new MotorEntity());
    }

    @Override
    public MotorEntity save(MotorDto request) {
        MotorEntity result = new MotorEntity();
        BeanUtils.copyProperties(request, result);
        try {
            this.motorRepo.save(result);
            log.info("Save Motor to database successfully");
            return result;
        } catch (Exception e) {
            log.error("Save Motor to database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public MotorEntity update(Integer id, MotorDto request) {
        MotorEntity entity = this.motorRepo.findById(id).orElse(null);
        if (entity == null) {
            log.warn("Motor with id: {} not found", id);
            return null;
        }
        BeanUtils.copyProperties(request, entity);
        try {
            this.motorRepo.save(entity);
            log.info("Update Motor to database successfuly");
            return entity;
        } catch (Exception e) {
            log.error("Update Motor to database failed", e.getMessage());
            return null;
        }

    }

    @Override
    public MotorEntity delete(Integer id) {
        MotorEntity entity = this.motorRepo.findById(id).orElse(null);

        if (entity == null)
            return null;
        try {
            this.motorRepo.delete(entity);
            log.info("Delete from database successfuly");
            return entity;
        } catch (Exception e) {
            log.error("Delete from database failed, error: {}", e.getMessage());
            return null;
        }
    }
}