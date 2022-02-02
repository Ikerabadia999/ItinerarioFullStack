package com.example.app.service;

import com.example.app.repository.EspañolRepository;
import com.example.app.entity.Español;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EspañolServiceImpl implements EspañolService {

    @Autowired
    private EspañolRepository españolRepository;

    @Override
    @Transactional
    public Español añadir(Español espanol) {
        return españolRepository.save(espanol);
    }

    @Override
    @Transactional
    public void borrar(int id) {
        españolRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Español> consultar(int id) {
        return españolRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Español> consultarTodos() {
        return españolRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Español> findByPalabra(String palabra) {
        return españolRepository.findByPalabra(palabra);
    }
}
