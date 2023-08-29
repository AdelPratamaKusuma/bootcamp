package com.bootcamp.mvc.springmvc.service.ServiceImpl;

import com.bootcamp.mvc.springmvc.entity.MobilEntity;
import com.bootcamp.mvc.springmvc.model.MobilDto;
import com.bootcamp.mvc.springmvc.repository.MobilRepo;
import com.bootcamp.mvc.springmvc.service.MobilService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MobilServiceImpl implements MobilService {
    private MobilRepo mobilRepo;

    public MobilServiceImpl(MobilRepo mobilRepo){
        this.mobilRepo=mobilRepo;
    }

    @Override
    public List<MobilEntity> getAll() {
        return mobilRepo.findAll();
    }

    @Override
    public MobilEntity getById(Integer id) {
        return mobilRepo.findById(id).orElse(new MobilEntity());
    }

    @Override
    public MobilEntity   save(MobilDto request) {
        MobilEntity result= new MobilEntity();
        BeanUtils.copyProperties(request,result);
        try{
            this.mobilRepo.save(result);
            log.info("Save Mobil to database successfully");
            return result;
        }catch (Exception e){
            log.error("Save Mobil to database failed, error: {}",e.getMessage());
            return null;
        }
    }
    @Override
    public MobilEntity delete(Integer id) {
        MobilEntity entity = this.mobilRepo.findById(id).orElse(null);
        if(entity == null)
            return null;
        try{
            this.mobilRepo.delete(entity);
            log.info("Delete Mobil from Database successfully");
            return entity;
        }catch (Exception e){
            log.error("Delete from Database failed, error: {}",e.getMessage());
            return null;

        }
    }

    @Override
    public MobilEntity update(Integer id, MobilDto request) {
        MobilEntity entity = this.mobilRepo.findById(id).orElse(null);
        if(entity == null){
            log.warn("Mobil with id: {] not found",id);
            return null;
        }
        BeanUtils.copyProperties(request,entity);
        try{
            this.mobilRepo.save(entity);
            log.info("Update to database successfully");
            return entity;
        }catch (Exception e){
            log.error("Update to database failed, error: {}",e.getMessage());
            return null;
        }
    }
}
