package com.felipe.fmconfeitaria.dto;

import java.io.Serializable;

public class ProdutoDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Double preco;
	
	
	public ProdutoDTO() {
		
	}


	public ProdutoDTO(Long id, String nome, Double preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	
	
}
