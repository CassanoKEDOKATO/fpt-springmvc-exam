package com.example.java_fpt.Services;

import com.example.java_fpt.Model.SinhVien;
import com.example.java_fpt.Repositories.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SinhVienService {
    @Autowired
    public SinhVienRepository repository;
    public SinhVien saveSinhVien(SinhVien SinhVien) {
        return repository.save(SinhVien);
    }
    public List<SinhVien> getAllSinhVien() {
        return repository.findAll();
    }
    public SinhVien addSinhVien(SinhVien sinhVien){
        return repository.save(sinhVien);
    }
    public SinhVien getSinhVienById(String soCMND){
        return repository.findById(soCMND).orElse(null);
    }
    public SinhVien updateSinhVien(String soCMND, SinhVien sinhVien) {
        SinhVien existing = repository.findById(soCMND).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setHoTen(sinhVien.getHoTen());
        existing.setEmail(sinhVien.getEmail());
        existing.setSoDT(sinhVien.getSoDT());
        existing.setDiaChi(sinhVien.getDiaChi());
        return repository.save(existing);
    }
    public SinhVien findSinhVienById(String maSV) {
        return repository.findById(maSV).get();
    }
}
