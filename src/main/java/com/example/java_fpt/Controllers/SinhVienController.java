package com.example.java_fpt.Controllers;

import com.example.java_fpt.Model.Nganh;
import com.example.java_fpt.Model.SinhVien;
import com.example.java_fpt.Model.TotNghiep;
import com.example.java_fpt.Model.Truong;
import com.example.java_fpt.Services.NganhService;
import com.example.java_fpt.Services.SinhVienService;
import com.example.java_fpt.Services.TotNghiepService;
import com.example.java_fpt.Services.TruongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/sinhvien")
public class SinhVienController {
    @Autowired
    private TruongService truongService;
    @Autowired
    private NganhService nganhService;
    @Autowired
    public SinhVienService sinhVienService;
    @Autowired
    public TotNghiepService totNghiepService;
    @GetMapping("/display")
    public String displaySinhVien(Model model){
        model.addAttribute("sinhVien", sinhVienService.getAllSinhVien());
        return "sinhvien/display";
    }
    @GetMapping("/add")
    public String addSinhVien(){
        return "sinhvien/add";
    }
    @PostMapping("/addsinhvien")
    public String addSinhVien(@ModelAttribute SinhVien sinhVien){
        sinhVienService.addSinhVien(sinhVien);
         return "redirect:/sinhvien/display";
    }
    @GetMapping("/{soCMND}")
    public String getSinhVienDetails(@PathVariable String soCMND, Model model) {
        SinhVien sinhVien = sinhVienService.getSinhVienById(soCMND);
        if (sinhVien != null) {
            model.addAttribute("sinhVien", sinhVien);
            model.addAttribute("totnghiepList", sinhVien.getTotNghiepList());
            return "sinhvien/details";
        } else {
            return "redirect:/sinhviens"; // Handle not found case
        }
    }

    @PutMapping("/sinhvien/update")
    public String updateSinhVien(@PathVariable String soCMND, @RequestBody SinhVien sinhVien) {
      SinhVien updatedSinhVien = sinhVienService.updateSinhVien(soCMND,sinhVien);
        return "redirect:/sinhvien/" + sinhVien.getSoCMND();
    }
    @GetMapping("/{sinhvienId}/totnghiep-add")
    public String addTotNghiepForSinhVienForm(@PathVariable("sinhvienId") String maSV,
                                              Model model) {
        TotNghiep totNghiep = new TotNghiep();
        SinhVien sinhVien = sinhVienService.findSinhVienById(maSV);
        List<Nganh> nganhList = nganhService.getAllNganh();
        List<Truong> truongList = truongService.getAllTruong();
        model.addAttribute("sinhvien", sinhVien);
        model.addAttribute("totnghiep", totNghiep);
        model.addAttribute("nganhList", nganhList);
        model.addAttribute("truongList", truongList);
        return "sinhvien/add-totnghiep";
    }
    @PostMapping("/{sinhvienId}/totnghiep-add")
    public String saveTotNghiepForSinhVien(@PathVariable("sinhvienId") String maSV,
                                         @ModelAttribute("totnghiep") TotNghiep totNghiep,
                                          @Valid BindingResult result,
                                           Model model) {

        SinhVien sinhVien = sinhVienService.findSinhVienById(maSV);
        totNghiep.setSinhVien(sinhVien);
        totNghiep.getSinhVien().setTotNghiepList(null);
        totNghiep.getSinhVien().setCongViecList(null);
        totNghiep.getNganh().setTotNghiepList(null);
        totNghiep.getNganh().setCongViecList(null);
        totNghiep.getTruong().setTotNghiepList(null);

        List<Nganh> nganhList = nganhService.getAllNganh();
        List<Truong> truongList = truongService.getAllTruong();

        if (result.hasErrors()) {
            model.addAttribute("nganhList", nganhList);
            model.addAttribute("truongList", truongList);
            model.addAttribute("sinhvien", sinhVien);
            model.addAttribute("totnghiep", totNghiep);
            return "sinhvien/add-totnghiep";
        }

        totNghiepService.addTotNghiep(totNghiep);

        return "redirect:/sinhvien/{sinhvienId}";
    }

}
