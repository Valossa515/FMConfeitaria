package com.felipe.fmconfeitaria.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.fmconfeitaria.dto.CidadeDTO;
import com.felipe.fmconfeitaria.dto.EstadoDTO;
import com.felipe.fmconfeitaria.entities.Cidade;
import com.felipe.fmconfeitaria.entities.Estado;
import com.felipe.fmconfeitaria.services.CidadeService;
import com.felipe.fmconfeitaria.services.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {
	@Autowired
	private EstadoService estadoService;
	@Autowired
	private CidadeService cidadeService;
	
	
	@GetMapping
	public ResponseEntity<List<EstadoDTO>> findAll() {
		List<Estado> list = estadoService.findAll();
		List<EstadoDTO> listdto = list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listdto);
	}
	
	@GetMapping(value="/{estadoId}/cidades")
		public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Long estadoId) {
			List<Cidade> list = cidadeService.findByEstado(estadoId);
			List<CidadeDTO> listDto = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(listDto);
	}
			
}
