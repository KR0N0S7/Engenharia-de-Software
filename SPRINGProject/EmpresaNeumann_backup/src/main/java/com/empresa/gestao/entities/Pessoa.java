package com.empresa.gestao.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Entity
//@Table(name = "pessoas")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
//	@OneToMany(mappedBy = "pessoa")
//	private List<Usuario> usuarios;
	
	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}	
	public String getNome() {	return nome;	}
	public void setNome(String nome) {	this.nome = nome;	}
//	public List<Usuario> getUsuarios() {	return usuarios;	}
//	public void setUsuarios(List<Usuario> usuarios) {	this.usuarios = usuarios;	}
}
