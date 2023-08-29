package com.bootcamp.mvc.springmvc.controller;

import com.bootcamp.mvc.springmvc.entity.KameraEntity;
import com.bootcamp.mvc.springmvc.model.KameraDtp;
import com.bootcamp.mvc.springmvc.service.KameraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/kamera")
public class KameraController {
    private final KameraService kameraService;

    public KameraController(KameraService kameraService){
        this.kameraService=kameraService;
    }
    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("kamera/index");
        String judul="List Kamera";
        view.addObject("dataJudul",judul);

        List<KameraEntity> dataKamera=kameraService.getAll();

        view.addObject("ListKamera",dataKamera);

        int jmlhData=dataKamera.size();
        view.addObject("jmlhData",jmlhData);
        return view;
    }
    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("kamera/add");
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute KameraDtp request){
        this.kameraService.save(request);
        return new ModelAndView("redirect:/kamera");
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")Integer id){
        KameraEntity kameraEntity = this.kameraService.getById(id);
        if(kameraEntity == null){
            return new ModelAndView("redirect:/kamera");
        }
        ModelAndView view = new ModelAndView("/kamera/edit");
        view.addObject("kamera",kameraEntity);
        return view;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute KameraDtp request){
        this.kameraService.update(request.getId(), request);
        return new ModelAndView("redirect:/kamera");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute KameraDtp request){
        KameraEntity result= kameraService.getById(request.getId());
        if(result == null){
            return new ModelAndView("redirect:/kamera");
        }
        this.kameraService.delete(request.getId());
        return new ModelAndView("redirect:/kamera");
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id")Integer id){
        KameraEntity entity = kameraService.getById(id);
        if(entity == null){
            return new ModelAndView("redirect:/kamera");
        }
        ModelAndView view = new ModelAndView("kamera/detail");
        view.addObject("kamera",entity);
        return view;
    }
}
