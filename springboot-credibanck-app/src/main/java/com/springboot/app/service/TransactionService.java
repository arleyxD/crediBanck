package com.springboot.app.service;

import com.springboot.app.model.Transaction;

public interface TransactionService {
	void performPurchaseTransaction(String cardId, double price);
	Transaction getTransactionById(Long transactionId);
	void cancelTransaction(String cardId, Long transactionId);
}