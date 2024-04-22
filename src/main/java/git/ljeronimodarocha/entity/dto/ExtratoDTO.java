package git.ljeronimodarocha.entity.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import git.ljeronimodarocha.util.Mapper;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;

import java.util.List;

@JsonbPropertyOrder({"saldo", "ultimas_transacoes"})
public class ExtratoDTO {

    private SaldoDTO saldo;

    @JsonbProperty("ultimas_transacoes")
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

    @JsonbProperty("ultimas_transacoes")
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
