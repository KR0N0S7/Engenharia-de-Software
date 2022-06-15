package com.empresa.gestao.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Entity
@Table(name = "tipos_telefones")
public class TipoTelefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	
//	@OneToMany(mappedBy = "tipoTelefone")
//	private List<Telefone> telefones;
//	
//	public List<Telefone> getTelefone() {	return telefones;	}
//	public void setTelefone(List<Telefone> telefones) {	this.telefones = telefones;	}
	public String getDescricao() {	return descricao;	}
	public void setDescricao(String descricao) {	this.descricao = descricao;	}
	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}
}
