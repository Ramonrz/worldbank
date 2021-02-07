package com.github.ramonrz.worldbank.client;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/v2/country")
@RegisterRestClient
public interface WorldBankCountryClient {

    @GET
    List<Object> getCountries(
            @QueryParam("page") Integer page,
            @DefaultValue("20") @QueryParam("per_page") Integer perPage,
            @DefaultValue("json") @QueryParam("format") String format);

    @GET
    @Path("/{id}/indicator/SI.POV.DDAY")
    List<Object> getIndicators(
            @PathParam("id") String country,
            @QueryParam("page") Integer page,
            @DefaultValue("json") @QueryParam("format") String format,
            @DefaultValue("20") @QueryParam("per_page") Integer perPage);
}