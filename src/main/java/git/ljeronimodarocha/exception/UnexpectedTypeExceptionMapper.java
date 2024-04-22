package git.ljeronimodarocha.exception;


import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.bind.JsonbException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class UnexpectedTypeExceptionMapper implements ExceptionMapper<JsonbException> {

    @Context
    UriInfo uriInfo;

    @Override
    public Response toResponse(final JsonbException exception) {


        JsonObject jsonError = Json.createObjectBuilder()
                .add("class", exception.getClass().toString())
                .add("field", exception.getCause().toString())
                .add("violationMessage", exception.getMessage())
                .build();


        return Response.status(422).entity(jsonError).build();
    }
}