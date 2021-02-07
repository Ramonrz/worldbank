package com.github.ramonrz.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaisDto {

    private String id;

    @JsonAlias({ "iso2Code", "codigoPais" })
    private String codigoPais;

    @JsonAlias({ "name", "nome" })
    private String nome;

    @JsonAlias({ "region", "regiao" })
    private RegiaoDto regiao;

    @JsonAlias({ "adminregion", "regiaoAdmin" })
    private RegiaoDto regiaoAdmin;

    @JsonAlias({ "incomeLevel", "nivelDeRenda" })
    private RegiaoDto nivelDeRenda;

    @JsonAlias({ "lendingType", "tipoEmprestimo" })
    private RegiaoDto tipoEmprestimo;

    @JsonAlias({ "capitalCity", "capital" })
    private String capital;

    private String longitude;
    private String latitude;

}