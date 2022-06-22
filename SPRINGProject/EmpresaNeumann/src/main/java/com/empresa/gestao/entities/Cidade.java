package com.empresa.gestao.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.empresa.gestao.dao.annotations.ChaveEstrangeira;

@Table(name = "cidades")
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	
	@ChaveEstrangeira
	private Estado estado;
	
	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}
	public String getDescricao() {	return descricao;	}
	public void setDescricao(String descricao) {	this.descricao = descricao;	}
	public Estado getEstado() {		return estado;	}	
	public void setEstado(Estado estado) {	this.estado = estado;	}
}
