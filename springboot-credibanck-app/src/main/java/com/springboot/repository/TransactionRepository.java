package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Métodos personalizados de consulta si es necesario
}