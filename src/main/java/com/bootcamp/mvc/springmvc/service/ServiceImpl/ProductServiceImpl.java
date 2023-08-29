package com.bootcamp.mvc.springmvc.service.ServiceImpl;

import com.bootcamp.mvc.springmvc.entity.ProductEntity;
import com.bootcamp.mvc.springmvc.model.ProductDto;
import com.bootcamp.mvc.springmvc.repository.ProductRepo;
import com.bootcamp.mvc.springmvc.service.ProductService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
//Constructor CONTOH: nama methodnya sama dengan nama class dan tidak ada return
    public ProductServiceImpl(ProductRepo productRepo){
        this.productRepo=productRepo;
    }


    @Override
    public List<ProductEntity> getAll() {
        return productRepo.findAll();
    }

    @Override
    public ProductEntity getById(Integer id) {
          return productRepo.findById(id).orElse(new ProductEntity());
    }

    @Override
    public ProductEntity save(ProductDto request) {
        ProductEntity result =new ProductEntity();
    //Copy property
        BeanUtils.copyProperties(request,result);
        try{
            this.productRepo.save(result);
            log.info("Save product to database is successfully");
            return result;
        }catch (Exception ex){
            log.error("Save product to database is failed, error: {}",ex.getMessage());
            return null;
        }
    }

    @Override
    public ProductEntity update(Integer id, ProductDto request) {
        ProductEntity entity = this.productRepo.findById(id).orElse(null);

        if(entity == null){
            log.warn("Product with id: {} not found",id);
            return null;
        }

        BeanUtils.copyProperties(request, entity);
        try{
            this.productRepo.save(entity);
            log.info("Update product to database successfully");
            return entity;
        }catch (Exception ex){
            log.error("Update product to database failed, error: {}",ex.getMessage());
            return null;
        }
    }

    @Override
    public ProductEntity delete(Integer id) {
        //get data dari database
        ProductEntity entity = this.productRepo.findById(id).orElse(null);
        if(entity == null)
        return null;

        try{
            this.productRepo.delete(entity);
            log.info("Delete product from database successfully");
            return entity;
        }catch (Exception ex){
            log.error("Delete product from database failed, error: {}",id);
            return null;
        }
    }
}
