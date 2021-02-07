package com.github.ramonrz.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegiaoDto {

    @JsonProperty("id")
    private String id;

    @JsonAlias({ "iso2code", "codigoPais" })
    private String codigoPais;

    @JsonAlias({ "value", "valor" })
    private String valor;
    
}