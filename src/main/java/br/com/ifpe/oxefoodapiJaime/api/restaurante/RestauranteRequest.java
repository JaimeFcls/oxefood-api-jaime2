package br.com.ifpe.oxefoodapiJaime.api.restaurante;

import br.com.ifpe.oxefoodapiJaime.modelo.restaurante.Restaurante;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestauranteRequest {

    private String nome;

    private String cnpj;

    private Double valorPedidoMin;
   

   public Restaurante build() {

       return Restaurante.builder()
               .nome(nome)
               .cnpj(cnpj)
               .valorPedidoMin(valorPedidoMin)              
               .build();
   }
}
