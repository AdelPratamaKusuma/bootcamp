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
@Table(name = ("tbl_motor"))
public class MotorEntity {
    @Id
    @Column(name="id")
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name="name")
    private String name;
    @Column(name="merk")
    private String merk;
    @Column(name="platMtr")
    private String platMtr;
    @Column(name="bahanBakar")
    private String bahanBakar;
    @Column(name = "cc")
    private String cc;
    @Column(name="warna")
    private String warna;
    @Column(name="harga")
    private String harga;
    @Column(name="stock ")
    private String stock;

}
