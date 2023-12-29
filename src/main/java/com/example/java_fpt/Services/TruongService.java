package com.example.java_fpt.Services;

import com.example.java_fpt.Model.SinhVien;
import com.example.java_fpt.Model.Truong;
import com.example.java_fpt.Repositories.TruongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TruongService {
    @Autowired
    public TruongRepository repository;
    public List<Truong> getAllTruong() {
        return repository.findAll();
    }
    public Truong addTruong(Truong truong){
        return repository.save(truong);
    }
    public Truong getTruongById(String id){
        return repository.findById(id).orElse(null);
    }
}
