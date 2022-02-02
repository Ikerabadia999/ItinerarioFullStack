package com.example.app.funciones;

import com.example.app.entity.Español;
import com.example.app.entity.Ingles;
import com.example.app.objetos.espanol.EspanolInputDto;
import com.example.app.objetos.espanol.EspanolOutputDto;
import com.example.app.objetos.espanol.EspanolSimpleOutputDto;
import com.example.app.objetos.ingles.InglesOutputDto;
import com.example.app.objetos.ingles.InglesSimpleOutputDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Funciones {
    public static InglesOutputDto inglesToOutputDto(Ingles ingles){
        InglesOutputDto inglesOutputDto = new InglesOutputDto();

        inglesOutputDto.setFechaModificacion(ingles.getFecha_modif());
        inglesOutputDto.setFechaAlta(ingles.getFecha_alta());
        inglesOutputDto.setId(ingles.getId());
        inglesOutputDto.setPalabra(ingles.getPalabra());
        inglesOutputDto.setEspanolSimpleOutputDto(espanolToSimpleOutputDto(ingles.getEspanol()));

        return inglesOutputDto;
    }

    public static EspanolSimpleOutputDto espanolToSimpleOutputDto(Español espanol){
        EspanolSimpleOutputDto espanolSimpleOutputDto = new EspanolSimpleOutputDto();

        espanolSimpleOutputDto.setFechaAlta(espanol.getFecha_alta());
        espanolSimpleOutputDto.setId(espanol.getId());
        espanolSimpleOutputDto.setPalabra(espanol.getPalabra());
        espanolSimpleOutputDto.setFechaModificacion(espanol.getFecha_modif());
        espanolSimpleOutputDto.setDescripcion(espanol.getDescripcion());

        return  espanolSimpleOutputDto;
    }

    public static List<InglesSimpleOutputDto> conversionTraducciones(List<Ingles> palabrasIngles){

        List<InglesSimpleOutputDto> listaInglesSimple = new ArrayList<InglesSimpleOutputDto>();

        for (Ingles i:palabrasIngles) {
            InglesSimpleOutputDto aux = new InglesSimpleOutputDto();

            aux.setId(i.getId());
            aux.setPalabra(i.getPalabra());
            aux.setFechaAlta(i.getFecha_alta());
            aux.setFechaModificacion(i.getFecha_modif());

            listaInglesSimple.add(aux);
        }

        return listaInglesSimple;
    }

    public static EspanolOutputDto espanolToOutputDto(Español español){

        EspanolOutputDto espanolOutputDto = new EspanolOutputDto();
        espanolOutputDto.setPalabra(español.getPalabra());
        espanolOutputDto.setId(español.getId());
        espanolOutputDto.setDescripcion(español.getDescripcion());
        espanolOutputDto.setFechaAlta(español.getFecha_alta());
        espanolOutputDto.setFechaModificacion(español.getFecha_modif());
        espanolOutputDto.setPalabrasIngles(conversionTraducciones(español.getTraducciones()));

        return espanolOutputDto;
    }

    public static Español espanolInputDtoToEspanol(EspanolInputDto espanolInputDto){
        Español español = new Español();
        español.setFecha_alta(new Date());
        español.setPalabra(espanolInputDto.getPalabra());
        español.setDescripcion(espanolInputDto.getDescripcion());

        return español;
    }
}
