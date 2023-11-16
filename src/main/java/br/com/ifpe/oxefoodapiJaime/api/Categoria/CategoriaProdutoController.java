package br.com.ifpe.oxefoodapiJaime.api.Categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefoodapiJaime.modelo.categoriaproduto.CategoriaProduto;
import br.com.ifpe.oxefoodapiJaime.modelo.categoriaproduto.CategoriaProdutoService;



@RestController
@RequestMapping("/api/categoriaproduto")
@CrossOrigin

public class CategoriaProdutoController {
    @Autowired
    private CategoriaProdutoService categoriaProdutoService;

    @PostMapping
    public ResponseEntity<CategoriaProduto> save(@RequestBody CategoriaProdutoRequest request) {

        CategoriaProduto categoria = categoriaProdutoService.save(request.build());
        return new ResponseEntity<CategoriaProduto>(categoria, HttpStatus.CREATED);
    }

    @GetMapping
    public List<CategoriaProduto> findAll() {

        return categoriaProdutoService.findAll();
    }

    @GetMapping("/{id}")
    public CategoriaProduto findById(@PathVariable Long id) {

        return categoriaProdutoService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaProduto> update(@PathVariable("id") Long id,
            @RequestBody CategoriaProdutoRequest request) {
        categoriaProdutoService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoriaProduto> delete(@PathVariable Long id) {

        categoriaProdutoService.delete(id);
        return ResponseEntity.ok().build();

    }
}