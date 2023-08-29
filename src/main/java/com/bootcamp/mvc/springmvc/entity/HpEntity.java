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
@Table(name="tbl_hp")
public class HpEntity {
    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="code", length = 20)
    private String code;
    @Column(name="name", length = 120)
    private String name;
    @Column(name="ram")
    private String ram;
    @Column(name="baterai")
    private String baterai;
    @Column(name="storage")
    private String storage;
    @Column(name="layar")
    private String layar;
    @Column(name="warna")
    private String warna;
    @Column(name = "dimensi")
    private String dimensi;
    @Column(name="rilis")
    private String rilis;
    @Column(name="harga")
    private Integer harga;
    @Column(name = "stock")
    private Integer stock;
}
