package com.empresa.gestao.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Entity
//@Table(name = "paises")
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	
//	@OneToMany(mappedBy = "pais")
//	private List<Estado> estados;
	
	public Pais() {	}

	public Pais(String descricao) {
		this.descricao = descricao;
	}
	
	public Pais(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}
	public String getDescricao() {	return descricao;	}
	public void setDescricao(String descricao) {	this.descricao = descricao;	}
//	public List<Estado> getEstados() {	return estados;	}
//	public void setEstados(List<Estado> estados) {	this.estados = estados;	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", descricao=" + descricao + "]";
	}
	
	
}
