package com.example.app.service;

import com.example.app.entity.Español;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EspañolService {

    public Español añadir(Español espanol);
    public void borrar(int id);
    public Optional<Español> consultar(int id);
    public List<Español> consultarTodos();
    public Optional<Español> findByPalabra(String palabra);

}
