package com.example.app.controller;

import com.example.app.entity.Ingles;
import com.example.app.funciones.Funciones;
import com.example.app.objetos.espanol.EspanolInputDto;
import com.example.app.objetos.espanol.EspanolOutputDto;
import com.example.app.objetos.ingles.InglesSimpleOutputDto;
import com.example.app.service.EspañolService;
import com.example.app.entity.Español;
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
@RequestMapping("/espanol")
public class EspañolController {

    @Autowired
    private EspañolService españolService;

    //Crear nueva palabra
    //@CrossOrigin(origins = "http://localhost:4200") //Prueba CORS
    @PostMapping
    public ResponseEntity<?> create(@RequestBody EspanolInputDto espanolInput){
        return ResponseEntity.status(HttpStatus.CREATED).body(españolService.añadir(Funciones.espanolInputDtoToEspanol(espanolInput)));
    }

    //Leer una palabra
    //@CrossOrigin(origins = "http://localhost:4200") //Prueba CORS
    /*@GetMapping("/{id}") //El parametro que se envia en url debe tener el mismo nombre que el que recibe el metodo
    public ResponseEntity<?> read(@PathVariable int id){
        Optional<Español> optEspañol = españolService.consultar(id);

        if(!optEspañol.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(Funciones.espanolToOutputDto(optEspañol.get()));
    }*/

    //Leer una palabra
    //@CrossOrigin(origins = "http://localhost:4200") //Prueba CORS
    @GetMapping("/{palabra}") //El parametro que se envia en url debe tener el mismo nombre que el que recibe el metodo
    public ResponseEntity<?> read(@PathVariable String palabra){
        Optional<Español> optEspañol = españolService.findByPalabra(palabra);

        if(!optEspañol.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(Funciones.espanolToOutputDto(optEspañol.get()));
    }

    //Actualizar una palabra
    //@CrossOrigin(origins = "http://localhost:4200") //Prueba CORS
    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody EspanolInputDto espanolInputDto, @PathVariable int id){
        Optional<Español> optEspañol = españolService.consultar(id);

        if(!optEspañol.isPresent()){
            return ResponseEntity.notFound().build();
        }

        optEspañol.get().setPalabra(espanolInputDto.getPalabra());
        optEspañol.get().setDescripcion(espanolInputDto.getDescripcion());
        optEspañol.get().setFecha_modif(new Date());

        return ResponseEntity.status(HttpStatus.CREATED).body(Funciones.espanolToOutputDto(españolService.añadir(optEspañol.get())));
    }

    //Eliminar una palabra
    //@CrossOrigin(origins = "http://localhost:4200") //Prueba CORS
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value = "id") int id){

        if(!españolService.consultar(id).isPresent()){
            return ResponseEntity.notFound().build();
        }

        españolService.borrar(id);

        return ResponseEntity.ok().build();
    }

    //Obtener todas las palabras
    //@CrossOrigin(origins = "http://localhost:4200") //Prueba CORS
    @GetMapping
    public List<EspanolOutputDto> readAll(){
        List<Español> palabrasEspanol = StreamSupport
                .stream(españolService.consultarTodos().spliterator(), false)
                .collect(Collectors.toList());

        List<EspanolOutputDto> listaEspanolOutputDto = new ArrayList<EspanolOutputDto>();
        for (Español e:palabrasEspanol) {
            listaEspanolOutputDto.add(Funciones.espanolToOutputDto(e));
        }
        return listaEspanolOutputDto;
    }


}
