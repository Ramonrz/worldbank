package com.github.ramonrz.resources;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.github.ramonrz.dto.ResponseIndicadorDto;
import com.github.ramonrz.dto.ResponsePaisDto;

@Path("/paises")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@Tag(name = "Países", description = "Serviços para acessar informações de países na API World Bank")
public interface PaisResource {

    @GET
    @Operation(description = "Busca países", operationId = "Busca países na API World Bank", summary = "Busca países na API World Bank")
    @APIResponse(name = "OK", responseCode = "200", description = "Sucesso", content = {
            @Content(mediaType = APPLICATION_JSON, //
                    schema = @Schema(implementation = ResponsePaisDto.class)) })
    @APIResponse(name = "Internal Server Error", responseCode = "500", description = "Erro interno no servidor")
    Response consultarPaises(@QueryParam("pagina") Integer pagina);

    @GET
    @Path("/indicadores/{pais}")
    @Operation(description = "Busca indicadores", operationId = "Busca indicadores de um país na API World Bank", summary = "Busca indicadores de um país na API World Bank")
    @APIResponse(name = "OK", responseCode = "200", description = "Sucesso", content = {
            @Content(mediaType = APPLICATION_JSON, //
                    schema = @Schema(implementation = ResponseIndicadorDto.class)) })
    @APIResponse(name = "Internal Server Error", responseCode = "500", description = "Erro interno no servidor")
    Response consultarIndicadoresPais(
            @PathParam("pais") String pais,
            @QueryParam("pagina") Integer pagina);

}