package git.ljeronimodarocha.entity.dto;

import git.ljeronimodarocha.BigIntegerDeserializer;
import git.ljeronimodarocha.entity.enums.TipoTransacao;
import git.ljeronimodarocha.validators.StringOnly;
import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.Length;

import java.math.BigInteger;

public record TransacaoRequest(
        @NotNull @PositiveOrZero @JsonbTypeDeserializer(value = BigIntegerDeserializer.class) BigInteger valor,
        @NotNull TipoTransacao tipo,
        @StringOnly
        @NotEmpty @NotBlank @Length(min = 1, max = 10) String descricao) {

}
