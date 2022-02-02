package com.example.app.service;

import com.example.app.entity.Español;
import com.example.app.entity.Ingles;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface InglesService {
    public Ingles añadir(Ingles ingles);
    public void borrar(int id);
    public Optional<Ingles> consultar(int id);
    public List<Ingles> consultarTodos();
    public Optional<Ingles> findByPalabra(String palabra);
}
