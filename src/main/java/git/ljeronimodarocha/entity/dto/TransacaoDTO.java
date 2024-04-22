package git.ljeronimodarocha.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import git.ljeronimodarocha.entity.enums.TipoTransacao;
import git.ljeronimodarocha.util.Mapper;

import java.math.BigInteger;
import java.time.ZonedDateTime;

@JsonPropertyOrder({"valor", "tipo", "descricao", "realizadaEm"})
public class TransacaoDTO {

    private BigInteger valor;
    private TipoTransacao tipo;
    private String descricao;
    @JsonProperty("realizada_em")
    private ZonedDateTime realizadaEm;

    public TransacaoDTO(BigInteger valor, TipoTransacao tipo, String descricao, ZonedDateTime realizadaEm) {
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
        this.realizadaEm = realizadaEm;
    }

    public BigInteger getValor() {
        return valor;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    @JsonProperty(namespace = "realizada_em", value = "realizada_em")
    public ZonedDateTime getRealizadaEm() {
        return realizadaEm;
    }

    @Override
    public String toString() {
        try {
            return Mapper.getMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
