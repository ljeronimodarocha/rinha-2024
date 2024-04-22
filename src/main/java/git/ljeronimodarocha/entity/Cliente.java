package git.ljeronimodarocha.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {


    @Serial
    private static final long serialVersionUID = -1862389337151579116L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column
    public BigInteger limite;
    @Column
    private String nome;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Transacao> transacoes;
    @Column
    private BigInteger saldo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getLimite() {
        return limite;
    }

    public void setLimite(BigInteger limite) {
        this.limite = limite;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigInteger getSaldo() {
        return saldo;
    }

    public void setSaldo(BigInteger saldo) {
        this.saldo = saldo;
    }

    public void credita(BigInteger valor) {
        this.saldo.add(valor);
    }

    public void debita(BigInteger valor) {
        this.saldo.subtract(valor);
    }

    public boolean saldoValido() {
        return this.limite.compareTo(this.saldo) >= 0;
    }

    public void adicionarTransacao(Transacao transacao) {
        this.transacoes.add(transacao);
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }
}
