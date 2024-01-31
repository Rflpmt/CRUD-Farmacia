package com.generation.farmacia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;

	public Object getNome1() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setNome(Object nome2) {
		// TODO Auto-generated method stub
		
	}

	public Object getNome() {
		// TODO Auto-generated method stub
		return null;
	}

}
