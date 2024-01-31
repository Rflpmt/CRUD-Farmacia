package com.generation.farmacia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.farmacia.model.categoria;

@RestController
@RequestMapping("/api/categorias")
public class categoriaController {
    private final CrudRepository categoriaRepository;

    categoriaController(CrudRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public ResponseEntity<categoria> criarCategoria(@RequestBody categoria categoria) {
        categoria novaCategoria = categoriaRepository.save(categoria);
        return new ResponseEntity<>(novaCategoria, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<categoria>> listarCategorias() {
        List<categoria> categorias = categoriaRepository.findAll();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<categoria> getCategoriaById(@PathVariable Long id) {
        Optional<categoria> categoriaOptional = categoriaRepository.findById(id);
        return categoriaOptional.map(categoria -> new ResponseEntity<>(categoria, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<categoria> atualizarCategoria(@PathVariable Long id, @RequestBody categoria novaCategoria) {
        Optional<categoria> categoriaOptional = categoriaRepository.findById(id);
        if (categoriaOptional.isPresent()) {
            categoria categoria = categoriaOptional.get();
            categoria.setNome(novaCategoria.getNome());
            categoriaRepository.save(categoria);
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        Optional<categoria> categoriaOptional = categoriaRepository.findById(id);
        if (categoriaOptional.isPresent()) {
            categoriaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping
    public ResponseEntity<Void> deletarTodasCategorias() {
        categoriaRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
