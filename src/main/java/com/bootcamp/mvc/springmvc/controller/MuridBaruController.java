package com.bootcamp.mvc.springmvc.controller;

    import com.bootcamp.mvc.springmvc.entity.MuridBaruEntity;
import com.bootcamp.mvc.springmvc.model.MuridBaruDto;
import com.bootcamp.mvc.springmvc.service.MuridBaruService;
import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/muridBaru")
public class MuridBaruController {
    private final MuridBaruService muridBaruService;

    public MuridBaruController(MuridBaruService muridBaruService){
        this.muridBaruService=muridBaruService;
    }
    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("muridBaru/index");
        String judul ="List MuridBaru";
        view.addObject("dataJudul",judul);

        List<MuridBaruEntity> dataMuridBaru=muridBaruService.getAll();
        view.addObject("ListMuridBaru",dataMuridBaru);

        int jmlhData = dataMuridBaru.size();
        view.addObject("jmlhData",jmlhData);
        return view;
    }
    @GetMapping("/add")
    public ModelAndView add(){return new ModelAndView("muridBaru/add");}
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute MuridBaruDto request){
        this.muridBaruService.save(request);
        return new ModelAndView("redirect:/muridBaru");
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")Integer id){
        MuridBaruEntity muridBaruEntity = this.muridBaruService.getById(id);
        if(muridBaruEntity == null){
            return new ModelAndView("redirect:/muridBaru");
        }
        ModelAndView view = new ModelAndView("/muridBaru/edit");
        view.addObject("muridBaru",muridBaruEntity);
        return view;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute MuridBaruDto request){
        this.muridBaruService.update(request.getId(),request);
        return new ModelAndView("redirect:/muridBaru");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute MuridBaruDto request){
        MuridBaruEntity result = muridBaruService.getById(request.getId());
        if(result == null){
            return new ModelAndView("redirect:/muridBaru");
        }
        this.muridBaruService.delete(request.getId());
        return new ModelAndView("redirect:/muridBaru");

    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id")Integer id){
        MuridBaruEntity entity = muridBaruService.getById(id);
        if(entity == null){
            return new ModelAndView("redirect:/muridBaru");
        }
        ModelAndView view =new ModelAndView("muridBaru/detail");
        view.addObject("muridBaru",entity);
        return view;
    }


}
