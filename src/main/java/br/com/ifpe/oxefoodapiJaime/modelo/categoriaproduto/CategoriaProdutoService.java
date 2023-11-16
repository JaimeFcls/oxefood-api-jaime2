package br.com.ifpe.oxefoodapiJaime.modelo.categoriaproduto;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaProdutoService {
    @Autowired
    private CategoriaProdutoRepository repository;

    @Transactional
    public CategoriaProduto save(CategoriaProduto categoria) {

        categoria.setHabilitado(Boolean.TRUE);
        categoria.setVersao(1L);
        categoria.setDataCriacao(LocalDate.now());
        return repository.save(categoria);
    }

    public List<CategoriaProduto> findAll() {

        return repository.findAll();
    }

    public CategoriaProduto findById(Long id) {

        return repository.findById(id).get();
    }

    public void update(Long id, CategoriaProduto categoriaAlterado) {

        CategoriaProduto categoria = repository.findById(id).get();
        categoria.setDescricao(categoriaAlterado.getDescricao());

        categoria.setVersao(categoria.getVersao() + 1);
        repository.save(categoria);
    }

    @Transactional
    public void delete(Long id) {

        CategoriaProduto categoria = repository.findById(id).get();
        categoria.setHabilitado(Boolean.FALSE);
        categoria.setVersao(categoria.getVersao() + 1);

        repository.save(categoria);
    }
}