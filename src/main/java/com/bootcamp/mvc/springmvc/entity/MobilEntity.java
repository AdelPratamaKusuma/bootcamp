package com.bootcamp.mvc.springmvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_mobil")
public class MobilEntity {
    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="code")
    private String code;
    @Column(name="name")
    private String name;
    @Column(name="merk")
    private String merk;
    @Column(name="platNmr")
    private String platNmr;
    @Column(name="bahanBakar")
    private String bahanBakar;
    @Column(name="cc")
    private String cc;
    @Column(name="warna")
    private String warna;
    @Column(name ="tipe")
    private String tipe;
    @Column(name="harga")
    private Integer harga;
    @Column(name="stock")
    private Integer stock;
}
