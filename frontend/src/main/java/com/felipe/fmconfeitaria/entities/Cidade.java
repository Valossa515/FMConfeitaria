package com.felipe.fmconfeitaria.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cidade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nome;
	@ManyToOne
	@JoinColumn(name = "estado_Id")
	private Estado estado;
	
	public Cidade() {
		
	}
	
	public Cidade(Long id, String nome, Estado estado) {
		super();
		this.Id = id;
		this.nome = nome;
		this.estado = estado;
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, estado, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(estado, other.estado) && Objects.equals(nome, other.nome);
	}
}
