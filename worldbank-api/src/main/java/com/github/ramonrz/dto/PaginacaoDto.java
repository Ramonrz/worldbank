package com.github.ramonrz.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginacaoDto {
    
    public static final Integer QUANTIDADE_POR_PAGINA = 10;

    @JsonAlias({ "page", "pagina" })
    private Integer pagina;
    
    @JsonAlias({ "pages", "paginas" })
    private Integer paginas;
    
    @JsonAlias({ "total", "registros" })
    private Integer registros;

    @JsonAlias({ "per_page", "qtdPorPagina" })
    private Integer qtdPorPagina;
}