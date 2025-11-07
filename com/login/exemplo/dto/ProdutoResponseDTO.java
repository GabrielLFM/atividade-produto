package com.login.exemplo.dto;

import com.login.exemplo.entity.Produto;

public class ProdutoResponseDTO {
	
	private int id;
	private String nome;
	private double preco;
	private int quantidade;
	private double subTotal;
	
	public ProdutoResponseDTO(Produto prod) {
		this.id = prod.getId();
		this.nome = prod.getNome();
		this.preco = prod.getPreco();
		this.quantidade = prod.getQuantidade();
		this.subTotal = prod.getPreco() * prod.getQuantidade();
	}
	

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}	
	
	

}
