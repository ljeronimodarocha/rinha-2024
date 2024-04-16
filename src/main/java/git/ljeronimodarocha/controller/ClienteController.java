package git.ljeronimodarocha.controller;

import git.ljeronimodarocha.entity.dto.ExtratoDTO;
import git.ljeronimodarocha.entity.dto.TransacaoRequest;
import git.ljeronimodarocha.entity.dto.TransacaoResponseDTO;
import git.ljeronimodarocha.services.ClienteService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/clientes")
public class ClienteController {


    private static final Logger logger = org.jboss.logging.Logger.getLogger(ClienteController.class);


    private ClienteService clienteService;

    @Inject
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @POST
    @Path("/{id}/transacoes")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<TransacaoResponseDTO> efetuaTransacao(Long id, @Valid TransacaoRequest transacao) {
        TransacaoResponseDTO response = this.clienteService.salvarTransacao(id, transacao);
        return RestResponse.ResponseBuilder
                .ok(
                        response)
                .build();
    }

    @GET
    @Path("/{id}/extrato")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<ExtratoDTO> extrato(Long id) {
        ExtratoDTO extratoDTO = this.clienteService.buscaExtrato(id);
        return RestResponse.ResponseBuilder.ok(extratoDTO).build();
    }

}
