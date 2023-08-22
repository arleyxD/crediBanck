package com.springboot.app.dao;

public class TransactionRequest {
	private String cardId;
    private double price;

    public String getCardId() {
        return cardId;
    }

    public double getPrice() {
        return price;
    }
}
