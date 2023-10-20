package br.com.ifpe.oxefoodapiJaime.modelo.restaurante;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import br.com.ifpe.oxefoodapiJaime.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Restaurante")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Restaurante extends EntidadeAuditavel  {

   @Column
   private String nome;

   @Column
   private String cnpj;

   @Column
   private Double valorPedidoMin;

}
