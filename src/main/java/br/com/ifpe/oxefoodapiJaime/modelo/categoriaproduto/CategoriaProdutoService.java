package br.com.ifpe.oxefoodapiJaime.modelo.categoriaproduto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaProdutoService {

    @Autowired
    private CategoriaProdutoRepository repository;

    @Transactional
    public CategoriaProduto save(CategoriaProduto categoriaProduto) {
        categoriaProduto.setHabilitado(Boolean.TRUE);
        categoriaProduto.setVersao(1L);
        categoriaProduto.setDataCriacao(LocalDate.now());
        return repository.save(categoriaProduto);
    }

    public List<CategoriaProduto> listarTodos() {
        return repository.findAll();
    }

    public CategoriaProduto obterPorID(Long id) {
        Optional<CategoriaProduto> optionalCategoriaProduto = repository.findById(id);
        return optionalCategoriaProduto.orElse(null);
    }

    @Transactional
    public void update(Long id, CategoriaProduto categoriaProdutoAlterado) {
        Optional<CategoriaProduto> optionalCategoriaProduto = repository.findById(id);

        if (optionalCategoriaProduto.isPresent()) {
            CategoriaProduto categoriaProduto = optionalCategoriaProduto.get();
            categoriaProduto.setDescricao(categoriaProdutoAlterado.getDescricao());
            categoriaProduto.setVersao(categoriaProduto.getVersao() + 1);
            repository.save(categoriaProduto);
        }
    }

    @Transactional
    public void delete(Long id) {
        Optional<CategoriaProduto> optionalCategoriaProduto = repository.findById(id);

        if (optionalCategoriaProduto.isPresent()) {
            CategoriaProduto categoriaProduto = optionalCategoriaProduto.get();
            categoriaProduto.setHabilitado(Boolean.FALSE);
            categoriaProduto.setVersao(categoriaProduto.getVersao() + 1);
            repository.save(categoriaProduto);
        }
    }
}
