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
@Table(name = "nganh")
public class Nganh {
    @Id
    @Column(name = "ma_nganh", nullable = false)
    private String maNganh;

    @Column(name = "ten_nganh")
    private String tenNganh;

    @Column(name = "loai_nganh")
    private String loaiNganh;
    @OneToMany(mappedBy = "nganh", cascade = CascadeType.ALL)
    private List<CongViec> congViecList = new ArrayList<>();
    @OneToMany(mappedBy = "nganh", cascade = CascadeType.ALL)
    private List<TotNghiep> totNghiepList = new ArrayList<>();

}