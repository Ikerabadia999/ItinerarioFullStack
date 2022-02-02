package com.example.app.objetos.espanol;

import com.example.app.objetos.ingles.InglesSimpleOutputDto;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EspanolOutputDto {
    private int id;
    private String palabra;
    private String descripcion;
    private Date fechaAlta;
    private Date fechaModificacion;
    private List<InglesSimpleOutputDto> palabrasIngles;
}
