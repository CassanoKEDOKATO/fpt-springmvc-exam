package com.example.java_fpt.Services;

import com.example.java_fpt.Model.TotNghiep;
import com.example.java_fpt.Repositories.TotNghiepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TotNghiepService {
    @Autowired
    TotNghiepRepository totNghiepRepository;

    public TotNghiep addTotNghiep(TotNghiep totNghiep) {
        return totNghiepRepository.save(totNghiep);
    }

    public List<TotNghiep> findAllTotNghiep() {
        return totNghiepRepository.findAll();
    }
}
