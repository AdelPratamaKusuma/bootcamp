package com.bootcamp.mvc.springmvc.service.ServiceImpl;

import com.bootcamp.mvc.springmvc.entity.LaptopEntity;
import com.bootcamp.mvc.springmvc.model.LaptopDto;
import com.bootcamp.mvc.springmvc.repository.LaptopRepo;
import com.bootcamp.mvc.springmvc.service.LaptopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LaptopServiceImpl implements LaptopService {
    private LaptopRepo laptopRepo;

    public LaptopServiceImpl(LaptopRepo laptopRepo) {
        this.laptopRepo = laptopRepo;
    }

    @Override
    public List<LaptopEntity> getAll() {
        return laptopRepo.findAll();
    }

    @Override
    public LaptopEntity getById(Integer id) {
        return laptopRepo.findById(id).orElse(new LaptopEntity());
    }

    @Override
    public LaptopEntity save(LaptopDto request) {
        LaptopEntity result = new LaptopEntity();
        BeanUtils.copyProperties(request, result);
        try {
            this.laptopRepo.save(result);
            log.info("Save Laptop to database successfully");
            return result;
        } catch (Exception e) {
            log.error("Save Laptop to database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public LaptopEntity update(Integer id, LaptopDto request) {
        LaptopEntity entity = this.laptopRepo.findById(id).orElse(null);
        if (entity == null) {
            log.warn("Laptop with id: {} not found", id);
            return null;
        }
        BeanUtils.copyProperties(request, entity);
        try {
            this.laptopRepo.save(entity);
            log.info("Update Laptop to database successfully");
            return entity;
        } catch (Exception r) {
            log.error("Update Laptop to database failed, error: {}", r.getMessage());
            return null;
        }
    }


    @Override
    public LaptopEntity delete(Integer id) {
        LaptopEntity entity = this.laptopRepo.findById(id).orElse(null);
        if (entity == null) {
            log.warn("Laptop With id: {} not found", id);
            return null;
        }
            try {
                this.laptopRepo.delete(entity);
                log.info("Delete Laptop from database successfully");
                return entity;
            } catch (Exception e) {
                log.error("Delete Laptop from database failed, error: {}", id);
                return null;
            }
    }

}
