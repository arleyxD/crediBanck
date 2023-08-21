package com.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Card;

public interface CardRepository extends JpaRepository<Card, String> {
    // Métodos personalizados de consulta si es necesario
}