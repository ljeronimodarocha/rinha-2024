package git.ljeronimodarocha.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Mapper {

    public static ObjectMapper getMapper() {
        return new ObjectMapper().registerModule(new JavaTimeModule())
                .configure(SerializationFeature.INDENT_OUTPUT, false);
    }

    Mapper() {
        throw new IllegalStateException("Utility class");
    }
}
