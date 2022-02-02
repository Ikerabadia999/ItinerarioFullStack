package com.example.app.repository;

import com.example.app.entity.Español;
import com.example.app.entity.Ingles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InglesRepository extends JpaRepository<Ingles, Integer> {
    Optional<Ingles> findByPalabra(String palabra);
}
