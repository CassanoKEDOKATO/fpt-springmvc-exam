package com.example.java_fpt.Controllers;

import com.example.java_fpt.Model.Nganh;
import com.example.java_fpt.Model.SinhVien;
import com.example.java_fpt.Model.TotNghiep;
import com.example.java_fpt.Model.Truong;
import com.example.java_fpt.Services.NganhService;
import com.example.java_fpt.Services.SinhVienService;
import com.example.java_fpt.Services.TotNghiepService;
import com.example.java_fpt.Services.TruongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private TruongService truongService;
    @Autowired
    private NganhService nganhService;
    @Autowired
    public SinhVienService sinhVienService;
    @Autowired
    public TotNghiepService totNghiepService;

    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
