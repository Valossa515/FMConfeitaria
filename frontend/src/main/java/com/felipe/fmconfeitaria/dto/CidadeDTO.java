package com.felipe.fmconfeitaria.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.felipe.fmconfeitaria.entities.Cidade;

import jakarta.validation.constraints.NotNull;

public class CidadeDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long Id;
	@NotNull(message = "Preenchimento obrigatório!")
	@Length(min = 5, max = 200, message = "O tamanho deve ser entre 5 e 200 caracteres!!!")
	private String nome;
	
	public CidadeDTO() {
		
	}

	public CidadeDTO(Long id, String nome) {
		Id = id;
		this.nome = nome;
	}
	
	public CidadeDTO(Cidade obj)
	{
		Id = obj.getId();
		nome = obj.getNome();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
