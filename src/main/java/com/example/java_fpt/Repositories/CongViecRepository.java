package com.example.java_fpt.Repositories;

import com.example.java_fpt.Model.CongViec;
import com.example.java_fpt.Model.CongViecId;
import com.example.java_fpt.Model.TotNghiep;
import com.example.java_fpt.Model.TotNghiepId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongViecRepository extends JpaRepository<CongViec, CongViecId> {
}