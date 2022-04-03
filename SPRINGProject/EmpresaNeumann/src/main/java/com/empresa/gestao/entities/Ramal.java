package com.empresa.gestao.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Ramal extends Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String codigo;
	private String descricao;
	
	public long getId() {	return id;	}
	public void setId(long id) {	this.id = id;	}	
	public String getCodigo() {	return codigo;	}
	public void setCodigo(String codigo) {	this.codigo = codigo;	}
	public String getDescricao() {	return descricao;	}
	public void setDescricao(String descricao) {	this.descricao = descricao;	}
}
