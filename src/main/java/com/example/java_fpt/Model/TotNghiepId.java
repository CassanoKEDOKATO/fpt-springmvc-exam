package com.example.java_fpt.Model;


import jakarta.persistence.*;

import java.io.Serializable;
@Embeddable
@IdClass(TotNghiepId.class)
public class TotNghiepId implements Serializable {
    private SinhVien sinhVien;
    private Truong truong;
    private Nganh nganh;

}