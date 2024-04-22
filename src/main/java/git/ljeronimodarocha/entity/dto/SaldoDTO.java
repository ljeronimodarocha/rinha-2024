package git.ljeronimodarocha.entity.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import git.ljeronimodarocha.util.Mapper;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

@JsonbPropertyOrder({"total", "dataExtrato", "limite"})
public class SaldoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -2790242516836923234L;
    private BigInteger total;
    @JsonbProperty(value = "data_extrato")
    private LocalDateTime dataExtrato;
    private BigInteger limite;

    public SaldoDTO(BigInteger total, LocalDateTime dataExtrato, BigInteger limite) {
        this.total = total;
        this.dataExtrato = dataExtrato;
        this.limite = limite;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    public LocalDateTime getDataExtrato() {
        return dataExtrato;
    }

    public void setDataExtrato(LocalDateTime dataExtrato) {
        this.dataExtrato = dataExtrato;
    }

    public BigInteger getLimite() {
        return limite;
    }

    public void setLimite(BigInteger limite) {
        this.limite = limite;
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
