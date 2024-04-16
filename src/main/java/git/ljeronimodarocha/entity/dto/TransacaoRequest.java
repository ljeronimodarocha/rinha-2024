package git.ljeronimodarocha.entity.dto;

import git.ljeronimodarocha.entity.enums.TipoTransacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record TransacaoRequest(
        @NotNull Long valor,
        @NotNull TipoTransacao tipo,
        @NotBlank @Length(min = 1, max = 10) String descricao) {

}
