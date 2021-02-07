package com.github.ramonrz.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IndicadorDto {

    @JsonAlias({ "indicator", "indicador" })
    private IndicadorItemDto indicador;

    @JsonAlias({ "country", "pais" })
    private IndicadorItemDto pais;

    @JsonAlias({ "countryiso3code", "codigoPais" })
    private String codigoPais;

    @JsonAlias({ "date", "data" })
    private String data;

    @JsonAlias({ "value", "valor" })
    private String valor;

    @JsonAlias({ "unit", "unidade" })
    private String unidade;

    @JsonProperty("obs_status")
    private String obsStatus;

    private Integer decimal;
}