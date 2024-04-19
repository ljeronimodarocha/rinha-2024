package git.ljeronimodarocha;


import jakarta.json.bind.serializer.DeserializationContext;
import jakarta.json.bind.serializer.JsonbDeserializer;
import jakarta.json.stream.JsonParser;
import jakarta.validation.UnexpectedTypeException;

import java.lang.reflect.Type;

public class LongDeserializer implements JsonbDeserializer<Long> {

    @Override
    public Long deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
        String value = parser.getString();

        // Verifica se o valor é um número inteiro sem decimais
        if (!value.matches("^\\d+$")) {
            throw new UnexpectedTypeException("O valor não é um número inteiro sem decimais: " + value);
        }

        return Long.parseLong(value);
    }


}