package com.example.java_fpt.Controllers;

import com.example.java_fpt.Model.Nganh;
import com.example.java_fpt.Model.Truong;
import com.example.java_fpt.Services.NganhService;
import com.example.java_fpt.Services.TruongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nganh")
public class NganhController {
    @Autowired
    public NganhService service;
    @GetMapping("/display")
    public String displayNganh(Model model){
        model.addAttribute("nganh", service.getAllNganh());
        return "nganh/display";
    }
    @GetMapping("/add")
    public String addNganh(){
        return "nganh/add";
    }
    @PostMapping("/addnganh")
    public String addNganh(@ModelAttribute Nganh nganh){
        service.addNganh(nganh);
        return "redirect:/nganh/display";
    }
}
