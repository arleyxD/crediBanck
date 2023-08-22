package com.springboot.app.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.exception.CustomException;
import com.springboot.app.model.Card;
import com.springboot.app.model.Transaction;
import com.springboot.app.repository.CardRepository;
import com.springboot.app.repository.TransactionRepository;

import jakarta.transaction.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
    private CardRepository cardRepository;

    @Autowired
    private TransactionRepository transactionRepository;

	@Override
	@Transactional
    public void performPurchaseTransaction(String cardId, double price) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new CustomException("Card not found"));

        if (!card.isActive()) {
            throw new CustomException("Card is not active");
        }

        double balance = card.getBalance();
        if (balance < price) {
            throw new CustomException("Insufficient balance");
        }

        // Realizar la transacción de compra
        double newBalance = balance - price;
        card.setBalance(newBalance);
        cardRepository.save(card);

        // Registrar la transacción
        Transaction transaction = new Transaction();
        transaction.setCardId(cardId);
        transaction.setTransactionDate(new Date());
        transaction.setTransactionAmount(price);
        transaction.setTransactionType("purchase");
        transactionRepository.save(transaction);
    }

	
	@Override
    public Transaction getTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId)
                .orElseThrow(() -> new CustomException("Transaction not found"));
    }
}
