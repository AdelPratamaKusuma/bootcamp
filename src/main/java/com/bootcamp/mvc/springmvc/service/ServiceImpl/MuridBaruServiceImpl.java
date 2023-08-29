package com.bootcamp.mvc.springmvc.service.ServiceImpl;

import com.bootcamp.mvc.springmvc.entity.MuridBaruEntity;
import com.bootcamp.mvc.springmvc.model.MuridBaruDto;
import com.bootcamp.mvc.springmvc.repository.MuridBaruRepo;
import com.bootcamp.mvc.springmvc.service.MuridBaruService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class MuridBaruServiceImpl implements MuridBaruService {

    private MuridBaruRepo muridBaruRepo;

    public MuridBaruServiceImpl(MuridBaruRepo muridBaruRepo){
        this.muridBaruRepo=muridBaruRepo;
    }


    @Override
    public List<MuridBaruEntity> getAll() {
        return muridBaruRepo.findAll();
    }

    @Override
    public MuridBaruEntity getById(Integer id) {
        return muridBaruRepo.findById(id).orElse(new MuridBaruEntity());
    }

    @Override
    public MuridBaruEntity save(MuridBaruDto request) {
        MuridBaruEntity result = new MuridBaruEntity();
        BeanUtils.copyProperties(request, result);
        try{
            this.muridBaruRepo.save(result);
            log.info("Save MuridBaru to database successfully");
            return result;
        }catch (Exception e){
            log.error("Save MuridBaru to database failed, error: {}" ,e.getMessage());
            return null;
        }

    }

    @Override
    public MuridBaruEntity update(Integer id, MuridBaruDto request) {
        MuridBaruEntity entity = this.muridBaruRepo.findById(id).orElse(null);
        if (entity == null) {
            log.warn("MuridBaru with id: {} not found", id);
            return null;
        }
        BeanUtils.copyProperties(request,entity);
        try{
            this.muridBaruRepo.save(entity);
            log.info("Update Murid Baru to database successfully");
            return entity;
        }catch (Exception e){
            log.error("update Murid Baru to database failed, error:{}",e.getMessage());
            return null;
        }
    }

    @Override
    public MuridBaruEntity delete(Integer id) {
        MuridBaruEntity entity = this.muridBaruRepo.findById(id).orElse(null);
        if(entity == null)
        return null;

        try{
            this.muridBaruRepo.delete(entity);
            log.info("Delete Murid Baru from database successfully");
            return entity;
        }catch (Exception e){
            log.error("Delete Murid Baru from database failed, error: {}", e.getMessage());
            return null;
        }
    }
}

