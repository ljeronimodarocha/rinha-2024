package git.ljeronimodarocha.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.Serial;

public class UnprocessableEntityException extends WebApplicationException {

    @Serial
    private static final long serialVersionUID = 7595008808111006605L;

    public UnprocessableEntityException(String message) {
        super(Response.status(422)
                .entity(new UnprocessableEntity(message))
                .type(MediaType.APPLICATION_JSON)
                .build());
    }


}

