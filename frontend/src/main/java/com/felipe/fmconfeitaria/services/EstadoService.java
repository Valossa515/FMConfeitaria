package com.felipe.fmconfeitaria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.fmconfeitaria.entities.Estado;
import com.felipe.fmconfeitaria.repositories.EstadoRepository;

@Service
public class EstadoService {
	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<Estado> findAll()
	{
		return estadoRepository.findAllByOrderByNome();
	}
}
