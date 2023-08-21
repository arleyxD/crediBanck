package validation;

public class CardValidationImpl implements CardValidation {
    @Override
    public void validateProductId(String productId) {
        // Lógica de validación del productId
        if (!isValidProductId(productId)) {
           // throw new InvalidProductIdException("Invalid product ID");
        }
    }

    private boolean isValidProductId(String productId) {
        // Implementa la lógica de validación del productId aquí
        return true; // Por ejemplo, siempre devuelve verdadero en este ejemplo
    }

}
