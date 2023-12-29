package com.example.java_fpt.Controllers;

import com.example.java_fpt.Model.Truong;
import com.example.java_fpt.Services.TruongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/truong")
public class TruongController {
    @Autowired
    public TruongService service;
    @GetMapping("/display")
    public String displayTruong(Model model){
        model.addAttribute("truong", service.getAllTruong());
        return "truong/display";
    }
    @GetMapping("/add")
    public String addSinhVien(){
        return "truong/add";
    }
    @PostMapping("/addtruong")
    public String addSinhVien(@ModelAttribute Truong truong){
        service.addTruong(truong);
        return "redirect:/truong/display";
    }
}
