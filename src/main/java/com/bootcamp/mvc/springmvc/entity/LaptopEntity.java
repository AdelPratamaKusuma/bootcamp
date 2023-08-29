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
@Table(name="tbl_laptop")
public class LaptopEntity {
    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="code")
    private String code;
    @Column(name="name")
    private String name;
    @Column(name="ram")
    private String ram;
    @Column(name="procesor")
    private String procesor;
    @Column(name="storage")
    private String storage;
    @Column(name="os")
    private String os;
    @Column(name="layar")
    private String layar;
    @Column(name="dimensi")
    private String dimensi;
    @Column(name="warna")
    private String warna;
    @Column(name="rilis")
    private String rilis;
    @Column(name="harga")
    private Integer harga;
    @Column(name="stock")
    private Integer stock;
}
