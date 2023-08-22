package com.springboot.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.model.Card;

public interface CardRepository extends JpaRepository<Card, String> {
    // Métodos personalizados de consulta si es necesario
}