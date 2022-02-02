package com.example.app.repository;

import com.example.app.entity.Español;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EspañolRepository extends JpaRepository<Español, Integer> {
    Optional<Español> findByPalabra(String palabra);
}
