package com.example.app.service;

import com.example.app.entity.Español;
import com.example.app.entity.Ingles;
import com.example.app.repository.EspañolRepository;
import com.example.app.repository.InglesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InglesServiceImpl implements InglesService{

    @Autowired
    private InglesRepository inglesRepository;

    @Override
    @Transactional
    public Ingles añadir(Ingles ingles) {
        return inglesRepository.save(ingles);
    }

    @Override
    @Transactional
    public void borrar(int id) {
        inglesRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Ingles> consultar(int id) {
        return inglesRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ingles> consultarTodos() {
        return inglesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Ingles> findByPalabra(String palabra) {
        return inglesRepository.findByPalabra(palabra);
    }
}
