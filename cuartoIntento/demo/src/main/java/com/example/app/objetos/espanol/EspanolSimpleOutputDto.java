package com.example.app.objetos.espanol;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EspanolSimpleOutputDto {
    private int id;
    private String palabra;
    private String descripcion;
    private Date fechaAlta;
    private Date fechaModificacion;
}
