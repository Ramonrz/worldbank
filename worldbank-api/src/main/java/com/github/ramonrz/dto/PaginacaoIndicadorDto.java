package com.github.ramonrz.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginacaoIndicadorDto extends PaginacaoDto {

    @JsonProperty("sourceid")
    private String sourceId;

    @JsonAlias({ "lastupdated", "ultimaAtualizacao" })
    private String ultimaAtualizacao;

}