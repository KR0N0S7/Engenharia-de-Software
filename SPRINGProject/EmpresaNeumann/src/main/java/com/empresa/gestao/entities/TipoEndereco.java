package com.empresa.gestao.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_enderecos")
public class TipoEndereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String descricao;
	
	@OneToMany(mappedBy = "tipoEndereco")
	private List<Endereco> enderecos;
	
	public long getId() {	return id;	}
	public void setId(long id) {	this.id = id;	}
	public String getNome() {	return nome;	}
	public void setNome(String nome) {	this.nome = nome;	}
	public String getDescricao() {	return descricao;	}
	public void setDescricao(String descricao) {	this.descricao = descricao;	}
	public List<Endereco> getEnderecos() {	return enderecos;	}
	public void setEnderecos(List<Endereco> enderecos) {	this.enderecos = enderecos;	}
	
	
}
