package com.generation.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.farmacia.model.categoria;

@Repository
public interface categoriaRepository extends JpaRepository<categoria, Long> {
}