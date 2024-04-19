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
public class JsonbExceptionMapper implements ExceptionMapper<JsonbException> {

    @Context
    UriInfo uriInfo;

    @Override
    public Response toResponse(final JsonbException exception) {

        final var jsonObject = Json.createObjectBuilder()
                .add("host", uriInfo.getAbsolutePath().getHost())
                .add("resource", uriInfo.getAbsolutePath().getPath())
                .add("title", "Validation Errors");

        String className = exception.getClass().toString().split("@")[0];
        String message = exception.getMessage();

        JsonObject jsonError = Json.createObjectBuilder()
                .add("class", className)
                .add("violationMessage", message)
                .build();

        JsonObject errorJsonEntity = jsonObject.add("errors", jsonError).build();

        return Response.status(422).entity(errorJsonEntity).build();
    }
}