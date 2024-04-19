package git.ljeronimodarocha.entity.dto;

import git.ljeronimodarocha.LongDeserializer;
import git.ljeronimodarocha.entity.enums.TipoTransacao;
import git.ljeronimodarocha.validators.StringOnly;
import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public record TransacaoRequest(
        @NotNull @Positive @JsonbTypeDeserializer(value = LongDeserializer.class) Long valor,
        @NotNull TipoTransacao tipo,
        @StringOnly
        @NotEmpty @NotBlank @Length(min = 1, max = 10) String descricao) {

}
