package com.example.app.entity;

import lombok.*;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Ingles")
public class Ingles {
    @Id
    @GeneratedValue
    private int id;
    private String palabra;
    private int id_palabra_espanol;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="español_id", referencedColumnName="id")
    private Español espanol;
    private Date fecha_alta;
    private Date fecha_modif;


}
