package br.com.ifpe.oxefoodapiJaime.modelo.cliente;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
@Query(value = "SELECT c FROM Cliente c WHERE c.cpf = :cpf AND c.nome = :nome")
  List<Cliente> findByCpfAndNome(String cpf, String nome);

  @Query(value = "SELECT c FROM Cliente c WHERE c.cpf = :cpf")
  List<Cliente> findByCpf(String cpf);

  @Query(value = "SELECT c FROM Cliente c WHERE c.nome = :nome")
  List<Cliente> findByNome(String nome);
}
