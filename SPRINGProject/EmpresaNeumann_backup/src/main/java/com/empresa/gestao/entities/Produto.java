package com.empresa.gestao.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Entity
//@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	
//	@ManyToOne
//	private Fornecedor fornecedor;
	
	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}
	public String getNome() {	return nome;	}
	public void setNome(String nome) {	this.nome = nome;	}
	public String getDescricao() {	return descricao;	}
	public void setDescricao(String descricao) {	this.descricao = descricao;	}
//	public Fornecedor getFornecedor() {	return fornecedor;	}
//	public void setFornecedor(Fornecedor fornecedor) {	this.fornecedor = fornecedor;	}

}
