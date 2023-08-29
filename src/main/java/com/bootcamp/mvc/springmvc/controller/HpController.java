package com.bootcamp.mvc.springmvc.controller;

import com.bootcamp.mvc.springmvc.entity.HpEntity;
import com.bootcamp.mvc.springmvc.model.HpDto;
import com.bootcamp.mvc.springmvc.service.HpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/hp")
public class HpController {
    private final HpService hpService;

    public HpController(HpService hpService){
        this.hpService = hpService;
    }
    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("hp/index");
        String judul = "List Product";
        view.addObject("dataJudul",judul);

        List<HpEntity> dataHp= hpService.getAll();

        view.addObject("ListHp", dataHp);

        int jmlhData = dataHp.size();

        view.addObject("jmlData", jmlhData);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("hp/add");
    }


    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute HpDto request){
        this.hpService.save(request);
        return new ModelAndView("redirect:/hp");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        HpEntity hpEntity = this.hpService.getByid(id);
        if(hpEntity == null){
            return new ModelAndView("redirect:/hp");
        }
        ModelAndView view= new ModelAndView("/hp/edit");
        view.addObject("hp",hpEntity);
        return view;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id){
        HpEntity hpEntity = hpService.getByid(id);
        if(hpEntity == null){
            return new ModelAndView("redirect:/hp");
        }
        ModelAndView view = new ModelAndView("hp/detail");
        view.addObject("hp",hpEntity);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute HpDto request){
        this.hpService.update(request.getId(), request);
        return new ModelAndView("redirect:/hp");

    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute HpDto request){
        HpEntity result = hpService.getByid(request.getId());
        if(result == null){
            return new ModelAndView("redirect:/hp");
        }
        this.hpService.delete(request.getId());
        return new ModelAndView("redirect:/hp");
    }
}
