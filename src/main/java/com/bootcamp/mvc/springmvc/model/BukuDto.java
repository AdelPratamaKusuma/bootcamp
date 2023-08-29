package com.bootcamp.mvc.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BukuDto {
    private Integer id;
    private String code;
    private String judul;
    private String pengarang;
    private String tahunTerbit;
    private String jmlhHalaman;
    private String penerbit;
    private String bahasa;
    private String deskripsi;
    private Integer harga;
    private Integer stock;
}
