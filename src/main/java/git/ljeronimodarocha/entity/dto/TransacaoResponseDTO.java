package git.ljeronimodarocha.entity.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import git.ljeronimodarocha.util.Mapper;

public class TransacaoResponseDTO {

    private Long limite;

    private Long saldo;

    public TransacaoResponseDTO(Long limite, Long saldo) {
        this.limite = limite;
        this.saldo = saldo;
    }

    public void setLimite(Long limite) {
        this.limite = limite;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    public Long getLimite() {
        return limite;
    }

    public Long getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        try {
            return Mapper.getMapper()
                    .writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
