package br.com.ifpe.oxefoodapiJaime.api.fornecedor;

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

import br.com.ifpe.oxefoodapiJaime.modelo.fornecedor.ForncedorService;
import br.com.ifpe.oxefoodapiJaime.modelo.fornecedor.Fornecedor;

@RestController
@RequestMapping("/api/fornecedor")
@CrossOrigin
public class ForncedorController {

   @Autowired
   private ForncedorService fornecedorService;

   @PostMapping
   public ResponseEntity<Fornecedor> save(@RequestBody ForncedorRequest request) {

       Fornecedor fornecedor = fornecedorService.save(request.build());
       return new ResponseEntity<Fornecedor>(fornecedor, HttpStatus.CREATED);
   }
   @GetMapping
    public List<Fornecedor> findAll() {
  
        return fornecedorService.findAll();
    }

    @GetMapping("/{id}")
    public Fornecedor findById(@PathVariable Long id) {

        return fornecedorService.findById(id);
    }
    @PutMapping("/{id}")
   public ResponseEntity<Fornecedor> update(@PathVariable("id") Long id, @RequestBody ForncedorRequest request) {

       fornecedorService.update(id, request.build());
       return ResponseEntity.ok().build();
   }
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       fornecedorService.delete(id);
       return ResponseEntity.ok().build();
   }


}
