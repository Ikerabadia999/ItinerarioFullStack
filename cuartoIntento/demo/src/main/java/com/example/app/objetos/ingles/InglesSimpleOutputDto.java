package com.example.app.objetos.ingles;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InglesSimpleOutputDto {
    private int id;
    private String palabra;
    private Date fechaAlta;
    private Date fechaModificacion;
}
