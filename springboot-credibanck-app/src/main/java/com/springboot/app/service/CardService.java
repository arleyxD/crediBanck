package com.springboot.app.service;

import com.springboot.app.model.Card;

public interface CardService {
    Card generateCardNumber(String productId);
    Card enrollCard(String cardId);
    Card blockCard(String cardId);
    Card rechargeBalance(String cardId, double balance);
    double checkBalance(String cardId);
}