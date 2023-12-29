package com.example.java_fpt.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@IdClass(CongViecId.class)
@Table(name = "cong_viec")
public class CongViec {

    @Id
    @Column(name = "ngay_vao_cty")
    private String ngayVaoCty;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "soCMND", nullable = false)
    private SinhVien sinhVien;

    @ManyToOne(optional = false)
    @JoinColumn(name = "maNganh",nullable = false)
    private Nganh nganh;

    @Column(name = "ten_cong_viec")
    private String tenCongViec;

    @Column(name = "ten_cty")
    private String tenCty;

    @Column(name = "dia_chi_cty")
    private String diaChiCty;

    @Column(name = "thoi_gian_lam_viec")
    private String thoiGianLamViec;

}