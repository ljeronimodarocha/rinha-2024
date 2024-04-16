package git.ljeronimodarocha.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import git.ljeronimodarocha.util.Mapper;

import java.util.List;

public class ExtratoDTO {

    private SaldoDTO saldo;

    @JsonProperty(namespace = "ultimas_transacoes")
    private List<TransacaoDTO> ultimasTransacoes;

    public ExtratoDTO(SaldoDTO saldo, List<TransacaoDTO> transacoes) {
        this.saldo = saldo;
        this.ultimasTransacoes = transacoes;
    }

    public SaldoDTO getSaldo() {
        return saldo;
    }

    public void setSaldo(SaldoDTO saldo) {
        this.saldo = saldo;
    }

    public List<TransacaoDTO> getUltimasTransacoes() {
        return ultimasTransacoes;
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
