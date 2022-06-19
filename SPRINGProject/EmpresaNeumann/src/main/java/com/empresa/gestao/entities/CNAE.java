package com.empresa.gestao.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "cnaes")
public class CNAE {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numero;
	
	private Fornecedor fornecedor;
	
	public String getNumero() {	return numero;	}
	public void setNumero(String numero) {	this.numero = numero;	}
	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}
	public Fornecedor getFornecedor() {	return fornecedor;	}
	public void setFornecedor(Fornecedor fornecedor) {	this.fornecedor = fornecedor;	}
}
