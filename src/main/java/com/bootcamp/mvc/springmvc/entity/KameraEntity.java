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
@Table(name="tbl_kamera")
public class KameraEntity {
    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name="merk")
    private String merk;
    @Column(name="sensor")
    private String sensor;
    @Column(name="price")
    private String price;
    @Column(name="fitur")
    private String fitur;
    @Column(name="lensa")
    private String lensa;
    @Column(name="aksesoris")
    private String aksesoris;
}
