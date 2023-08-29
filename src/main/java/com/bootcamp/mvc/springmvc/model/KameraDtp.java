package com.bootcamp.mvc.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KameraDtp {
    private Integer id;
    private String code;
    private String name;
    private String merk;
    private String sensor;
    private String price;
    private String fitur;
    private String lensa;
    private String aksesoris;
}
