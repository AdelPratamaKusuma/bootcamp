package com.bootcamp.mvc.springmvc.controller;

import com.bootcamp.mvc.springmvc.entity.GuruEntity;
import com.bootcamp.mvc.springmvc.model.GuruDto;
import com.bootcamp.mvc.springmvc.service.GuruService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/guru")
public class GuruController {
    private final GuruService guruService;

    public GuruController(GuruService guruService){this.guruService=guruService;}

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("guru/index");
        String judul = "List Guru";
        view.addObject("dataJudul",judul);

        List<GuruEntity> dataGuru=guruService.getAll();
        view.addObject("ListGuru",dataGuru);

        int jmlhData = dataGuru.size();
        view.addObject("jmlhData",jmlhData);
        return view;
    }
    @GetMapping("/add")
    public ModelAndView add(){ return new ModelAndView("guru/add");}
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute GuruDto request){
        this.guruService.save(request);
        return new ModelAndView("redirect:/guru");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")Integer id){
        GuruEntity guruEntity = this.guruService.getById(id);
        if(guruEntity == null){
            return new ModelAndView("redirect:/guru");
        }
        ModelAndView view = new ModelAndView("/guru/edit");
        view.addObject("guru", guruEntity);
        return view;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute GuruDto request){
        this.guruService.update(request.getId(), request);
        return new ModelAndView("redirect:/guru");
    }


}
