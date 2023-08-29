package com.bootcamp.mvc.springmvc.controller;

import com.bootcamp.mvc.springmvc.entity.LaptopEntity;
import com.bootcamp.mvc.springmvc.model.LaptopDto;
import com.bootcamp.mvc.springmvc.service.LaptopService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/laptop")
public class LaptopController {
    private final LaptopService laptopService;

    public LaptopController(LaptopService laptopService){
        this.laptopService=laptopService;
    }
    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("laptop/index");
        String judul="List Laptop";
        view.addObject("dataJudul",judul);

        List<LaptopEntity> dataLaptop= laptopService.getAll();

        view.addObject("ListLaptop",dataLaptop);

        int jmlhData = dataLaptop.size();

        view.addObject("jmlhData",jmlhData);
        return view;
    }
    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("laptop/add");
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute LaptopDto request){
        this.laptopService.save(request);
        return new ModelAndView("redirect:/laptop");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        LaptopEntity laptopEntity = this.laptopService.getById(id);
        if(laptopEntity == null){
            return new ModelAndView("redirect:/laptop");
        }
        ModelAndView view = new ModelAndView("/laptop/edit");
        view.addObject("laptop",laptopEntity);
        return view;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id){
        LaptopEntity entity = laptopService.getById(id);
        if(entity == null){
            return new ModelAndView("redirect:/laptop");
        }
        ModelAndView view = new ModelAndView("laptop/detail");
        view.addObject("laptop",entity);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute LaptopDto request){
        this.laptopService.update(request.getId(),request);
        return new ModelAndView("redirect:/laptop");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute LaptopDto request) {
        LaptopEntity result = laptopService.getById(request.getId());
        if (result == null) {
            return new ModelAndView("redirect:/laptop");
        }
        this.laptopService.delete(request.getId());
        return new ModelAndView("redirect:/laptop");
    }

}
