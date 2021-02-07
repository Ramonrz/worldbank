package com.github.ramonrz.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IndicadorItemDto {

    private String id;

    @JsonAlias({ "value", "valor" })
    private String valor;
}