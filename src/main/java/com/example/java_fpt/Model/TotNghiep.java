package com.example.java_fpt.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(TotNghiepId.class)
@Table(name = "tot_nghiep")
public class TotNghiep {
    @Id
    @ManyToOne
    @JoinColumn(name = "soCMND", nullable = false)
    private SinhVien sinhVien;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "maTruong", nullable = false)
    private Truong truong;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "maNganh", nullable = false)
    private Nganh nganh;
    @NotBlank(message = "Hệ TN is required")
    @Column(name = "he_tn")
    private String heTN;

    @NotEmpty(message = "Ngày TN is required")
    @Column(name = "ngay_tn")
    private String ngayTN;
    @NotEmpty(message = "Loại TN is required")
    @Column(name = "loai_tn")
    private String loaiTN;

}