package com.bootcamp.mvc.springmvc.service.ServiceImpl;

import com.bootcamp.mvc.springmvc.entity.GuruEntity;
import com.bootcamp.mvc.springmvc.model.GuruDto;
import com.bootcamp.mvc.springmvc.repository.GuruRepo;
import com.bootcamp.mvc.springmvc.service.GuruService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class GuruServiceImpl implements GuruService {
    private GuruRepo guruRepo;

    public GuruServiceImpl(GuruRepo guruRepo){
        this.guruRepo=guruRepo;
    }

    @Override
    public List<GuruEntity> getAll() {
        return guruRepo.findAll();
    }

    @Override
    public GuruEntity getById(Integer id) {
        return guruRepo.findById(id).orElse(new GuruEntity());
    }

    @Override
    public GuruEntity save(GuruDto request) {
        GuruEntity result= new GuruEntity();
        BeanUtils.copyProperties(request,result);
        try{
            this.guruRepo.save(result);
            log.info("Save Guru to database successfully");
            return result;
        }catch (Exception e){
            log.error("Save Guru to database failed, error: {}",e.getMessage());
            return null;
        }
    }

    @Override
    public GuruEntity update(Integer id, GuruDto request) {
        GuruEntity entity = this.guruRepo.findById(id).orElse(null);
        if( entity == null){
            log.warn("Guru with id: {} not found",id);
            return null;
        }
        BeanUtils.copyProperties(request,entity);
        try{
            this.guruRepo.save(entity);
            log.info("Update Guru to database successlly");
            return entity;
        }catch (Exception e){
            log.error("Update Guru to database failed, error: {}",e.getMessage());
            return null;
        }

    }

    @Override
    public GuruEntity delete(Integer id) {
        GuruEntity entity = this.guruRepo.findById(id).orElse(null);
        if(entity == null)
        return null;
        try{
            this.guruRepo.delete(entity);
            log.info("Delete Guru from database successfully");
            return entity;
        }catch (Exception e){
            log.error("Delete guru from database failed, error: {}",e.getMessage());
            return null;
        }
    }
}
