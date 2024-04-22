package git.ljeronimodarocha.validators;


import jakarta.json.bind.serializer.DeserializationContext;
import jakarta.json.bind.serializer.JsonbDeserializer;
import jakarta.json.stream.JsonParser;
import jakarta.validation.UnexpectedTypeException;

import java.lang.reflect.Type;
import java.math.BigInteger;

public class BigIntegerDeserializer implements JsonbDeserializer<BigInteger> {

    @Override
    public BigInteger deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
        String value = parser.getString();

        // Verifica se o valor é um número inteiro sem decimais
        if (!value.matches("^\\d+$")) {
            throw new UnexpectedTypeException("O valor não é um número inteiro sem decimais: " + value);
        }

        return new BigInteger(value);
    }


}