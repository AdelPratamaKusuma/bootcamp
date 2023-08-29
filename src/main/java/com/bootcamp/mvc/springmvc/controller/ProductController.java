package com.bootcamp.mvc.springmvc.controller;

import com.bootcamp.mvc.springmvc.entity.HpEntity;
import com.bootcamp.mvc.springmvc.entity.ProductEntity;
import com.bootcamp.mvc.springmvc.model.ProductDto;
import com.bootcamp.mvc.springmvc.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("Product/index");

        String judul = "List Product";
        view.addObject("dataJudul", judul);

        //get data dari service, service => repo, repo => database
        List<ProductEntity> dataProduct = productService.getAll();
        // kirim data ke view
        view.addObject("listProduct", dataProduct);
        //menghitung jumlah data
        int jmlhData = dataProduct.size();
        //kirim data le view
        view.addObject("jmlData", jmlhData);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add() {
        return new ModelAndView("product/add.html");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute ProductDto request) {
        this.productService.save(request);
        return new ModelAndView("redirect:/product");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        ProductEntity productEntity = this.productService.getById(id);
        if(productEntity == null){
            return new ModelAndView("redirect:/product");
        }
        ModelAndView view = new ModelAndView("/product/edit");
        view.addObject("product",productEntity);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute ProductDto request){
        this.productService.update(request.getId(),request);
        return new ModelAndView("redirect:/product");
    }

    @GetMapping("/delete/{id}")
    public  ModelAndView delete(@ModelAttribute ProductDto request){
        ProductEntity result = productService.getById(request.getId());
        if(result == null){
            return new ModelAndView("redirect:/product");
        }
        this.productService.delete(request.getId());
        return new ModelAndView("redirect:/product");
    }
}



