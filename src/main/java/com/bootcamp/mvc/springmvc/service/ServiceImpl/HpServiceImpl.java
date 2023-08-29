package com.bootcamp.mvc.springmvc.service.ServiceImpl;

import com.bootcamp.mvc.springmvc.entity.HpEntity;
import com.bootcamp.mvc.springmvc.model.HpDto;
import com.bootcamp.mvc.springmvc.repository.HpRepo;
import com.bootcamp.mvc.springmvc.service.HpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HpServiceImpl implements HpService {
    private HpRepo hpRepo;

    public HpServiceImpl(HpRepo hpRepo) {
        this.hpRepo = hpRepo;
    }

    public List<HpEntity> getAll() {
        return hpRepo.findAll();
    }

    @Override
    public HpEntity getByid(Integer id) {
        return hpRepo.findById(id).orElse(new HpEntity());
    }

    @Override
    public HpEntity save(HpDto request) {
        HpEntity result = new HpEntity();
        BeanUtils.copyProperties(request, result);
        try {
            this.hpRepo.save(result);
            log.info("Save HP to database successdully");
            return result;
        } catch (Exception ex) {
            log.error("Save HP to database failed, error: {}", ex.getMessage());
            return null;
        }
    }

    @Override
    public HpEntity update(Integer id, HpDto request) {
        HpEntity entity = this.hpRepo.findById(id).orElse(null);
        if (entity == null) {
            log.warn("Hp with id: {} not found", id);
            return null;
        }
        BeanUtils.copyProperties(request, entity);
        try {
            this.hpRepo.save(entity);
            log.info("Update HP to database successfully");
            return entity;
        } catch (Exception ex) {
            log.error("Update HP to database failed, error: {}", ex.getMessage());
            return null;
        }
    }

    @Override
    public HpEntity delete(Integer id) {
        HpEntity entity = this.hpRepo.findById(id).orElse(null);

        if (entity == null)
            return null;
        try {
            this.hpRepo.delete(entity);
            log.info("Delete HP from database successfully");
            return entity;
        } catch (Exception ex) {
            log.error("Delete HP from database failed, error: {}", id);
            return null;
        }
    }
}





