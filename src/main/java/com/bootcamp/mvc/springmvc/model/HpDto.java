package com.bootcamp.mvc.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HpDto {
    private Integer id;
    private String code;
    private String name;
    private String ram;
    private String baterai;
    private String storage;
    private String layar;
    private String warna;
    private String dimensi;
    private String rilis;
    private Integer harga;
    private Integer stock;
}
