package com.bootcamp.mvc.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotorDto {
    private Integer id;
    private String code;
    private String name;
    private String merk;
    private String platMtr;
    private String bahanBakar;
    private String cc;
    private String warna;
    private String harga;
    private String stock;

}
