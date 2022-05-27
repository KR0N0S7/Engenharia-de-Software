package com.empresa.gestao.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String descricao;
	
	@ManyToMany(mappedBy = "produtos")
	private List<Fornecedor> fornecedores;
	
	public int getId() {	return id;	}
	public void setId(int id) {	this.id = id;	}
	public String getNome() {	return nome;	}
	public void setNome(String nome) {	this.nome = nome;	}
	public String getDescricao() {	return descricao;	}
	public void setDescricao(String descricao) {	this.descricao = descricao;	}
	public List<Fornecedor> getFornecedor() {	return fornecedores;	}
	public void setFornecedor(List<Fornecedor> fornecedores) {	this.fornecedores = fornecedores;	}
}
