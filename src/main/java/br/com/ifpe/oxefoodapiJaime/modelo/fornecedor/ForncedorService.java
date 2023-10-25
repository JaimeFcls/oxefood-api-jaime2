package br.com.ifpe.oxefoodapiJaime.modelo.fornecedor;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForncedorService {

    @Autowired
    private ForncedorRepository repository;

    @Transactional
    public Fornecedor save(Fornecedor fornecedor) {

        fornecedor.setHabilitado(Boolean.TRUE);
        fornecedor.setVersao(1L);
        fornecedor.setDataCriacao(LocalDate.now());
        return repository.save(fornecedor);
    }

    public List<Fornecedor> findAll() {

        return repository.findAll();
    }

    public Fornecedor findById(Long id) {

        return repository.findById(id).get();
    }
    @Transactional
    public void update(Long id, Fornecedor fornecedorAlterado) {
 
       Fornecedor fornecedor = repository.findById(id).get();
       fornecedor.setEndereco(fornecedorAlterado.getEndereco());
       fornecedor.setNome(fornecedorAlterado.getNome());
       fornecedor.setDataFundacao(fornecedorAlterado.getDataFundacao());
       fornecedor.setPaginaWeb(fornecedorAlterado.getPaginaWeb());
       fornecedor.setValorMercado(fornecedorAlterado.getValorMercado());
       fornecedor.setContatoVendedor(fornecedorAlterado.getContatoVendedor());
       
         
       fornecedor.setVersao(fornecedor.getVersao() + 1);
       repository.save(fornecedor);
   }
   @Transactional
   public void delete(Long id) {

       Fornecedor fornecedor = repository.findById(id).get();
       fornecedor.setHabilitado(Boolean.FALSE);
       fornecedor.setVersao(fornecedor.getVersao() + 1);

       repository.save(fornecedor);
   }

}
