package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.model.Card;
import com.springboot.repository.CardRepository;
import com.springboot.validation.CardValidation;

public class CardServiceImpl implements CardService{
	
	 @Autowired
	 private CardRepository cardRepository;

	 @Autowired
	 private CardValidation cardValidation;
	

	@Override
	public Card generateCardNumber(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Card enrollCard(String cardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Card blockCard(String cardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Card rechargeBalance(String cardId, double balance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double checkBalance(String cardId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
