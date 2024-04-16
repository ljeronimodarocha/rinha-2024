package git.ljeronimodarocha.entity.enums;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.EnumSet;
import java.util.Map;
import java.util.TreeMap;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoTransacaoError {
    CREDITO("c"),
    DEBITO("d");

    TipoTransacaoError(String value) {
        this.value = value;
    }

    private final String value;

    private static final Map<String, TipoTransacaoError> mapString = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    static {
        for (final TipoTransacaoError type : EnumSet.allOf(TipoTransacaoError.class)) {
            mapString.put(type.getValue().toLowerCase(), type);
        }
    }

    @JsonCreator
    public static TipoTransacaoError entryOf(final String type) {
        return (type == null || type.isBlank()) ? null : mapString.get(type.toLowerCase());
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
