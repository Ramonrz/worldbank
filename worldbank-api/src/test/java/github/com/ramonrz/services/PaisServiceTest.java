package github.com.ramonrz.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.ramonrz.dto.PaginacaoDto;
import com.github.ramonrz.dto.PaginacaoIndicadorDto;
import com.github.ramonrz.dto.ResponseIndicadorDto;
import com.github.ramonrz.dto.ResponsePaisDto;
import com.github.ramonrz.services.PaisService;
import com.github.ramonrz.worldbank.client.WorldBankCountryClient;

@ExtendWith(MockitoExtension.class)
class PaisServiceTest {

    @InjectMocks
    private PaisService paisService;

    @Mock
    private WorldBankCountryClient worldBankCountryClient;

    @Test
    void consultarPaisesTest() {

        PaginacaoDto paginacao = new PaginacaoDto();
        paginacao.setPagina(1);
        paginacao.setPaginas(30);
        ResponsePaisDto dto = ResponsePaisDto.builder().paginacao(paginacao).build();

        when(worldBankCountryClient.getCountries(anyInt(), anyInt() ,anyString()))
                .thenReturn(Arrays.asList(dto.getPaginacao(), dto.getPaises()));

        ResponsePaisDto paises = paisService.consultarPaises(1);

        assertNull(paises.getPaises());
        assertNotNull(paises.getPaginacao());
    }

    @Test
    void consultarIndicadoresPaisTest() {

        PaginacaoIndicadorDto paginacao = new PaginacaoIndicadorDto();
        paginacao.setPagina(1);
        paginacao.setPaginas(30);
        ResponseIndicadorDto dto = ResponseIndicadorDto.builder().paginacao(paginacao).build();

        when(worldBankCountryClient.getIndicators(anyString(), anyInt(), anyString(), anyInt()))
                .thenReturn(Arrays.asList(dto.getPaginacao(), dto.getIndicadores()));

        ResponseIndicadorDto paises = paisService.consultarIndicadoresPais("FRA", 1);

        assertNull(paises.getIndicadores());
        assertNotNull(paises.getPaginacao());
    }

}