package com.felipe.fmconfeitaria.entities;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date instante;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	private Pagamento pagamento;
	@ManyToOne
	@JoinColumn(name = "cliente_Id")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "endereco_Id")
	private Endereco endereco;
	@OneToMany(mappedBy = "Id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();
	
	public Pedido(){
		
	}
	
	public Pedido(Long id, Date instante, Cliente cliente, Endereco endereco) {
		super();
		this.Id = id;
		this.instante = instante;
		this.cliente = cliente;
		this.endereco = endereco;
	}
	
	public double getValorTotal(){
		double soma = 0.0;
		for(ItemPedido ip : itens)
		{
			soma = soma + ip.getSubTotal();
		}
		return soma;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, cliente, endereco, instante, itens, pagamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(cliente, other.cliente)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(instante, other.instante)
				&& Objects.equals(itens, other.itens) && Objects.equals(pagamento, other.pagamento);
	}
	
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido Número: ");
		builder.append(getId());
		builder.append(", Instante: ");
		builder.append(sdf.format(getInstante()));
		builder.append(", Cliente: ");
		builder.append(getCliente().getNome());
		builder.append(", Situação do pagamento: ");
		builder.append(getPagamento().getEstado().getDescricao());
		builder.append("\n Detalhes \n");
		for(ItemPedido p : getItens())
		{
			builder.append(p.toString());
		}
		builder.append("Valor total: ");
		builder.append(nf.format(getValorTotal()));
		return builder.toString();
	}
	
}
