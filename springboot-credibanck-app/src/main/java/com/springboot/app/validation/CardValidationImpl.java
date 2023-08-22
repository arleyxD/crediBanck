package com.springboot.app.validation;

public class CardValidationImpl implements CardValidation {
    @Override
    public void validateProductId(String productId) {
        // Lógica de validación del productId
        if (!isValidProductId(productId)) {
           // throw new InvalidProductIdException("Invalid product ID");
        	System.out.println("Error validacion tarjeta");
        }
    }

    private boolean isValidProductId(String productId) {
        // Implementa la lógica de validación del productId aquí
    	return productId != null && productId.length() >= 4; // Por ejemplo, siempre devuelve verdadero en este ejemplo
    }

}
