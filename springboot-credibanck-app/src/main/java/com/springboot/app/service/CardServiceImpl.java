package com.springboot.app.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.exception.CardIdValidationException;
import com.springboot.app.model.Card;
import com.springboot.app.repository.CardRepository;
import com.springboot.app.validation.CardValidation;

@Service
public class CardServiceImpl implements CardService{
	
	 @Autowired
	 private CardRepository cardRepository;

	 @Autowired
	 private CardValidation cardValidation;
	

	@Override
	public Card generateCardNumber(String productId) {
		cardValidation.validateProductId(productId);
		  // Lógica para generar el número de tarjeta
        String generatedCardNumber = generateRandomCardNumber(productId);

        // Crear una nueva tarjeta
        Card newCard = new Card();
        newCard.setCardId(generatedCardNumber);
        newCard.setProductId(productId);
        newCard.setCardNumber(generatedCardNumber);
        newCard.setExpirationDate(calculateExpirationDate());
        newCard.setActive(false); // La tarjeta se crea inactiva por defecto
        newCard.setBalance(0.0);

        // Persistencia del objeto Card en la base de datos
        return cardRepository.save(newCard);
	}

	@Override
	public Card enrollCard(String cardId) {
		cardValidation.validateCardId(cardId); // Validación del cardId

        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new CardIdValidationException("Card not found"));

        if (card.isActive()) {
            throw new CardIdValidationException("Card is already active");
        }

        card.setActive(true);
        cardRepository.save(card);

        return card;
	}

	@Override
	public Card blockCard(String cardId) {
		cardValidation.validateCardId(cardId); // Validación del cardId

        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new CardIdValidationException("Card not found"));

        if (!card.isActive()) {
            throw new CardIdValidationException("Card is not active");
        }

        card.setActive(false);
        cardRepository.save(card);

        return card;
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
	
	
	private String generateRandomCardNumber(String productId) {
	    // Obtén los primeros 6 dígitos del productId para formar el prefijo del número de tarjeta
	    String prefix = productId.substring(0, Math.min(productId.length(), 6));
	    // Genera 10 dígitos aleatorios para completar el número de tarjeta
	    String randomDigits = generateRandomDigits(10);
	    // Combina el prefijo y los dígitos aleatorios para formar el número de tarjeta completo
	    String cardNumber = prefix + randomDigits;

	    return cardNumber;
	}

	private String generateRandomDigits(int length) {
	    StringBuilder stringBuilder = new StringBuilder();
	    Random random = new Random();
	    for (int i = 0; i < length; i++) {
	        int digit = random.nextInt(10);
	        stringBuilder.append(digit);
	    }

	    return stringBuilder.toString();
	}
	
	 private Date calculateExpirationDate() {
	        Calendar calendar = Calendar.getInstance();
	        calendar.add(Calendar.YEAR, 3); // Agrega 3 años a la fecha actual
	        return calendar.getTime();
	    }

}
