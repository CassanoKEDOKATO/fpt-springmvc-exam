package com.example.java_fpt.Repositories;

import com.example.java_fpt.Model.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien,String> {
}
