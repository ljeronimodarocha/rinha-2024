package git.ljeronimodarocha.entity;

import git.ljeronimodarocha.entity.enums.TipoTransacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
public class Transacao implements Serializable {

    @Serial
    private static final long serialVersionUID = -7709367662694744897L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @NotNull
    @Positive
    private Long valor;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipo;

    @NotEmpty
    @Size(min = 1, max = 10)
    @Column(length = 10, nullable = false)
    private String descricao;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime realizadaEm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setRealizadaEm(ZonedDateTime realizadaEm) {
        this.realizadaEm = realizadaEm;
    }

    public ZonedDateTime getRealizadaEm() {
        return realizadaEm;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", valor=" + valor +
                ", tipo=" + tipo +
                '}';
    }
}
