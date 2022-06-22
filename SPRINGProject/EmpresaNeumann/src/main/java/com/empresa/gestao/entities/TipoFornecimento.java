package com.empresa.gestao.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tipo_fornecimento")
public class TipoFornecimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "tipo_fornecimento")
	private String tipoFornecimento;
	
	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}
	public String getTipoFornecimento() {	return tipoFornecimento;	}
	public void setTipoFornecimento(String tipoFornecimento) {	this.tipoFornecimento = tipoFornecimento;}
	
}
