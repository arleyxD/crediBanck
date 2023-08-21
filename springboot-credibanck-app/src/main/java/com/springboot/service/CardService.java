package com.springboot.service;

import com.springboot.model.Card;

public interface CardService {
    Card generateCardNumber(String productId);
    Card enrollCard(String cardId);
    Card blockCard(String cardId);
    Card rechargeBalance(String cardId, double balance);
    double checkBalance(String cardId);
}