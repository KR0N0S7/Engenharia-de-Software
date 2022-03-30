package com.empresa.gestao.entities;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class CNAE {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String numero;
	
	@ManyToMany
	private List<Fornecedor> fornecedores;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public List<Fornecedor> getFornecedor() {
		return fornecedores;
	}
	public void setFornecedor(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
