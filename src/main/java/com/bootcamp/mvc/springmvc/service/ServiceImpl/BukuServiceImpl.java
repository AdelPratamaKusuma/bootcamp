package com.bootcamp.mvc.springmvc.service.ServiceImpl;

import com.bootcamp.mvc.springmvc.entity.BukuEntity;
import com.bootcamp.mvc.springmvc.model.BukuDto;
import com.bootcamp.mvc.springmvc.repository.BukuRepo;
import com.bootcamp.mvc.springmvc.service.BukuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class BukuServiceImpl implements BukuService {
    private BukuRepo bukuRepo;

    public BukuServiceImpl(BukuRepo bukuRepo){
        this.bukuRepo=bukuRepo;
    }


    @Override
    public List<BukuEntity> getAll() {
        return bukuRepo.findAll();
    }

    @Override
    public BukuEntity getById(Integer id) {
        return bukuRepo.findById(id).orElse(new BukuEntity());
    }

    @Override
    public BukuEntity save(BukuDto request) {
        BukuEntity result = new BukuEntity();
        BeanUtils.copyProperties(request,result);
        try{
            this.bukuRepo.save(result);
            log.info("save to database successfully");
            return result;
        }catch (Exception e){
            log.error("save to database failed, error: {}",e.getMessage());
            return null;
        }
    }

    @Override
    public BukuEntity update(Integer id, BukuDto request) {
        BukuEntity entity = this.bukuRepo.findById(id).orElse(null);
        if(entity == null){
            log.warn("Buku With id: {} not found",id);
            return null;
        }
        BeanUtils.copyProperties(request,entity);
        try{
            this.bukuRepo.save(entity);
            log.info("Update Buku to database successfully");
            return entity;
        }catch (Exception e){
            log.error("Update Buku to database failed, error: {}", e.getMessage());
            return null;
        }

    }

    @Override
    public BukuEntity delete(Integer id) {
        BukuEntity entity = this.bukuRepo.findById(id).orElse(null);
        if(entity == null)
            return null;
        try{
            this.bukuRepo.delete(entity);
            log.info("Delete Buku from database successfully");
            return entity;
        }catch (Exception e){
            log.error("Delete buku from databsae failed, error: {}", e.getMessage());
            return null;
        }
    }
}
