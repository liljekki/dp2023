package controllers;

import entity.MyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import services.Service;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private Service service;

    @GetMapping("/")
    public String HomePage(Model model){
        List<MyEntity>list = service.listAll();
        model.addAttribute("list", list);

        return "index";
    }


    @GetMapping("/toadd")
    public String AddForm(Model model){
        MyEntity new_ent = new MyEntity();
        model.addAttribute("entity", new_ent);

        return "add";
    }
    @PostMapping("/toadd")
    public String saveWatch(@ModelAttribute("entity") MyEntity entity_x) {
        service.save(entity_x);

        return "redirect:/";
    }


    @GetMapping("/update/{id}")
    public ModelAndView UpdateForm(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("update");
        MyEntity new_ent = service.get(id);
        mav.addObject("entity", new_ent);

        return mav;
    }


    @GetMapping("/delete/{id}")
    public String Delete(@PathVariable(name = "id") int id){
        service.delete(id);

        return "redirect:/";
    }
}
