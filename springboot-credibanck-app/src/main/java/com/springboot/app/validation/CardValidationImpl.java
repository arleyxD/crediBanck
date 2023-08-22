package com.springboot.app.validation;

import org.springframework.stereotype.Component;

import com.springboot.app.exception.CardIdValidationException;
import com.springboot.app.exception.InvalidProductIdException;

@Component
public class CardValidationImpl implements CardValidation {
    @Override
    public void validateProductId(String productId) {
        // Lógica de validación del productId
        if (!isValidProductId(productId)) {
            throw new InvalidProductIdException("Invalid product ID");
        }
    }

    private boolean isValidProductId(String productId) {
        // Implementa la lógica de validación del productId aquí
    	return productId != null && productId.length() >= 4; // Por ejemplo, siempre devuelve verdadero en este ejemplo
    }
    
    public void validateCardId(String cardId) {
        if (!isValidCardId(cardId)) {
            throw new CardIdValidationException("Invalid card ID");
        }
    }

    private boolean isValidCardId(String cardId) {
        // Ejemplo de validación simplificada: El cardId debe tener 16 dígitos
        return cardId != null && cardId.matches("\\d{16}");
    }

}
