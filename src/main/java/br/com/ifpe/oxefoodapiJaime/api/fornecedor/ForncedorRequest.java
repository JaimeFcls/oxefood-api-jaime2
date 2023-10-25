package br.com.ifpe.oxefoodapiJaime.api.fornecedor;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefoodapiJaime.modelo.fornecedor.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ForncedorRequest {

    private String nome;

    private String endereco;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFundacao;

    private String paginaWeb;

    private Double valorMercado;

    private String contatoVendedor;

    public Fornecedor build() {

        return Fornecedor.builder()
                .nome(nome)
                .endereco(endereco)
                .dataFundacao(dataFundacao)
                .paginaWeb(paginaWeb)
                .valorMercado(valorMercado)
                .contatoVendedor(contatoVendedor)
                .build();
    }
}
