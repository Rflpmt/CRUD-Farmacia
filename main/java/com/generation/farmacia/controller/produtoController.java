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

import com.generation.farmacia.model.produto;
import com.generation.farmacia.repository.produtoRepository;

public class produtoController {
	@RestController
	@RequestMapping("/api/produtos")
	public class ProdutoController {
	    @Autowired
	    private CrudRepository produtorepository;
	    
	    @PostMapping
	    public ResponseEntity<produto> criarProduto(@RequestBody produto produto) {
	        produto novoProduto = produtoRepository.save(produto);
	        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
	    }
	    
	    @GetMapping
	    public ResponseEntity<List<produto>> listarProdutos() {
	        List<produto> produtos = produtoRepository.findAll();
	        return new ResponseEntity<>(produtos, HttpStatus.OK);
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<produto> getProdutoById(@PathVariable Long id) {
	        Optional<produto> produtoOptional = produtoRepository.findById(id);
	        return produtoOptional.map(produto -> new ResponseEntity<>(produto, HttpStatus.OK))
	                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<produto> atualizarProduto(@PathVariable Long id, @RequestBody produto novoProduto) {
	        Optional<produto> produtoOptional = produtoRepository.findById(id);
	        if (produtoOptional.isPresent()) {
	            produto produto = produtoOptional.get();
	            produto.setNome(novoProduto.getNome());
	            produto.setPreco(novoProduto.getPreco());
	            produto.setCategoria(novoProduto.getCategoria());
	            produtoRepository.save(produto);
	            return new ResponseEntity<>(produto, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
	        Optional<produto> produtoOptional = produtoRepository.findById(id);
	        if (produtoOptional.isPresent()) {
	            produtoRepository.deleteById(id);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    @DeleteMapping
	    public ResponseEntity<Void> deletarTodosProdutos() {
	        produtoRepository.deleteAll();
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	}        
}
