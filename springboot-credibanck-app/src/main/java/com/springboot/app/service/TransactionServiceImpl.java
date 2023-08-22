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
	
	@Override
    @Transactional
    public void cancelTransaction(String cardId, Long transactionId) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new CustomException("Card not found"));

        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new CustomException("Transaction not found"));

        if (!card.isActive()) {
            throw new CustomException("Card is not active");
        }

        if (!transaction.getTransactionType().equals("purchase")) {
            throw new CustomException("Only purchase transactions can be canceled");
        }

        Date now = new Date();
        long diffInMilliseconds = now.getTime() - transaction.getTransactionDate().getTime();
        long diffInHours = diffInMilliseconds / (60 * 60 * 1000);

        if (diffInHours > 24) {
            throw new CustomException("Transaction cannot be canceled after 24 hours");
        }

        double transactionAmount = transaction.getTransactionAmount();
        double currentBalance = card.getBalance();
        double newBalance = currentBalance + transactionAmount;

        card.setBalance(newBalance);
        transaction.setTransactionType("canceled");
        cardRepository.save(card);
        transactionRepository.save(transaction);
    }
}
