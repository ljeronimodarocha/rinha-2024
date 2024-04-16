package git.ljeronimodarocha.services;

import git.ljeronimodarocha.entity.Cliente;
import git.ljeronimodarocha.entity.Transacao;
import git.ljeronimodarocha.entity.dto.*;
import git.ljeronimodarocha.entity.enums.TipoTransacao;
import git.ljeronimodarocha.exception.UnprocessableEntityException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClienteService {

    private EntityManager em;

    @Inject
    public ClienteService(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public TransacaoResponseDTO salvarTransacao(Long id, TransacaoRequest dto) {
        Optional<Cliente> cliente = this.clienteById(id);
        if (cliente.isPresent()) {
            Transacao transacao = new Transacao();
            transacao.setCliente(cliente.get());
            transacao.setRealizadaEm(ZonedDateTime.now());
            transacao.setValor(dto.valor());
            transacao.setTipo(dto.tipo());
            transacao.setDescricao(dto.descricao());
            if (transacao.getTipo().equals(TipoTransacao.c)) {
                cliente.get().credita(transacao.getValor());
            } else if (transacao.getTipo().equals(TipoTransacao.d)) {
                cliente.get().debita(transacao.getValor());
            }
            if (!cliente.get().saldoValido()) {
                throw new UnprocessableEntityException("Valor excede valor limite");
            }
            cliente.get().adicionarTransacao(transacao);
            em.persist(cliente.get());
            return new TransacaoResponseDTO(cliente.get().getLimite(), cliente.get().getSaldo());
        }
        throw new NotFoundException("Cliente nao encontrado");
    }

    public ExtratoDTO buscaExtrato(Long id) {
        Optional<Cliente> cliente = this.clienteById(id);
        if (cliente.isPresent()) {

            TypedQuery<Transacao> query = em
                    .createQuery(
                            "SELECT t FROM Transacao t WHERE t.cliente.id = :id ORDER BY t.realizadaEm",
                            Transacao.class)
                    .setParameter("id", id);
            List<Transacao> listaTransacoes = query.setMaxResults(10).getResultList();

            List<TransacaoDTO> transacoes = listaTransacoes.stream()
                    .map(t -> new TransacaoDTO(t.getValor(), t.getTipo(), t.getDescricao(), t.getRealizadaEm())).toList();
            return new ExtratoDTO(
                    new SaldoDTO(
                            cliente.get().getSaldo(),
                            LocalDateTime.now(),
                            cliente.get().getLimite()),
                    transacoes
            );
        }
        throw new NotFoundException();
    }

    public Optional<Cliente> clienteById(Long id) {
        Cliente cliente = em.find(Cliente.class, id);
        return Optional.ofNullable(cliente);
    }
}
