package com.felipe.fmconfeitaria.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	private String nome;
	private Double preco;
	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIA",
		joinColumns = @JoinColumn(name = "produto_Id"),
		inverseJoinColumns = @JoinColumn(name = "categoria_Id")
	)
	@JsonIgnore
	private List<Categoria> categorias = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "Id.produto")
	private Set<ItemPedido> itens = new HashSet<>();

	@JsonIgnore
	public List<Pedido> getPedidos()
	{
		List<Pedido> lista = new ArrayList<>();
		
		for(ItemPedido x : itens)
		{
			lista.add(x.getPedido());
		}
		return lista;
	}
	public Produto()
	{
		
	}

	public Produto(Long id, String nome, Double preco) {
		super();
		this.Id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}
	
}
