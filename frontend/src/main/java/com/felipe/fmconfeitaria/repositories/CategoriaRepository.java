package com.felipe.fmconfeitaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.fmconfeitaria.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
