package com.github.ramonrz.resources.impl;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static org.eclipse.microprofile.metrics.MetricUnits.MILLISECONDS;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

import com.github.ramonrz.resources.PaisResource;
import com.github.ramonrz.services.PaisService;

public class PaisResourceImpl implements PaisResource {

    @Inject
    PaisService paisService;

    @Override
    @Counted(name = "performedChecksBuscaPaises", description = "Buscas paises World Bank")
    @Timed(name = "checksTimerBuscaPaises", description = "Tempo execucao busca paises World Bank", unit = MILLISECONDS)
    public Response consultarPaises(Integer pagina) {
        return Response.ok(paisService.consultarPaises(pagina)).build();
    }

    @Override
    @Counted(name = "performedChecksIndicadorPais", description = "Buscas indicador pais World Bank")
    @Timed(name = "checksTimerIndicadorPais", description = "Tempo execucao indicador pais World Bank", unit = MILLISECONDS)
    public Response consultarIndicadoresPais(String pais, Integer pagina) {
        return Response.ok(paisService.consultarIndicadoresPais(pais, pagina)).build();
    }

}