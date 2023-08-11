package com.felipe.fmconfeitaria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.fmconfeitaria.entities.Cidade;
import com.felipe.fmconfeitaria.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	public List<Cidade> findByEstado(Long estadoId) {
		return cidadeRepository.findCidades(estadoId);
	}

}
