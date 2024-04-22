package git.ljeronimodarocha.entity.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import git.ljeronimodarocha.util.Mapper;

import java.math.BigInteger;

public class TransacaoResponseDTO {

    private BigInteger limite;

    private BigInteger saldo;

    public TransacaoResponseDTO(BigInteger limite, BigInteger saldo) {
        this.limite = limite;
        this.saldo = saldo;
    }

    public void setLimite(BigInteger limite) {
        this.limite = limite;
    }

    public void setSaldo(BigInteger saldo) {
        this.saldo = saldo;
    }

    public BigInteger getLimite() {
        return limite;
    }

    public BigInteger getSaldo() {
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
