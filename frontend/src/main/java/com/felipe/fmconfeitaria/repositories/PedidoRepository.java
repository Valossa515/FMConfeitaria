package com.felipe.fmconfeitaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.fmconfeitaria.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
