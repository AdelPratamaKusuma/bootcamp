package com.bootcamp.mvc.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuruDto {
    private Integer id;
    private String code;
    private String name;
    private String jenisKelamin;
    private String mapel;

}
