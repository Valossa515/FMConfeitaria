package com.felipe.fmconfeitaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.fmconfeitaria.entities.Categoria;
import com.felipe.fmconfeitaria.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaContoller {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> find(@PathVariable Long id){
		Categoria obj = categoriaService.find(id);
		return ResponseEntity.ok().body(obj);
	}
}