package com.felipe.fmconfeitaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.fmconfeitaria.entities.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{

}
