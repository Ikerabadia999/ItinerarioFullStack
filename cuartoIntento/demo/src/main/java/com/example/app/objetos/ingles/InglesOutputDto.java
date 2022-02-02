package com.example.app.objetos.ingles;

import com.example.app.entity.Español;
import com.example.app.objetos.espanol.EspanolSimpleOutputDto;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InglesOutputDto {
    private int id;
    private String palabra;
    private Date fechaAlta;
    private Date fechaModificacion;
    private EspanolSimpleOutputDto espanolSimpleOutputDto;
}
