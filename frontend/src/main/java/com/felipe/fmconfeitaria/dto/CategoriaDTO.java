package com.felipe.fmconfeitaria.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.felipe.fmconfeitaria.entities.Categoria;

import jakarta.validation.constraints.NotNull;

public class CategoriaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long Id;
	@NotNull(message = "Preenchimento obrigatório!")
	@Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 e 80 caracteres!!!")
	private String nome;
	
	public CategoriaDTO(){
		
	}
	public CategoriaDTO(Categoria obj)
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
