package com.empresa.gestao.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String descricao;
	
	@OneToMany(mappedBy = "pais")
	private List<Estado> estados;
	
	public long getId() {	return id;	}
	public void setId(long id) {	this.id = id;	}
	public String getDescricao() {	return descricao;	}
	public void setDescricao(String descricao) {	this.descricao = descricao;	}
	public List<Estado> getEstados() {	return estados;	}
	public void setEstados(List<Estado> estados) {	this.estados = estados;	}
	
	
}
