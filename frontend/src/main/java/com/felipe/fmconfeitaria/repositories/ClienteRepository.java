package com.felipe.fmconfeitaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.fmconfeitaria.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
