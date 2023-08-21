package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Métodos personalizados de consulta si es necesario
}