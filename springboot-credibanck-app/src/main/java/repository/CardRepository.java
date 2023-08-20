package repository;


import org.springframework.data.jpa.repository.JpaRepository;

import model.Card;

public interface CardRepository extends JpaRepository<Card, String> {
    // Métodos personalizados de consulta si es necesario
}