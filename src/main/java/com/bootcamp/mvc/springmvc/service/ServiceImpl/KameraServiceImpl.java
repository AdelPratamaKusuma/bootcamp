package com.bootcamp.mvc.springmvc.service.ServiceImpl;

import com.bootcamp.mvc.springmvc.entity.KameraEntity;
import com.bootcamp.mvc.springmvc.model.KameraDtp;
import com.bootcamp.mvc.springmvc.repository.KameraRepo;
import com.bootcamp.mvc.springmvc.service.KameraService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class KameraServiceImpl implements KameraService {

    private KameraRepo kameraRepo;

    public KameraServiceImpl(KameraRepo kameraRepo){
        this.kameraRepo=kameraRepo;
    }


    @Override
    public List<KameraEntity> getAll() {
        return kameraRepo.findAll();
    }

    @Override
    public KameraEntity getById(Integer id) {
        return kameraRepo.findById(id).orElse(new KameraEntity());
    }

    @Override
    public KameraEntity save(KameraDtp request) {
        KameraEntity result= new KameraEntity();
        BeanUtils.copyProperties(request,result);
        try{
            this.kameraRepo.save(result);
            log.info("Save Kamera to database successfully");
            return result;
        }catch (Exception e){
            log.error("Save Kamera to database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public KameraEntity update(Integer id, KameraDtp request) {
        KameraEntity entity = this.kameraRepo.findById(id).orElse(null);
        if(entity == null){
            log.warn("Kamera with id: {} not found",id);
            return null;
        }
        BeanUtils.copyProperties(request,entity);
        try {
            this.kameraRepo.save(entity);
            log.info("Update Kamera to database successfully");
            return entity;
        }catch(Exception e){
            log.error("Update Kamera to database failed, error:{}",e.getMessage());
            return null;
        }
    }

    @Override
    public KameraEntity delete(Integer id) {
        KameraEntity entity = this.kameraRepo.findById(id).orElse(null);
        if(entity == null)
            return null;
        try{
            this.kameraRepo.delete(entity);
            log.info("Delete Kamera from database successfullyy");
            return entity;
        }catch (Exception e){
            log.error("Delete Kamera from database failed, error:{}", e.getMessage());
            return null;
        }
    }
}
