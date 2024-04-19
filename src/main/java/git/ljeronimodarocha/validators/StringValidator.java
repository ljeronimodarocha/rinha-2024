package git.ljeronimodarocha.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;
import java.util.Collection;

public class StringValidator implements ConstraintValidator<StringOnly, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // `@NotNull` deve ser usado para checar nulo
        }

        if (value instanceof String valueString) {
            return isNumeric(valueString);
        } else if (value instanceof Collection<?> collection) {
            return collection.stream().allMatch(item -> item instanceof String itemString && isNumeric(itemString));
        }

        return false; // Não é um tipo suportado
    }

    private boolean isNumeric(String str) {
        try {
            new BigDecimal(str);
            return false; // É um número
        } catch (NumberFormatException e) {
            return true; // Não é um número, é uma string
        }


    }
}