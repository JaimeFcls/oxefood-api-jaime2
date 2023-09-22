
package br.com.ifpe.oxefoodapiJaime.api.entregador;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefoodapiJaime.modelo.entregador.Entregador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {

   private String nome;

   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate dataNascimento;

   private String cpf;

   private String foneCelular;

   private String foneFixo;

   private String rg;

   private int qtdEntregasRealizadas;

   private double valorFrete;

   private String enderecoRua;

   private String enderecoNumero;

   private String enderecoBairro;

   private String enderecoCidade;

   private String enderecoCep;

   private String enderecoUf;

   private String enderecoComplemento;

   private Boolean ativo;

   public Entregador build() {

       return Entregador.builder()
               .nome(nome)
               .dataNascimento(dataNascimento)
               .cpf(cpf)
               .foneCelular(foneCelular)
               .foneFixo(foneFixo)
               .rg(rg)
               .qtdEntregasRealizadas(qtdEntregasRealizadas)
               .valorFrete(valorFrete)
               .enderecoRua(enderecoRua)
               .enderecoNumero(enderecoNumero)
               .enderecoBairro(enderecoBairro)
               .enderecoCidade(enderecoCidade)
               .enderecoCep(enderecoCep)
               .enderecoUf(enderecoUf)
               .enderecoComplemento(enderecoComplemento)
               .ativo(ativo)
               .build();
   }
}
