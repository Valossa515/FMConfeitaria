package com.felipe.fmconfeitaria.entities;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class ItemPedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPK Id = new ItemPedidoPK();
	private Double desconto;
	private Integer quantidade;
	private Double preco;

	public ItemPedido() {
		
	}

	public ItemPedido(ItemPedidoPK id, Double desconto, Integer quantidade, Double preco) {
		super();
		this.Id = id;
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public ItemPedidoPK getId() {
		return Id;
	}

	public void setId(ItemPedidoPK id) {
		this.Id = id;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Pedido getPedido()
	{
		return Id.getPedido();
	}
	
	public void setPedido(Pedido pedido)
	{
		Id.setPedido(pedido);
	}
	public Produto getProduto()
	{
		return Id.getProduto();
	}
	public void setProduto(Produto produto)
	{
		Id.setProduto(produto);
	}
	
	public double getSubTotal()
	{
		return (preco - desconto) * quantidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(desconto, Id, preco, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(desconto, other.desconto) && Objects.equals(Id, other.Id)
				&& Objects.equals(preco, other.preco) && Objects.equals(quantidade, other.quantidade);
	}
	
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
		StringBuilder builder = new StringBuilder();
		builder.append(getProduto().getNome());
		builder.append(", Qte: ");
		builder.append(getQuantidade());
		builder.append(", Preço unitário: ");
		builder.append(getPreco());
		builder.append(", Subtotal: ");
		builder.append(nf.format(getSubTotal()));
		builder.append("\n");
		return builder.toString();
	}
}
