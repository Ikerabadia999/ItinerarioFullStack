package com.example.app.controller;

import com.example.app.entity.Español;
import com.example.app.entity.Ingles;
import com.example.app.funciones.Funciones;
import com.example.app.objetos.espanol.EspanolOutputDto;
import com.example.app.objetos.espanol.EspanolSimpleOutputDto;
import com.example.app.objetos.ingles.InglesInputDto;
import com.example.app.objetos.ingles.InglesOutputDto;
import com.example.app.objetos.ingles.InglesSimpleOutputDto;
import com.example.app.service.EspañolService;
import com.example.app.service.InglesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/ingles")
public class InglesController {

    @Autowired
    private InglesService inglesService;
    @Autowired
    private EspañolService españolService;

    //Crear nueva palabra
    @CrossOrigin(origins = "http://localhost:4200") //Prueba CORS
    @PostMapping

    public ResponseEntity<?> create(@RequestBody InglesInputDto inglesInputDto){
        Español español = españolService.consultar(inglesInputDto.getIdPalabraEspanol()).get();

        Ingles ingles = new Ingles();
        ingles.setFecha_alta(new Date());
        ingles.setEspanol(español);
        ingles.setPalabra(inglesInputDto.getPalabra());
        español.addTraduccion(ingles);
        return ResponseEntity.status(HttpStatus.CREATED).body(Funciones.inglesToOutputDto(inglesService.añadir(ingles)));
    }

    //Leer una palabra
    /*@CrossOrigin(origins = "http://localhost:4200") //Prueba CORS
    @GetMapping("/{id}") //El parametro que se envia en url debe tener el mismo nombre que el que recibe el metodo
    public ResponseEntity<?> read(@PathVariable int id){
        Optional<Ingles> optIngles = inglesService.consultar(id);

        if(!optIngles.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(Funciones.inglesToOutputDto(optIngles.get()));
    }*/

    //Leer una palabra
    @CrossOrigin(origins = "http://localhost:4200") //Prueba CORS
    @GetMapping("/{palabra}") //El parametro que se envia en url debe tener el mismo nombre que el que recibe el metodo
    public ResponseEntity<?> read(@PathVariable String palabra){
        Optional<Ingles> optIngles = inglesService.findByPalabra(palabra);

        if(!optIngles.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(Funciones.inglesToOutputDto(optIngles.get()));
    }

    //Actualizar una palabra
    @CrossOrigin(origins = "http://localhost:4200") //Prueba CORS
    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody InglesInputDto inglesInputDto, @PathVariable int id){
        Optional<Ingles> optIngles = inglesService.consultar(id);

        if(!optIngles.isPresent()){
            return ResponseEntity.notFound().build();
        }

        optIngles.get().setPalabra(inglesInputDto.getPalabra());
        optIngles.get().setId_palabra_espanol(inglesInputDto.getIdPalabraEspanol());
        optIngles.get().setFecha_modif(new Date());

        return ResponseEntity.status(HttpStatus.CREATED).body(Funciones.inglesToOutputDto(inglesService.añadir(optIngles.get())));
    }

    //Eliminar una palabra
    @CrossOrigin(origins = "http://localhost:4200") //Prueba CORS
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value = "id") int id){

        if(!inglesService.consultar(id).isPresent()){
            return ResponseEntity.notFound().build();
        }

        inglesService.borrar(id);

        return ResponseEntity.ok().build();
    }

    //Obtener todas las palabras en ingles
    @CrossOrigin(origins = "http://localhost:4200") //Prueba CORS
    @GetMapping
    public List<InglesOutputDto> readAll(){
        List<Ingles> palabras = StreamSupport
                .stream(inglesService.consultarTodos().spliterator(), false)
                .collect(Collectors.toList());

        List<InglesOutputDto> listaInglesOutputDto = new ArrayList<InglesOutputDto>();
        for (Ingles i:palabras) {
            InglesOutputDto aux = Funciones.inglesToOutputDto(i);
            aux.setEspanolSimpleOutputDto(Funciones.espanolToSimpleOutputDto(i.getEspanol()));
            listaInglesOutputDto.add(aux);
        }

        return listaInglesOutputDto;
    }



}
