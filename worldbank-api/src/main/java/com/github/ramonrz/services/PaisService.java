package com.github.ramonrz.services;

import static com.github.ramonrz.dto.PaginacaoDto.QUANTIDADE_POR_PAGINA;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ramonrz.dto.IndicadorDto;
import com.github.ramonrz.dto.PaginacaoDto;
import com.github.ramonrz.dto.PaginacaoIndicadorDto;
import com.github.ramonrz.dto.PaisDto;
import com.github.ramonrz.dto.ResponseIndicadorDto;
import com.github.ramonrz.dto.ResponsePaisDto;
import com.github.ramonrz.worldbank.client.WorldBankCountryClient;

@RequestScoped
@Transactional(TxType.NOT_SUPPORTED)
public class PaisService {

    @Inject
    @RestClient
    WorldBankCountryClient worldBankCountryClient;
    
    private ObjectMapper mapper;

    public ResponsePaisDto consultarPaises(Integer pagina) {

        List<Object> objects = worldBankCountryClient.getCountries(pagina, QUANTIDADE_POR_PAGINA, APPLICATION_JSON_TYPE.getSubtype());
        PaginacaoDto paginacao = getMapper().convertValue(objects.get(0), new TypeReference<PaginacaoDto>() {
        });
        List<PaisDto> paises = getMapper().convertValue(objects.get(1), new TypeReference<List<PaisDto>>() {
        });
        return ResponsePaisDto.builder().paginacao(paginacao).paises(paises).build();
    }

    public ResponseIndicadorDto consultarIndicadoresPais(String pais, Integer pagina) {

        List<Object> objects = worldBankCountryClient.getIndicators(pais, pagina, APPLICATION_JSON_TYPE.getSubtype(), QUANTIDADE_POR_PAGINA);
        PaginacaoIndicadorDto paginacao = getMapper().convertValue(objects.get(0), new TypeReference<PaginacaoIndicadorDto>() {
        });
        List<IndicadorDto> indicadores = getMapper().convertValue(objects.get(1), new TypeReference<List<IndicadorDto>>() {
        });
        return ResponseIndicadorDto.builder().paginacao(paginacao).indicadores(indicadores).build();
    }

    protected ObjectMapper getMapper() {
        if (mapper == null) {
            mapper = new ObjectMapper();
        }
        return mapper;
    }    

}