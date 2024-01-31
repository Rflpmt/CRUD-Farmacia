package com.generation.farmacia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class produtoController {
	@RestController
	@RequestMapping("/api/produtos")
	public class ProdutoController {
	    @Autowired
	    private CrudRepository produtorepository;
	    
	    
	    
}
}