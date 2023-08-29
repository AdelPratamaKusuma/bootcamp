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
@Table(name="tbl_buku")
public class BukuEntity {
    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="code")
    private String code;
    @Column(name="judul")
    private String judul;
    @Column(name="pengerang")
    private String pengarang;
    @Column(name="tahunTerbit")
    private String tahunTerbit;
    @Column(name="jmlhHalaman")
    private String jmlhHalaman;
    @Column(name="penerbit")
    private String penerbit;
    @Column(name="bahasa")
    private String bahasa;
    @Column(name="deskripsi")
    private String deskripsi;
    @Column(name="harga")
    private Integer harga;
    @Column(name="stock")
    private Integer stock;
}
