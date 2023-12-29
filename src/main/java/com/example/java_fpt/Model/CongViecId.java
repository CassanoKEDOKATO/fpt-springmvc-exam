package com.example.java_fpt.Model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.IdClass;

import java.io.Serializable;

@Embeddable
@IdClass(CongViecId.class)
public class CongViecId implements Serializable {
    private SinhVien sinhVien;
    private String ngayVaoCty;
}
