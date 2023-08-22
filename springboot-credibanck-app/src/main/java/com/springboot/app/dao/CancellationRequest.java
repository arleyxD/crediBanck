package com.springboot.app.dao;

public class CancellationRequest {
	private String cardId;
    private Long transactionId;

    public String getCardId() {
        return cardId;
    }

    public Long getTransactionId() {
        return transactionId;
    }
}
