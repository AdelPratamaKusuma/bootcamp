package com.bootcamp.mvc.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaptopDto {
    private Integer id;
    private String code;
    private String name;
    private String ram;
    private String procesor;
    private String storage;
    private String os;
    private String layar;
    private String dimensi;
    private String warna;
    private String rilis;
    private Integer harga;
    private Integer stock;
}
