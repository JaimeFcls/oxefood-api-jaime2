package br.com.ifpe.oxefoodapiJaime.api.restaurante;

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


import br.com.ifpe.oxefoodapiJaime.modelo.restaurante.Restaurante;
import br.com.ifpe.oxefoodapiJaime.modelo.restaurante.RestauranteService;

@RestController
@RequestMapping("/api/restaurante")
@CrossOrigin
public class RestauranteController {

   @Autowired
   private RestauranteService restauranteService;

   @PostMapping
   public ResponseEntity<Restaurante> save(@RequestBody RestauranteRequest request) {

       Restaurante restaurante = restauranteService.save(request.build());
       return new ResponseEntity<Restaurante>(restaurante, HttpStatus.CREATED);
   }
   @GetMapping
    public List<Restaurante> findAll() {
  
        return restauranteService.findAll();
    }

    @GetMapping("/{id}")
    public Restaurante findById(@PathVariable Long id) {

        return restauranteService.findById(id);
    }
    @PutMapping("/{id}")
   public ResponseEntity<Restaurante> update(@PathVariable("id") Long id, @RequestBody RestauranteRequest request) {

       restauranteService.update(id, request.build());
       return ResponseEntity.ok().build();
   }
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       restauranteService.delete(id);
       return ResponseEntity.ok().build();
   }


}
