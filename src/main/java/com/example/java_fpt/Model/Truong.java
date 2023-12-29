package com.example.java_fpt.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "truong")
public class Truong {
    @Id
    @Column(name = "ma_truong", nullable = false)
    private String maTruong;

    @Column(name = "ten_truong")
    private String tenTruong;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "so_dt")
    private String soDT;

    @OneToMany(mappedBy = "truong", cascade = CascadeType.ALL)
    private List<TotNghiep> totNghiepList = new ArrayList<>();
}