package com.example.app.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Español")
public class Español {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Column(unique=true)
    private String palabra;
    private String descripcion;
    @NotNull
    private Date fecha_alta;
    private Date fecha_modif;
    private boolean activo;
    private int id_editorial;
    private int id_autor;

    @OneToMany(mappedBy = "espanol", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Ingles> traducciones;

    public void addTraduccion(Ingles ingles){
        this.traducciones.add(ingles);
    }
}
