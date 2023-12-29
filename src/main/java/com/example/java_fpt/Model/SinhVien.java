package com.example.java_fpt.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_sinh_vien")
public class SinhVien {
    @Id
    @Column(name = "so_cmnd", nullable = false)
    private String soCMND;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "email")
    private String email;

    @Column(name = "so_dt")
    private String soDT;

    @Column(name = "dia_chi")
    private String diaChi;


    @OneToMany(mappedBy = "sinhVien", cascade = CascadeType.ALL)
    private List<TotNghiep> totNghiepList = new ArrayList<>();
    @OneToMany(mappedBy = "sinhVien", cascade = CascadeType.ALL)
    private List<CongViec>  congViecList = new ArrayList<>();

}