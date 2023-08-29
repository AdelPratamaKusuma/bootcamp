package com.bootcamp.mvc.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MuridBaruDto {
    private Integer id;
    private String name;
    private String jenisKelamin;
    private String alamat;
    private String asalSekolah;

}
