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
@Table(name="tbl_muridBaru")
public class MuridBaruEntity {
    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="jenisKelamin")
    private String jenisKelamin;
    @Column(name="alamat")
    private String alamat;
    @Column(name="asalSekolah")
    private String asalSekolah;
}
