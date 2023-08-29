package com.bootcamp.mvc.springmvc.controller;

import com.bootcamp.mvc.springmvc.entity.MotorEntity;
import com.bootcamp.mvc.springmvc.model.MotorDto;
import com.bootcamp.mvc.springmvc.service.MotorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/motor")
public class motorController {
    private final MotorService motorService;

    public motorController(MotorService motorService){
        this.motorService=motorService;
    }
    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("motor/index");
        String judul = "List Motor";
        view.addObject("dataJudul",judul);

        List<MotorEntity> dataMotor= motorService.getAll();

        view.addObject("ListMotor",dataMotor);

        int jmlhData=dataMotor.size();
        view.addObject("jmlhData",jmlhData);
        return view;
    }
    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("motor/add");
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute MotorDto request){
        this.motorService.save(request);
        return new ModelAndView("redirect:/motor");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        MotorEntity motorEntity = this.motorService.getById(id);
        if(motorEntity == null){
            return new ModelAndView("redirect:/motor");
        }
        ModelAndView view = new ModelAndView("/motor/edit");
        view.addObject("motor",motorEntity);
        return view;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute MotorDto request){
        this.motorService.update(request.getId(),request);
        return new ModelAndView("redirect:/motor");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute MotorDto request){
        MotorEntity result = motorService.getById(request.getId());
        if(result == null){
            return new ModelAndView("redirect:/motor");
        }
        this.motorService.delete(request.getId());
        return new ModelAndView("redirect:/motor");

    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id){
        MotorEntity entity = motorService.getById(id);
        if(entity == null){
            return new ModelAndView("redirect:/motor");
        }
        ModelAndView view = new ModelAndView("motor/detail");
        view.addObject("motor",entity);
        return view;
    }
}
