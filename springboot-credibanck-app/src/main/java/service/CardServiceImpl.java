package service;

import org.springframework.beans.factory.annotation.Autowired;

import model.Card;
import repository.CardRepository;
import validation.CardValidation;

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
