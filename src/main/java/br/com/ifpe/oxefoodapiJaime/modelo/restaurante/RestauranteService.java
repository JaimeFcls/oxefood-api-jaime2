package br.com.ifpe.oxefoodapiJaime.modelo.restaurante;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository repository;

    @Transactional
    public Restaurante save(Restaurante restaurante) {

        restaurante.setHabilitado(Boolean.TRUE);
        restaurante.setVersao(1L);
        restaurante.setDataCriacao(LocalDate.now());
        return repository.save(restaurante);
    }

    public List<Restaurante> findAll() {

        return repository.findAll();
    }

    public Restaurante findById(Long id) {

        return repository.findById(id).get();
    }
    @Transactional
    public void update(Long id, Restaurante restauranteAlterado) {
 
       Restaurante restaurante = repository.findById(id).get();
       restaurante.setCnpj(restauranteAlterado.getCnpj());
       restaurante.setNome(restauranteAlterado.getNome());
       restaurante.setValorPedidoMin(restauranteAlterado.getValorPedidoMin());
       
         
       restaurante.setVersao(restaurante.getVersao() + 1);
       repository.save(restaurante);
   }
   @Transactional
   public void delete(Long id) {

       Restaurante restaurante = repository.findById(id).get();
       restaurante.setHabilitado(Boolean.FALSE);
       restaurante.setVersao(restaurante.getVersao() + 1);

       repository.save(restaurante);
   }

}
