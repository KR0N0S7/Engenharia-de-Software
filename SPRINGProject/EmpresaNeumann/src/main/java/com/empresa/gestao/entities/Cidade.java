package com.empresa.gestao.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String descricao;
	
	@ManyToOne
	private Estado estado;
	
	@OneToMany(mappedBy = "cidade")
	private List<Endereco> enderecos;
	
	public long getId() {	return id;	}
	public void setId(long id) {	this.id = id;	}
	public String getDescricao() {	return descricao;	}
	public void setDescricao(String descricao) {	this.descricao = descricao;	}
	public Estado getEstado() {		return estado;	}	
	public void setEstado(Estado estado) {	this.estado = estado;	}
	public List<Endereco> getEnderecos() {	return enderecos;	}
	public void setEnderecos(List<Endereco> enderecos) {	this.enderecos = enderecos;	}
	
	
}
