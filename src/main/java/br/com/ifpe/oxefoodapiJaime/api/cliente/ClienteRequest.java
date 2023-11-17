package br.com.ifpe.oxefoodapiJaime.api.cliente;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefoodapiJaime.modelo.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

    private String nome;

    @NotBlank(message = "O Email é de preenchimento obrigatório")
    @Email
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String cpf;

    private String foneCelular;

    private String foneFixo;

    public Cliente build() {

        return Cliente.builder()
            .email(email)
            .nome(nome)
            .dataNascimento(dataNascimento)
            .cpf(cpf)
            .foneCelular(foneCelular)
            .foneFixo(foneFixo)
            .build();
    }

}