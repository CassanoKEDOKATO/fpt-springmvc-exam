package com.example.java_fpt.Services;

import com.example.java_fpt.Model.Nganh;
import com.example.java_fpt.Model.Truong;
import com.example.java_fpt.Repositories.NganhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NganhService {
   @Autowired
   public NganhRepository repository;
    public List<Nganh> getAllNganh() {
        return repository.findAll();
    }
    public Nganh addNganh(Nganh Nganh){
        return repository.save(Nganh);
    }
    public Nganh getNganhById(String id){
        return repository.findById(id).orElse(null);
    }
}
