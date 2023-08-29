package com.bootcamp.mvc.springmvc.controller;

import com.bootcamp.mvc.springmvc.entity.BukuEntity;
import com.bootcamp.mvc.springmvc.model.BukuDto;
import com.bootcamp.mvc.springmvc.service.BukuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/buku")
public class BukuController {
    private final BukuService bukuService;

    public BukuController(BukuService bukuService){
        this.bukuService=bukuService;
    }
    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("buku/index");
        String judul="List Buku";
        view.addObject("dataJudul",judul);

        List<BukuEntity> dataBuku=bukuService.getAll();

        view.addObject("ListBuku",dataBuku);

        int jmlhData=dataBuku.size();
        view.addObject("jmlhData",jmlhData);
        return view;
    }
    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("buku/add");
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute BukuDto request){
        this.bukuService.save(request);
        return new ModelAndView("redirect:/buku");
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        BukuEntity bukuEntity = this.bukuService.getById(id);
        if(bukuEntity == null){
            return new ModelAndView("redirect:/buku");
        }
        ModelAndView view = new ModelAndView("/buku/edit");
        view.addObject("buku",bukuEntity);
        return view;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute BukuDto request){
        this.bukuService.update(request.getId(),request);
        return new ModelAndView("redirect:/buku");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute BukuDto request){
        BukuEntity result = bukuService.getById(request.getId());
        if(result == null){
            return new ModelAndView("redirect:/buku");
        }
        this.bukuService.delete(request.getId());
        return new ModelAndView("redirect:/buku");
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id")Integer id){
        BukuEntity entity = bukuService.getById(id);
        if(entity == null){
            return new ModelAndView("redirect:/buku");
        }
        ModelAndView view= new ModelAndView("buku/detail");
        view.addObject("buku",entity);
        return view;
    }
}
