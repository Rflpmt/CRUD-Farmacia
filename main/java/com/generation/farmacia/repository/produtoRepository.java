package com.generation.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.farmacia.model.produto;

@Repository
public interface produtoRepository extends JpaRepository<produto, Long> {
}