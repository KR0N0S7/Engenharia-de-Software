package com.empresa.gestao.entities;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.empresa.gestao.dao.annotations.ChaveEstrangeira;

@Table(name = "estados")
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private String sigla;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@ChaveEstrangeira
	private Pais pais;
	
	public Estado() {	}

	public Estado(String descricao, String sigla) {
		this.descricao = descricao;
		this.sigla = sigla;
	}

	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}
	public String getDescricao() {	return descricao;	}
	public void setDescricao(String descricao) {	this.descricao = descricao;	}
	public String getSigla() {	return sigla;	}
	public void setSigla(String sigla) {	this.sigla = sigla;	}
	public Pais getPais() {	return pais;	}
	public void setPais(Pais pais) {	this.pais = pais;	}
}
