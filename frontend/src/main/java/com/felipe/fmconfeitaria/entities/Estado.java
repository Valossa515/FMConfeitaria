package com.felipe.fmconfeitaria.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

@Entity
public class Estado implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	private String nome;
	@OneToMany(mappedBy = "estado")
	@JsonIgnore
	private List<Cidade> cidades = new ArrayList<>();
	
	public Estado() {
		
	}
	public Estado(Long id, String nome) {
		super();
		this.Id = id;
		this.nome = nome;
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
	public List<Cidade> getCidades() {
		return cidades;
	}
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Id, cidades, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(cidades, other.cidades)
				&& Objects.equals(nome, other.nome);
	}
}
