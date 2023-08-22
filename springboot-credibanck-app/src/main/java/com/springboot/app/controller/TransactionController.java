package com.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.dao.TransactionRequest;
import com.springboot.app.model.Transaction;
import com.springboot.app.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
    private TransactionService transactionService;

    @PostMapping("/purchase")
    public ResponseEntity<String> performPurchaseTransaction(@RequestBody TransactionRequest request) {
        transactionService.performPurchaseTransaction(request.getCardId(), request.getPrice());
        return ResponseEntity.ok("Purchase transaction successful");
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable Long transactionId) {
        Transaction transaction = transactionService.getTransactionById(transactionId);
        return ResponseEntity.ok(transaction);
    }
}
